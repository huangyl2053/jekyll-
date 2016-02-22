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
     */
    public DaisanshaKouiHigaitodokeKaigoHokenyoItem(RString ninshoshaYakushokuMei,
            RString ninteiYukoKikanKaishiYMD,
            RString ninteiYukoKikanShuryoYMD,
            RString birthYMD,
            RString hihokenshaName,
            RString hihokenshaNameKana,
            RString hihokenshaNo,
            RString hokenshaNo,
            RString remban,
            RString yokaigoJotaiKubun) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
        this.hokenshaNo = hokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaNameKana = hihokenshaNameKana;
        this.hihokenshaName = hihokenshaName;
        this.birthYMD = birthYMD;
        this.remban = remban;
        this.yokaigoJotaiKubun = yokaigoJotaiKubun;
    }
}
