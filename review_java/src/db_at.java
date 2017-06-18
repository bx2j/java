/*
 * Advantage training - 주가데이터 테이블 생성
 * 2017.06.02
 * prepared by 배병주
 * 수정사항
 * 	최초 작성
 * 	2017.06.03 -> 2번째 필드 ^ 제거 추가
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class db_at {
   public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
	   Class.forName("com.mysql.jdbc.Driver"); // mysql connection 드라이버 로딩 (없으면 cnf 예외발생)
	   Connection conn = DriverManager.getConnection(
			   "jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false", "root", "1q2w3e");
	   			// jdbc:mysql://localhost/dbname , dbuser, dbpassword
	   Statement stmt = conn.createStatement(); // statement 객체 생성
	   PreparedStatement pstmt = null; // PreparedStamtent 객체 생성
	   //stmt.execute("delete from stock"); // stock 테이블 내용 삭제
	   stmt.execute("create table stock( " // stock 테이블 생성
	   + "stnd_iscd varchar(100) not null, " // 표준 종목코드	   
	   + "bsop_date date not null, " // 주식 영업 일자
	   + "shrn_iscd varchar(100) not null, " // 유가증권 단축 종목코드
	   + "stck_prpr int, " // 주식 종가
	   + "stck_oprc int, " // 주식 시가
	   + "stck_hgpr int, " // 주식 최고가
	   + "stck_lwpr int, " // 주식 최저가
	   + "prdy_vrss_sign varchar(100), " // 전일 대비 부호
	   + "prdy_vrss int, " // 전일 대비
	   + "prdy_ctrt double, " // 전일 대비율
	   + "prdy_vol bigint, " // 전일 거래량
	   + "acml_vol bigint, " // 누적 거래량
	   + "acml_tr_pbmn bigint, " // 누적 거래 대금
	   + "askp1 int, " // 매도호가1
	   + "bidp1 int, " // 매수호가1
	   + "total_askp_rsqn bigint, " // 총 매도호가 잔량
	   + "total_bidp_rsqn bigint, " // 총 매수호가 잔량
	   + "seln_cntg_smtn bigint, " // 매도 체결 합계
	   + "shnu_cntg_smtn bigint, " // 매수 체결 합걔
	   + "seln_tr_pbmn bigint, " // 매도 거래 대금(누적)
	   + "shnu_tr_pbmn bigint, " // 매수 거래 대금(누적)
	   + "seln_cntg_csnu int, " // 매도 체결 건수
	   + "shnu_cntg_csnu int, " // 매수 체결 건수
	   + "w52_hgpr int, " // 52주일 최고가
	   + "w52_lwpr int, " // 52주일 최저가
	   + "w52_hgpr_date date, " // 52주일 최고가 일자
	   + "w52_lwpr_date date, " // 52주일 최저가 일자
	   + "ovtm_untp_bsop_hour int, " // 시간외 단일가 최종 시간
	   + "ovtm_untp_prpr int, " // 시간외 단일가 현재가
	   + "ovtm_untp_prdy_vrss int, " // 시간외 단일가 전일 대비
	   + "ovtm_untp_prdy_vrss_sign varchar(100), " // 시간외 단일가 전일 대비 부호
	   + "ovtm_untp_askp1 int, " // 시간외 단일가 매도호가1
	   + "ovtm_untp_bidp1 int, " // 시간외 단일가 매수호가1
	   + "ovtm_untp_vol bigint, " // 시간외 단일가 거래량
	   + "ovtm_untp_tr_pbmn bigint, " // 시간외 단일가 거래 대금
	   + "ovtm_untp_oprc int, " // 시간외 단일가 시가
	   + "ovtm_untp_hgpr int, " // 시간외 단일가 최고가
	   + "ovtm_untp_lwpr int, " // 시간외 단일가 최저가
	   + "mkob_otcp_vol bigint, " // 장개시전 시간외종가 거래량
	   + "mkob_otcp_tr_pbmn bigint, " // 장개시전 시간외종가 거래 대금
	   + "mkfa_otcp_vol bigint, " // 장종료후 시간외종가 거래량
	   + "mkfa_otcp_tr_pbmn bigint, " //  장종료후 시간외종가 거래 대금
	   + "mrkt_div_cls_code varchar(100), " // 시장 분류 구분 코드
	   + "pstc_dvdn_amt bigint, " // 주당 배당 금액
	   + "lstn_stcn bigint, " // 상장 주수
	   + "stck_sdpr int, " // 주식 기준가
	   + "stck_fcam double, " // 주식 액면가
	   + "wghn_avrg_stck_prc double, " // 가중 평균 주식 가격
	   + "issu_limt_rate double, " // 종목 한도 비율
	   + "frgn_limt_qty bigint, " // 외국인 한도 수량
	   + "oder_able_qty bigint, " // 주문 가능 수량
	   + "frgn_limt_exhs_cls_code varchar(100), " // 외국인 한도 소진 구분 코드
	   + "frgn_hldn_qty bigint, "  // 외국인 보유 수량
	   + "frgn_hldn_rate double, " // 외국인 보유 비율
	   + "hts_frgn_ehrt double, " // HTS 외국인 소진율
	   + "itmt_last_nav double, " // 장중 최종 NAV 
	   + "prdy_last_nav double, " // 전일 최종 NAV
	   + "trc_errt double, " // 추적 오차율
	   + "dprt double, " // 괴리율
	   + "ssts_cntg_qty bigint, " // 공매도차입증권매도체결수량
	   + "ssts_tr_pbmn bigint, " // 공매도차입증권매도거래대금
	   + "frgn_ntby_qty bigint, " // 외국인 순매수
	   + "flng_cls_code varchar(100), " // 락구분 코드
	   + "prtt_rate double, " // 분할 비율
	   + "acml_prtt_rate double, " // 누적 분할 비율
	   + "stdv double, " // 전체 융자잔고비율
	   + "beta_cfcn double, " // 베타 계수(90일)
	   + "crlt_cfcn double, " // DEL 상관 계수
	   + "bull_beta double, " // DEL 강세 계수
	   + "bear_beta double, " // DEL 약세 계수
	   + "bull_dvtn double, " // DEL 강세 편차
	   + "bear_dvtn double, " // DEL 약세 편차
	   + "bull_crlt double, " // DEL 강세 상관계수
	   + "bear_crlt double, " // DEL 약세 상관계수
	   + "stck_mxpr int, " // 주식 상한가
	   + "stck_llam int, " // 주식 하한가
	   + "icic_cls_code varchar(100), " // 증자 구분 코드
	   + "itmt_vol bigint, " // 장중 거래량
	   + "itmt_tr_pbmn bigint, " // 장중 거래대금
	   + "fcam_mod_cls_code varchar(100), " // 액면가 변경 구분 코드
	   + "revl_issu_reas_code varchar(100), " // 재평가 종목 사유 코드
	   + "orgn_ntby_qty bigint, " // 기관계 순매수
	   + "adj_prpr int, " // 수정주가
	   + "fn_oprc int, " // 주식 시가  
	   + "fn_hgpr int, " // 주식 최고가   
	   + "fn_lwpr int, " // 주식 최저가
	   + "fn_prpr int, " // 주식 종가
	   + "fn_acml_vol bigint, " // 누적 거래량
	   + "fn_acml_tr_pbmn bigint, " // 누적 거래 대금
	   + "fn_prtt_rate double, " // 분할 비율
	   + "fn_flng_cls_code varchar(100), " // 락구분 코드	
	   // 0-정상,1-권리,2-배당,3-권배락,
	   // 4-신규상장,5-액면분할,6-신주상장,/
	   // 8-비공모고신규상장, 9-거래정지 : 락구분
	   + "buyin_nor_prpr int, " // Buy-in 일반 체결가
	   + "buyin_nor_prdy_vrss int, " // Buy-in 일반 종가 대비
	   + "buyin_nor_vol bigint, " //  Buy-in 일반 체결량
	   + "buyin_nor_tr_pbmn bigint, " // Buy-in 일반 체결 대금
	   + "buyin_tod_prpr int, " // Buy-in 당일 체결가
	   + "buyin_tod_prdy_vrss int, " // Buy-in 당일 종가 대비
	   + "buyin_tod_vol bigint, " // Buy-in 당일 체결량
	   + "buyin_tod_tr_pbmn bigint," // Buy-in 당일 체결 대금
	   + "primary key(stnd_iscd,bsop_date)) " // 주키 = 종목코드 + 영업 일자
	   + "default charset=utf8;");
	   conn.setAutoCommit(false); // AutoCommit 설정을 False로 설정하여 자동 Commit을 하지 못하도록 설정
      
	   //주가데이터 파일 읽기
	   File f = new File("\\\\192.168.23.161\\sw(교안)\\웹서버클라이언트\\자바복습\\실습데이터\\day_data\\THTSKS010H00.dat"); 
	   //파일 경로 지정
	   BufferedReader br = new BufferedReader(new FileReader(f)); //버퍼를 사용하여 파일 읽기
      
	   String readtxt2; // 파일 읽은 내용을 저장하는 변수
      
	   pstmt = conn.prepareStatement("insert into stock VALUES(" // stock 테이블에 insert
			   + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	   int cnt = 0;
	   long st = System.currentTimeMillis(); // 시작 시간
	   while((readtxt2 = br.readLine()) != null ){ // 주가 파일 읽는 반복문
		   String field2[] = readtxt2.split("%_%"); // %_%단위로 구분	   
		   // 필드 길이가 2 이상이고 2번째 필드에 A로 시작하는 거에서 ^ 없애고 처리
		   if(field2.length > 2  && field2[2].replace("^", "").trim().substring(0, 1).equals("A")){
			   // 반복문을 사용하여 필드 정제
			   for(int i = 0; i < 99; i++){
				   field2[i] = field2[i].replace("^", "").trim(); // 필드에 있는 ^,공백 제거
				   if(field2[i].equals("")){ // 만약 필드 값이 없으면 0으로 치환
					   field2[i] = "0";
				   }
				   if(field2[25].equals("0")){ // date 테이블에 들어갈 값이 0인 경우 1980년 01월 01일로 치환
					   field2[25] ="19800101";
				   }
				   if(field2[26].equals("0")){
					   field2[26] ="19800101";
				   }
				   pstmt.setString(i+1, field2[i]); // 99개의 컬럼에 데이터 입력
			   }
			   pstmt.addBatch(); // 배치에 담음
			   cnt++; //반복문 실행 횟수 카운트
			   if((cnt % 100000) == 0){ // 100000건 단위로 배치에 담긴 내용 실행 및 commit
				   pstmt.executeBatch();
				   conn.commit();
			   }
		   }
	   }
	   pstmt.executeBatch(); // 배치 후 남은 나머지 실행 및 commit
	   conn.commit();
	   System.out.printf("Program End[%d]records\n", cnt); // 레코드 처리 수 출력
	   long et = System.currentTimeMillis(); // 종료 시간
	   System.out.printf("경과시간 : %dms\n", et - st); // 총 경과 시간
	   br.close(); // br 객체 반환
	   pstmt.close(); // pstmt 객체 반환
	   stmt.close(); // stmt 객체 반환
	   conn.close(); // conn 객체 반환
   }
}