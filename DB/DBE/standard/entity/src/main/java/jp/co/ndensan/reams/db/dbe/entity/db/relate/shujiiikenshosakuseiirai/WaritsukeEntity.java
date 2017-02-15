/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
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
 * 割付済み申請者一覧の取得のEntityクラスです。(主治医意見書作成依頼画面)
 * 
 * @author n3213
 */
@Getter
@Setter
public class WaritsukeEntity {

    private Code koroshoIfShikibetsuCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiKubunCode;
    private ChikuCode chikuCode;
    private Code ikenshoIraiKubun;
    private AtenaJusho jusho;
    private AtenaKanaMeisho hihokenshaKana;
    private FlexibleDate seinengappiYMD;
    private YubinNo yubinNo;
    private TelNo telNo;
    private FlexibleDate ninteiShinseiYMDKoShin;
    private FlexibleDate zenkaiNinteiYMD;
    private Code zenYokaigoKubunCode;
    private int age;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoSakuseiKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate ikenshoShutsuryokuYMD;
    private FlexibleDate seikyushoShutsuryokuYMD;
    private Code sakuseiryoSeikyuKubun;
    private RString iryoKikanMeisho;
    private AtenaMeisho shujiiName;
    private RString temp_iryoKikanMeisho;
    private AtenaMeisho temp_shujiiName;
    private RString temp_jigyoshaMeisho;
    private RString temp_chosainShimei;
    private RString shinseishoKanriNo;
    private RString hokenshaNo;
    private RString shichosonCode;
    private int ikenshoIraiRirekiNo;
    private DbT5105NinteiKanryoJohoEntity ninteiKanryoJohoEntity;
    private DbT5301ShujiiIkenshoIraiJohoEntity shujiiIkenshoIraiJohoEntity;
    
    /**
     * MD5値を計算し、設定します。
     */
    public void initializeMd5() {
        if (ninteiKanryoJohoEntity != null) {
            ninteiKanryoJohoEntity.initializeMd5();
        }
        if (shujiiIkenshoIraiJohoEntity != null) {
            shujiiIkenshoIraiJohoEntity.initializeMd5();
        }
    }
}
