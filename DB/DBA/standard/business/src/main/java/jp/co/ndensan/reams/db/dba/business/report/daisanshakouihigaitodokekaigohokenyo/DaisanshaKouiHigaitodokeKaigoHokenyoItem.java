/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 第三者行為による被害届（介護保険用）のEntityリストです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DaisanshaKouiHigaitodokeKaigoHokenyoItem {

    private final RString ninshoshaYakushokuMei;
    private final RString ninteiYukoKikanKaishiYMD;
    private final RString ninteiYukoKikanShuryoYMD;
    private final RString remban;
    private final RString yokaigoJotaiKubun;
    private final RString hokenshaNo;
    private final RString hihokenshaNo;
    private final RString hihokenshaNameKana;
    private final RString hihokenshaName;
    private final RString birthYMD;
    private final RString todokedeKanriNo;
    private final RString noticeYMD;
    private final RString yubinNo;
    private final RString jusho;
    private final RString name;
    private final RString honorificAppellation;
    private final RString customerBarCode;
    private final RString serviceName;
    private final RString serviceShiName;
    private final RString servicePrint;
    private final RString inquiryJusho;
    private final RString shichosonCode;
    private final RString inquiryDeploy;
    private final RString telNo;
    private final RString inquiryTelNo;

    /**
     * コンストラクタです。
     *
     * @param ninshoshaYakushokuMei 認証者役職名
     * @param ninteiYukoKikanKaishiYMD 認定有効期間開始日
     * @param ninteiYukoKikanShuryoYMD 認定有効期間終了日
     * @param remban 連番
     * @param yokaigoJotaiKubun 要介護状態区分
     * @param hokenshaNo 保険者番号
     * @param hihokenshaNo 被保険者番号
     * @param hihokenshaNameKana フリガナ
     * @param hihokenshaName 被保険者名称
     * @param birthYMD 生年月日
     * @param todokedeKanriNo 被害届通知番号
     * @param noticeYMD 通知年月日
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param name 氏名
     * @param honorificAppellation 敬称
     * @param customerBarCode カスタマーバーコード
     * @param serviceName 役職名
     * @param serviceShiName 役職氏名
     * @param servicePrint 役職印
     * @param inquiryJusho 問合せ住所
     * @param shichosonCode 問合せ市町村名
     * @param inquiryDeploy 問合せ部署
     * @param telNo 問合せ電話番号
     * @param inquiryTelNo 問合せ内線電話番号
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoItem(RString ninshoshaYakushokuMei,
            RString ninteiYukoKikanKaishiYMD,
            RString ninteiYukoKikanShuryoYMD,
            RString remban,
            RString yokaigoJotaiKubun,
            RString hokenshaNo,
            RString hihokenshaNo,
            RString hihokenshaNameKana,
            RString hihokenshaName,
            RString birthYMD,
            RString todokedeKanriNo,
            RString noticeYMD,
            RString yubinNo,
            RString jusho,
            RString name,
            RString honorificAppellation,
            RString customerBarCode,
            RString serviceName,
            RString serviceShiName,
            RString servicePrint,
            RString inquiryJusho,
            RString shichosonCode,
            RString inquiryDeploy,
            RString telNo,
            RString inquiryTelNo) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
        this.remban = remban;
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.todokedeKanriNo = todokedeKanriNo;
        this.noticeYMD = noticeYMD;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.name = name;
        this.honorificAppellation = honorificAppellation;
        this.customerBarCode = customerBarCode;
        this.serviceName = serviceName;
        this.serviceShiName = serviceShiName;
        this.servicePrint = servicePrint;
        this.inquiryJusho = inquiryJusho;
        this.shichosonCode = shichosonCode;
        this.inquiryDeploy = inquiryDeploy;
        this.telNo = telNo;
        this.inquiryTelNo = inquiryTelNo;
    }
}
