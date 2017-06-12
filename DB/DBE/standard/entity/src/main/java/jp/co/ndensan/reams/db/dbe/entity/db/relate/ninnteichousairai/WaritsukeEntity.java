/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousairai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 割付済み申請者一覧の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class WaritsukeEntity {

    private Code koroshoIfShikibetsuCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiKubunCode;
    private ChikuCode chikuCode;
    private Code chosaKubun;
    private AtenaJusho jusho;
    private AtenaKanaMeisho hihokenshaKana;
    private FlexibleDate seinengappiYMD;
    private YubinNo yubinNo;
    private TelNo telNo;
    private YubinNo homonChosasakiYubinNo;
    private AtenaJusho homonChosasakiJusho;
    private AtenaMeisho homonChosasakiName;
    private TelNo homonChosasakiTelNo;
    private FlexibleDate ninteiShinseiYMDKoShin;
    private FlexibleDate zenkaiNinteiYMD;
    private Code zenYokaigoKubunCode;
    private int age;
    private int waritsukeTeiin;
    private RString iryoKikanMeisho;
    private AtenaMeisho shujiiName;
    private int chosaKanoNinzuPerMonth;
    private RString temp_jigyoshaMeisho;
    private RString temp_iryoKikanMeisho;
    private AtenaMeisho temp_shujiiName;
    private RString temp_chosainShimei;
    private RString shinseishoKanriNo;
    private int ninteichosaIraiRirekiNo;
    private RString ninteiChosainCode;
    private RString hokenshaNo;
    private RString hokenshaName;
    private RString shichosonCode;
    private RString renrakusakiTuzukigara;
    private YubinNo renrakusakiYubinNo;
    private AtenaJusho renrakusakiJusho;
    private TelNo renrakusakiTelNo;
    private TelNo renrakusakiKeitaiTelNo;
    private AtenaMeisho renrakusakiShimei;
    private DbT5105NinteiKanryoJohoEntity 認定完了情報Entity;
    private DbT5201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;

    /**
     * MD5値を計算し、設定します。
     */
    public void initializeMd5() {
        認定完了情報Entity.initializeMd5();
        認定調査依頼情報Entity.initializeMd5();
    }
}
