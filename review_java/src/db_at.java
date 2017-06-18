/*
 * Advantage training - �ְ������� ���̺� ����
 * 2017.06.02
 * prepared by �躴��
 * ��������
 * 	���� �ۼ�
 * 	2017.06.03 -> 2��° �ʵ� ^ ���� �߰�
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
	   Class.forName("com.mysql.jdbc.Driver"); // mysql connection ����̹� �ε� (������ cnf ���ܹ߻�)
	   Connection conn = DriverManager.getConnection(
			   "jdbc:mysql://192.168.23.91:330/test?useSSL=true&verifyServerCertificate=false", "root", "1q2w3e");
	   			// jdbc:mysql://localhost/dbname , dbuser, dbpassword
	   Statement stmt = conn.createStatement(); // statement ��ü ����
	   PreparedStatement pstmt = null; // PreparedStamtent ��ü ����
	   //stmt.execute("delete from stock"); // stock ���̺� ���� ����
	   stmt.execute("create table stock( " // stock ���̺� ����
	   + "stnd_iscd varchar(100) not null, " // ǥ�� �����ڵ�	   
	   + "bsop_date date not null, " // �ֽ� ���� ����
	   + "shrn_iscd varchar(100) not null, " // �������� ���� �����ڵ�
	   + "stck_prpr int, " // �ֽ� ����
	   + "stck_oprc int, " // �ֽ� �ð�
	   + "stck_hgpr int, " // �ֽ� �ְ�
	   + "stck_lwpr int, " // �ֽ� ������
	   + "prdy_vrss_sign varchar(100), " // ���� ��� ��ȣ
	   + "prdy_vrss int, " // ���� ���
	   + "prdy_ctrt double, " // ���� �����
	   + "prdy_vol bigint, " // ���� �ŷ���
	   + "acml_vol bigint, " // ���� �ŷ���
	   + "acml_tr_pbmn bigint, " // ���� �ŷ� ���
	   + "askp1 int, " // �ŵ�ȣ��1
	   + "bidp1 int, " // �ż�ȣ��1
	   + "total_askp_rsqn bigint, " // �� �ŵ�ȣ�� �ܷ�
	   + "total_bidp_rsqn bigint, " // �� �ż�ȣ�� �ܷ�
	   + "seln_cntg_smtn bigint, " // �ŵ� ü�� �հ�
	   + "shnu_cntg_smtn bigint, " // �ż� ü�� �հ�
	   + "seln_tr_pbmn bigint, " // �ŵ� �ŷ� ���(����)
	   + "shnu_tr_pbmn bigint, " // �ż� �ŷ� ���(����)
	   + "seln_cntg_csnu int, " // �ŵ� ü�� �Ǽ�
	   + "shnu_cntg_csnu int, " // �ż� ü�� �Ǽ�
	   + "w52_hgpr int, " // 52���� �ְ�
	   + "w52_lwpr int, " // 52���� ������
	   + "w52_hgpr_date date, " // 52���� �ְ� ����
	   + "w52_lwpr_date date, " // 52���� ������ ����
	   + "ovtm_untp_bsop_hour int, " // �ð��� ���ϰ� ���� �ð�
	   + "ovtm_untp_prpr int, " // �ð��� ���ϰ� ���簡
	   + "ovtm_untp_prdy_vrss int, " // �ð��� ���ϰ� ���� ���
	   + "ovtm_untp_prdy_vrss_sign varchar(100), " // �ð��� ���ϰ� ���� ��� ��ȣ
	   + "ovtm_untp_askp1 int, " // �ð��� ���ϰ� �ŵ�ȣ��1
	   + "ovtm_untp_bidp1 int, " // �ð��� ���ϰ� �ż�ȣ��1
	   + "ovtm_untp_vol bigint, " // �ð��� ���ϰ� �ŷ���
	   + "ovtm_untp_tr_pbmn bigint, " // �ð��� ���ϰ� �ŷ� ���
	   + "ovtm_untp_oprc int, " // �ð��� ���ϰ� �ð�
	   + "ovtm_untp_hgpr int, " // �ð��� ���ϰ� �ְ�
	   + "ovtm_untp_lwpr int, " // �ð��� ���ϰ� ������
	   + "mkob_otcp_vol bigint, " // �尳���� �ð������� �ŷ���
	   + "mkob_otcp_tr_pbmn bigint, " // �尳���� �ð������� �ŷ� ���
	   + "mkfa_otcp_vol bigint, " // �������� �ð������� �ŷ���
	   + "mkfa_otcp_tr_pbmn bigint, " //  �������� �ð������� �ŷ� ���
	   + "mrkt_div_cls_code varchar(100), " // ���� �з� ���� �ڵ�
	   + "pstc_dvdn_amt bigint, " // �ִ� ��� �ݾ�
	   + "lstn_stcn bigint, " // ���� �ּ�
	   + "stck_sdpr int, " // �ֽ� ���ذ�
	   + "stck_fcam double, " // �ֽ� �׸鰡
	   + "wghn_avrg_stck_prc double, " // ���� ��� �ֽ� ����
	   + "issu_limt_rate double, " // ���� �ѵ� ����
	   + "frgn_limt_qty bigint, " // �ܱ��� �ѵ� ����
	   + "oder_able_qty bigint, " // �ֹ� ���� ����
	   + "frgn_limt_exhs_cls_code varchar(100), " // �ܱ��� �ѵ� ���� ���� �ڵ�
	   + "frgn_hldn_qty bigint, "  // �ܱ��� ���� ����
	   + "frgn_hldn_rate double, " // �ܱ��� ���� ����
	   + "hts_frgn_ehrt double, " // HTS �ܱ��� ������
	   + "itmt_last_nav double, " // ���� ���� NAV 
	   + "prdy_last_nav double, " // ���� ���� NAV
	   + "trc_errt double, " // ���� ������
	   + "dprt double, " // ������
	   + "ssts_cntg_qty bigint, " // ���ŵ��������Ǹŵ�ü�����
	   + "ssts_tr_pbmn bigint, " // ���ŵ��������Ǹŵ��ŷ����
	   + "frgn_ntby_qty bigint, " // �ܱ��� ���ż�
	   + "flng_cls_code varchar(100), " // ������ �ڵ�
	   + "prtt_rate double, " // ���� ����
	   + "acml_prtt_rate double, " // ���� ���� ����
	   + "stdv double, " // ��ü �����ܰ����
	   + "beta_cfcn double, " // ��Ÿ ���(90��)
	   + "crlt_cfcn double, " // DEL ��� ���
	   + "bull_beta double, " // DEL ���� ���
	   + "bear_beta double, " // DEL �༼ ���
	   + "bull_dvtn double, " // DEL ���� ����
	   + "bear_dvtn double, " // DEL �༼ ����
	   + "bull_crlt double, " // DEL ���� ������
	   + "bear_crlt double, " // DEL �༼ ������
	   + "stck_mxpr int, " // �ֽ� ���Ѱ�
	   + "stck_llam int, " // �ֽ� ���Ѱ�
	   + "icic_cls_code varchar(100), " // ���� ���� �ڵ�
	   + "itmt_vol bigint, " // ���� �ŷ���
	   + "itmt_tr_pbmn bigint, " // ���� �ŷ����
	   + "fcam_mod_cls_code varchar(100), " // �׸鰡 ���� ���� �ڵ�
	   + "revl_issu_reas_code varchar(100), " // ���� ���� ���� �ڵ�
	   + "orgn_ntby_qty bigint, " // ����� ���ż�
	   + "adj_prpr int, " // �����ְ�
	   + "fn_oprc int, " // �ֽ� �ð�  
	   + "fn_hgpr int, " // �ֽ� �ְ�   
	   + "fn_lwpr int, " // �ֽ� ������
	   + "fn_prpr int, " // �ֽ� ����
	   + "fn_acml_vol bigint, " // ���� �ŷ���
	   + "fn_acml_tr_pbmn bigint, " // ���� �ŷ� ���
	   + "fn_prtt_rate double, " // ���� ����
	   + "fn_flng_cls_code varchar(100), " // ������ �ڵ�	
	   // 0-����,1-�Ǹ�,2-���,3-�ǹ��,
	   // 4-�űԻ���,5-�׸����,6-���ֻ���,/
	   // 8-������űԻ���, 9-�ŷ����� : ������
	   + "buyin_nor_prpr int, " // Buy-in �Ϲ� ü�ᰡ
	   + "buyin_nor_prdy_vrss int, " // Buy-in �Ϲ� ���� ���
	   + "buyin_nor_vol bigint, " //  Buy-in �Ϲ� ü�ᷮ
	   + "buyin_nor_tr_pbmn bigint, " // Buy-in �Ϲ� ü�� ���
	   + "buyin_tod_prpr int, " // Buy-in ���� ü�ᰡ
	   + "buyin_tod_prdy_vrss int, " // Buy-in ���� ���� ���
	   + "buyin_tod_vol bigint, " // Buy-in ���� ü�ᷮ
	   + "buyin_tod_tr_pbmn bigint," // Buy-in ���� ü�� ���
	   + "primary key(stnd_iscd,bsop_date)) " // ��Ű = �����ڵ� + ���� ����
	   + "default charset=utf8;");
	   conn.setAutoCommit(false); // AutoCommit ������ False�� �����Ͽ� �ڵ� Commit�� ���� ���ϵ��� ����
      
	   //�ְ������� ���� �б�
	   File f = new File("\\\\192.168.23.161\\sw(����)\\������Ŭ���̾�Ʈ\\�ڹٺ���\\�ǽ�������\\day_data\\THTSKS010H00.dat"); 
	   //���� ��� ����
	   BufferedReader br = new BufferedReader(new FileReader(f)); //���۸� ����Ͽ� ���� �б�
      
	   String readtxt2; // ���� ���� ������ �����ϴ� ����
      
	   pstmt = conn.prepareStatement("insert into stock VALUES(" // stock ���̺� insert
			   + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
               + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	   int cnt = 0;
	   long st = System.currentTimeMillis(); // ���� �ð�
	   while((readtxt2 = br.readLine()) != null ){ // �ְ� ���� �д� �ݺ���
		   String field2[] = readtxt2.split("%_%"); // %_%������ ����	   
		   // �ʵ� ���̰� 2 �̻��̰� 2��° �ʵ忡 A�� �����ϴ� �ſ��� ^ ���ְ� ó��
		   if(field2.length > 2  && field2[2].replace("^", "").trim().substring(0, 1).equals("A")){
			   // �ݺ����� ����Ͽ� �ʵ� ����
			   for(int i = 0; i < 99; i++){
				   field2[i] = field2[i].replace("^", "").trim(); // �ʵ忡 �ִ� ^,���� ����
				   if(field2[i].equals("")){ // ���� �ʵ� ���� ������ 0���� ġȯ
					   field2[i] = "0";
				   }
				   if(field2[25].equals("0")){ // date ���̺� �� ���� 0�� ��� 1980�� 01�� 01�Ϸ� ġȯ
					   field2[25] ="19800101";
				   }
				   if(field2[26].equals("0")){
					   field2[26] ="19800101";
				   }
				   pstmt.setString(i+1, field2[i]); // 99���� �÷��� ������ �Է�
			   }
			   pstmt.addBatch(); // ��ġ�� ����
			   cnt++; //�ݺ��� ���� Ƚ�� ī��Ʈ
			   if((cnt % 100000) == 0){ // 100000�� ������ ��ġ�� ��� ���� ���� �� commit
				   pstmt.executeBatch();
				   conn.commit();
			   }
		   }
	   }
	   pstmt.executeBatch(); // ��ġ �� ���� ������ ���� �� commit
	   conn.commit();
	   System.out.printf("Program End[%d]records\n", cnt); // ���ڵ� ó�� �� ���
	   long et = System.currentTimeMillis(); // ���� �ð�
	   System.out.printf("����ð� : %dms\n", et - st); // �� ��� �ð�
	   br.close(); // br ��ü ��ȯ
	   pstmt.close(); // pstmt ��ü ��ȯ
	   stmt.close(); // stmt ��ü ��ȯ
	   conn.close(); // conn ��ü ��ȯ
   }
}