/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_13;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_13;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_13;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B2015_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_20;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyogaikyochosa.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteischedule.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5209NinteichosahyoKinyuItemDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1Handler {

    private final NinnteiChousaKekkaTouroku1Div div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会対象者割付
     */
    public NinnteiChousaKekkaTouroku1Handler(NinnteiChousaKekkaTouroku1Div div) {
        this.div = div;
    }
    
    public void initialize() {
        
        //TODO DBZ.KaigoNinteiShinseishaInfoのinitializeは未作成です
        //div.getCcdKaigoNinteiShinseishaInfo()
        //TODO DBZ.NinteiShinseiRenrakusakiKihonのinitializeメソッドは未作成です
        //div.getCcdNinteiShinseiRenrakusakiKihon()
        //TODO DBZ.ChosaJisshishaJohoのinitializeメソッドは未作成です
        //div.getCcdChosaJisshishaJoho()
        
        //TODO DBZ.KihonChosaInputは未作成です
        //div.getCcdIchigunKihonChosa()
        
        
        TempData tempData = 認定調査情報を取得();
        RString temp_厚労省IF識別コード = tempData.getTemp_厚労省IF識別コード();
        RString temp_認定調査依頼区分コード = tempData.getTemp_認定調査依頼区分コード();
        RString temp_認定調査回数 = tempData.getTemp_認定調査回数();
        RString temp_認定調査委託区分コード = tempData.getTemp_認定調査委託区分コード();
        
        予防給付サービス名称取得(temp_厚労省IF識別コード);
        介護給付サービス名称取得(temp_厚労省IF識別コード);
        施設利用名称取得(temp_厚労省IF識別コード);
        if (is再調査の場合()) {
            既存概況調査情報取得(temp_厚労省IF識別コード);
        }
        
        初期画面値の保持();
    }
    
    private void 初期画面値の保持() {
        List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
        RString 予防給付サービスvals = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
            予防給付サービスvals = 予防給付サービスvals.concat(row.getServiceJokyo().getValue().toString()).concat(",");
        }
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.予防給付サービス, 予防給付サービスvals);
        
        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        RString 介護給付サービスvals = RString.EMPTY;
        for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
            介護給付サービスvals = 介護給付サービスvals.concat(row.getServiceJokyo().getValue().toString()).concat(",");
        }
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.介護給付サービス, 予防給付サービスvals);
    }

    private TempData 認定調査情報を取得() {

        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData tempData = finder.get認定調査情報(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号);
        return tempData;
    }

    /**
     * 画面初期化、既存概況調査情報取得（再調査の場合）を行います。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     */
    private void 既存概況調査情報取得(RString temp_厚労省IF識別コード) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoGaikyoChosaManager manager = NinteichosahyoGaikyoChosaManager.createInstance();
        NinteichosahyoGaikyoChosaMapperParameter parameter = NinteichosahyoGaikyoChosaMapperParameter.createSelectByKeyParam(temp_申請書管理番号, temp_認定調査履歴番号);
        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = manager.get認定調査票_概況調査(parameter);

        Code temp_現在の状況コード = new Code();  // TODO DB「DbT5202NinteichosahyoGaikyoChosa」に存在しない　　1.6check待ち
        Code temp_現在のサービス区分コード;
        if (ninteichosahyoGaikyoChosa == null) {
            return;
        }
        temp_現在のサービス区分コード = ninteichosahyoGaikyoChosa.get認定調査_サービス区分コード();

        if (temp_現在の状況コード.getColumnValue().equalsIgnoreCase(ZaitakuShisetsuKubun.在宅.getコード())
                && temp_現在のサービス区分コード.getColumnValue().equalsIgnoreCase(ServiceKubunCode.予防給付サービス.getコード())) {
            在宅_予防給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号);

        } else if (temp_現在の状況コード.getColumnValue().equalsIgnoreCase(ZaitakuShisetsuKubun.在宅.getコード())
                && temp_現在のサービス区分コード.getColumnValue().equalsIgnoreCase(ServiceKubunCode.介護給付サービス.getコード())) {
            在宅_介護給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号);
        }
        if (temp_現在の状況コード.getColumnValue().equalsIgnoreCase(ZaitakuShisetsuKubun.在宅.getコード())) {
            在宅_住宅改修radの設定(temp_申請書管理番号, temp_認定調査履歴番号);
            在宅_市町村特別給付txtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
            在宅_介護保険給付以外の在宅サービスtxtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        }

        if (temp_現在の状況コード.getColumnValue().equalsIgnoreCase(ZaitakuShisetsuKubun.施設.getコード())) {
            施設_施設利用フラグの設定(temp_申請書管理番号, temp_認定調査履歴番号);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(ninteichosahyoGaikyoChosa.get利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().setValue(ninteichosahyoGaikyoChosa.get利用施設郵便番号());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().setTxtShisetsuJusho(null); // TODO setValueメソッドがない
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo(); //TODO setValueメソッドがない
            div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(ninteichosahyoGaikyoChosa.get特記());
        }
    }

    private void 予防給付サービス名称取得(RString temp_厚労省IF識別コード) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        // TODO 連番の指定（予防給付サービス、介護給付サービス）
        List<dgRiyoSerViceFirstHalf_Row> halfListTmp = new ArrayList();
        switch (temp_厚労省IF識別コード.toString()) {
            case "09B2015":
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ__訪問型サービス.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_2._介護予防_訪問入浴介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_3._介護予防_訪問看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_5._介護予防_居宅療養管理指導.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ__訪問型サービス.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_8._介護予防_短期入所生活介護_ｼｮｰﾄｽﾃｲ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_9._介護予防_短期入所療養介護_老健_診療所.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_10._介護予防_特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_11._介護予防_看護小規模多機能型居宅介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_12._介護予防_福祉用具貸与.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_13.特定_介護予防_福祉用具販売.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_14.住宅改修.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_15.夜間対応型訪問介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_16._介護予防_認知症対応型通所介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_17._介護予防_小規模多機能型居宅介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_18._介護予防_認知症対応型共同生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_19.地域密着型特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_20.地域密着型介護老人福祉施設入所者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_21.定期巡回_随時対応型訪問介護看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_22.市町村特別給付.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09B2015_23.介護保険給付外の在宅サービス.get名称()));
                break;
            case "09A":
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_3._介護予防_訪問看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_13.住宅改修.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_14.夜間対応型訪問介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_18.地域密着型特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_19.地域密着型介護老人福祉施設入所者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_20.定期巡回_随時対応型訪問介護看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_21.複合型サービス.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_22.市町村特別給付.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku09A_23.介護保険給付外の在宅サービス.get名称()));
                break;
            case "06A":
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_3._介護予防_訪問看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_13.住宅改修.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_14.夜間対応型訪問介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_18.地域密着型特定施設入居者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_19.地域密着型介護老人福祉施設入所者生活介護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_20.定期巡回_随時対応型訪問介護看護.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_21.市町村特別給付.get名称()));
                halfListTmp.add(getRiyoServiceData(GaikyochosaKomoku06A_22.介護保険給付外の在宅サービス.get名称()));
                break;
        }

        List<dgRiyoSerViceFirstHalf_Row> halfList = new ArrayList();
        for (dgRiyoSerViceFirstHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains("（介護予防）")) {
                halfList.add(getRiyoServiceData(RStringUtil.convert代替可視文字to置換文字(rowData.getServiceMeisho().getValue(), RString.EMPTY)));
            }
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setDataSource(halfList);
    }

    private void 介護給付サービス名称取得(RString temp_厚労省IF識別コード) {
        // TODO 介護給付サービスの連番の指定
    }

    private void 施設利用名称取得(RString temp_厚労省IF識別コード) {

        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList();
        switch (temp_厚労省IF識別コード.toString()) {
            case "09B2015":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_24.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_25.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_26.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_29.医療機関_医療保険適用療養病床.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_30.医療機関_療養病床以外.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B2015_31.その他の施設.get名称()));
                break;
            case "09B":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_24.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_25.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_26.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_29.医療機関_医療保険適用療養病床.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_30.医療機関_療養病床以外.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_31.その他の施設.get名称()));
                break;
            case "09A":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_24.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_25.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_26.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_29.医療機関_医療保険適用療養病床.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_30.医療機関_療養病床以外.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_31.その他の施設.get名称()));
                break;
            case "06A":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_23.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_24.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_25.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_26.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_27.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_28.医療機関_医療保険適用療養病床.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_29.医療機関_療養病床以外.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_30.その他の施設.get名称()));
                break;
            case "02A":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_17.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_18.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_19.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_20.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_21.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_22.医療機関_療養.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_23.医療機関_療養以外.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_24.その他の施設.get名称()));
                break;
            case "99A":
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_17.介護老人福祉施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_18.介護老人保健施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_19.介護療養型医療施設.get名称()));
                riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_20.介護保険施設外の施設.get名称()));
                break;
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(riyoShisetsuList);
    }

    private dgRiyoSerViceFirstHalf_Row getRiyoServiceData(RString name) {
        dgRiyoSerViceFirstHalf_Row row = new dgRiyoSerViceFirstHalf_Row();
        row.getServiceMeisho().setValue(name);
        return row;
    }

    private dgRiyoShisetsu_Row getRiyoShisetsuData(RString name) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.setShisetsuRiyoName(name);
        return row;
    }

    private boolean is再調査の場合() {
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        DbT5202NinteichosahyoGaikyoChosaDac dac = new DbT5202NinteichosahyoGaikyoChosaDac();
        DbT5202NinteichosahyoGaikyoChosaEntity entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号);
        return entity != null;
    }

    private void 在宅_予防給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {

        DbT5207NinteichosahyoServiceJokyoDac dac = new DbT5207NinteichosahyoServiceJokyoDac();
        DbT5207NinteichosahyoServiceJokyoEntity entity;

        List<dgRiyoSerViceFirstHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        for (dgRiyoSerViceFirstHalf_Row row : halfList) {
//            row.getServiceMeisho(); // 名称を利用して、マッピングより、連番を取得
            TextBoxNum num = new TextBoxNum();
            entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 1); //TODO 連番1~ ●予防給付サービス名称取得　に対応
            if (entity != null) {
                num.setValue(new Decimal(entity.getServiceJokyo()));
                row.setServiceJokyo(num);
            }
        }
    }

    private void 在宅_介護給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {

        DbT5207NinteichosahyoServiceJokyoDac dac = new DbT5207NinteichosahyoServiceJokyoDac();
        DbT5207NinteichosahyoServiceJokyoEntity entity;

        List<dgRiyoSerViceSecondHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        for (dgRiyoSerViceSecondHalf_Row row : halfList) {
//            row.getServiceMeisho(); // 名称を利用して、マッピングより、連番を取得
            TextBoxNum num = new TextBoxNum();
            entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 1); //TODO 連番1~ ●介護給付サービス名称取得　に対応
            if (entity != null) {
                num.setValue(new Decimal(entity.getServiceJokyo()));
                row.setServiceJokyo(num);
            }
        }
    }

    private void 施設_施設利用フラグの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        
        DbT5210NinteichosahyoShisetsuRiyoDac dac = new DbT5210NinteichosahyoShisetsuRiyoDac();
        DbT5210NinteichosahyoShisetsuRiyoEntity entity;

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        for (dgRiyoShisetsu_Row row : shisetsuList) {
//            row.getShisetsuRiyoName(); // 名称を利用して、マッピングより、連番を取得 あるいは順調で設定する
            TextBoxNum num = new TextBoxNum();
            entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 1); //TODO 連番1~ ●介護給付サービス名称取得　に対応
            if (entity != null) {
                if (entity.getShisetsuRiyoFlag()) {
                    row.setShisetsuRiyoUmu(Boolean.TRUE);
                }
            }
        }
    }

    private void 在宅_住宅改修radの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        DbT5208NinteichosahyoServiceJokyoFlagDac dac = new DbT5208NinteichosahyoServiceJokyoFlagDac();
        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 1);
        boolean 住宅改修 = entity.getServiceJokyoFlag();
        if (住宅改修) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(new RString("key0"));
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(new RString("key1"));

    }

    private void 在宅_市町村特別給付txtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        DbT5209NinteichosahyoKinyuItemDac dac = new DbT5209NinteichosahyoKinyuItemDac();
        DbT5209NinteichosahyoKinyuItemEntity entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 1);
        if (entity != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setValue(entity.getServiceJokyoKinyu());
        }
    }

    private void 在宅_介護保険給付以外の在宅サービスtxtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        DbT5209NinteichosahyoKinyuItemDac dac = new DbT5209NinteichosahyoKinyuItemDac();
        DbT5209NinteichosahyoKinyuItemEntity entity = dac.selectByKey(temp_申請書管理番号, temp_認定調査履歴番号, 2);
        if (entity != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setValue(entity.getServiceJokyoKinyu());
        }
    }
    
   
   /**
     * Dbe2210001Keys
     */
    public enum Dbe2210001Keys {

        /**
         * 修正前の予防給付サービス
         */
        予防給付サービス,
        /**
         * 修正前の介護給付サービス
         */
        介護給付サービス,
        /**
         * 修正前の家族状況
         */
        修正前の家族状況,
        /**
         * 修正前の居住環境
         */
        修正前の居住環境,
        /**
         * 修正前の機器器械
         */
        修正前の機器器械

    }
    

}
