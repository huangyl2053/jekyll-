/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_17;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_18;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_19;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_20;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_21;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_22;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_23;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku02A_24;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_1;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_10;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_11;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_12;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_14;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_15;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_16;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_17;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_18;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_19;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_2;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_23;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_24;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_25;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_26;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_27;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_28;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_29;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_3;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_30;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_4;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_5;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_6;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_7;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_8;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku06A_9;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_1;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_10;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_11;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_12;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_14;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_15;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_16;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_17;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_18;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_19;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_2;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_24;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_25;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_26;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_27;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_28;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_29;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_3;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_30;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_31;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_4;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_5;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_6;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_7;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_8;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09A_9;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_1;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_10;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_11;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_12;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_14;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_15;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_16;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_17;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_18;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_19;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_2;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_20;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_21;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_24;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_25;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_26;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_27;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_28;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_29;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_3;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_30;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_31;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_4;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_5;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_6;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_7;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_8;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku09B_9;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku99A_17;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku99A_18;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku99A_19;
import jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku.GaikyochosaKomoku99A_20;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInputBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査結果登録1のクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1Handler {

    private final NinnteiChousaKekkaTouroku1Div div;

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 介護予防 = new RString("（介護予防）");
    private static final RString カンマ = new RString(",");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final int データベース内連番_1 = 1;
    private static final int データベース内連番_2 = 2;
    private static final int データベース内連番_3 = 3;
    private static final int データベース内連番_4 = 4;
    private static final int データベース内連番_5 = 5;
    private static final int データベース内連番_6 = 6;
    private static final int データベース内連番_7 = 7;
    private static final int データベース内連番_8 = 8;
    private static final int データベース内連番_9 = 9;
    private static final int データベース内連番_10 = 10;
    private static final int データベース内連番_11 = 11;
    private static final int データベース内連番_12 = 12;
    private static final int データベース内連番_13 = 13;
    private static final int データベース内連番_14 = 14;
    private static final int データベース内連番_15 = 15;
    private static final int データベース内連番_16 = 16;
    private static final int データベース内連番_17 = 17;
    private static final int データベース内連番_18 = 18;
    private static final int データベース内連番_19 = 19;
    private static final int データベース内連番_20 = 20;
    private static final int データベース内連番_63 = 63;
    private static final int データベース内連番_64 = 64;
    private static final int データベース内連番_65 = 65;
    private static final int データベース内連番_66 = 66;
    private static final int データベース内連番_67 = 67;
    private static final int データベース内連番_68 = 68;
    private static final int データベース内連番_69 = 69;
    private static final int データベース内連番_70 = 70;
    private static final int データベース内連番_71 = 71;
    private static final int データベース内連番_72 = 72;
    private static final int データベース内連番_73 = 73;
    private static final int データベース内連番_74 = 74;
    private static final RString 第1群の連番_有無 = new RString(",1,2,3,4,5,6,7,8,9,");
    private static final RString 第1群の連番 = new RString(",10,11,12,13,14,15,16,17,18,19,20,");
    private static final RString 第2群の連番 = new RString(",21,22,23,24,25,26,27,28,29,30,31,32,");
    private static final RString 第3群の連番 = new RString(",33,34,35,36,37,38,39,40,41,");
    private static final RString 第4群の連番 = new RString(",42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,");
    private static final RString 第5群の連番 = new RString(",57,58,59,60,61,62,");
    private static final RString 特別な医療の連番 = new RString(",63,64,65,66,67,68,69,70,71,72,73,74,");
    private static final RString 項目値１ = new RString("1");
    private static final RString 調査項目_ない = new RString("1");
    private static final RString 調査項目_ある = new RString("2");
    private static final RString 認定調査前回結果表示 = new RString("1");
    private static final RString 基本調査入力OK = new RString("1");
    private static final RString 基本調査入力NG = new RString("0");
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_15 = 15;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査結果登録1のコントロールdiv
     */
    public NinnteiChousaKekkaTouroku1Handler(NinnteiChousaKekkaTouroku1Div div) {
        this.div = div;
    }

    /**
     * 共有子DIV初期化の処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param model 調査実施者情報に渡すパラメータ
     */
    public void 共有子DIV初期化(ShinseishoKanriNo 申請書管理番号, ChosaJisshishaJohoModel model) {

        div.getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        div.getCcdNinteiShinseiRenrakusakiKihon().initialize(申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Input);
        div.getCcdChosaJisshishaJoho().intialize(model);
    }

    /**
     * 認定調査情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 認定調査情報
     */
    public TempData 認定調査情報を取得(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        RString 認定調査委託先コード = div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue();

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get認定調査情報(認定調査履歴番号, 認定調査委託先コード, 申請書管理番号);
    }

    /**
     * 既存概況調査情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 既存概況調査情報 既存概況調査情報
     */
    public TempData 既存概況調査情報取得(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData gaikyoChosa = finder.get既存概況調査情報(認定調査履歴番号, 申請書管理番号);
        if (gaikyoChosa == null) {
            return null;
        }
        return gaikyoChosa;
    }

    /**
     * 再調査の場合、住宅改修、市町村特別給付TXT、介護保険給付以外の在宅サービスTXTの初期化。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     */
    public void 住宅改修_既存初期化(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        在宅_住宅改修radの設定(申請書管理番号, 認定調査履歴番号);
        在宅_市町村特別給付txtの設定(申請書管理番号, 認定調査履歴番号);
        在宅_介護保険給付以外の在宅サービスtxtの設定(申請書管理番号, 認定調査履歴番号);
    }

    /**
     * 予防給付サービス名称を設定します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 予防給付状況
     */
    public RString 予防給付サービス名称取得(RString temp_厚労省IF識別コード) {

        List<dgRiyoSerViceFirstHalf_Row> halfListTmp = new ArrayList<>();
        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku06A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get単位()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get単位()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09B_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get単位()));
        }

        List<dgRiyoSerViceFirstHalf_Row> halfList = new ArrayList<>();
        RString 予防給付状況 = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(予防_介護予防を取り除く(rowData));
                予防給付状況 = 予防給付状況.concat(カンマ);
            }
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setDataSource(halfList);
        return 予防給付状況;
    }

    /**
     * 利用サービス前半Grid非表示を行います。
     */
    public void 利用サービス前半Grid非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(false);
    }

    /**
     * 利用サービス前半Grid表示を行います。（初期の値を表示する）
     *
     * @param is再調査の場合 true:再調査の場合
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 変更前の設定値 変更前の設定値
     */
    public void 利用サービス前半Grid表示(boolean is再調査の場合, RString 厚労省IF識別コード, RString 変更前の設定値) {

        予防給付サービス名称取得(厚労省IF識別コード);
        if (is再調査の場合) {
            利用サービス前半Gridの破棄(変更前の設定値);
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(true);
    }

    private RString 介護給付サービス名称取得(RString temp_厚労省IF識別コード) {
        List<dgRiyoSerViceSecondHalf_Row> halfListTmp = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku06A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku06A_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku06A_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku06A_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku09A_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku09A_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku09A_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09B_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku09B_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku09B_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku09B_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_20.定期巡回_随時対応型訪問介護看護.get名称(), GaikyochosaKomoku09B_20.定期巡回_随時対応型訪問介護看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_21.複合型サービス.get名称(), GaikyochosaKomoku09B_21.複合型サービス.get単位()));
        }

        RString 介護給付状況 = RString.EMPTY;
        List<dgRiyoSerViceSecondHalf_Row> halfList = new ArrayList<>();
        for (dgRiyoSerViceSecondHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(介護_介護予防を取り除く(rowData));
            } else {
                halfList.add(rowData);
            }
            介護給付状況 = 介護給付状況.concat(カンマ);
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setDataSource(halfList);
        return 介護給付状況;
    }

    /**
     * 利用サービス後半Grid非表示を行います。
     */
    public void 利用サービス後半Grid非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(false);
    }

    /**
     * 利用サービス後半Grid表示を行います。（初期の値を表示する）
     *
     * @param is再調査の場合 true:再調査の場合
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 変更前の設定値 変更前の設定値
     */
    public void 利用サービス後半Grid表示(boolean is再調査の場合, RString 厚労省IF識別コード, RString 変更前の設定値) {

        介護給付サービス名称取得(厚労省IF識別コード);
        if (is再調査の場合) {
            利用サービス後半Gridの破棄(変更前の設定値);
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(true);
    }

    private RString 施設利用名称取得(RString temp_厚労省IF識別コード) {

        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList<>();

        if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_20.介護保険施設外の施設.get名称()));
        } else if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_20.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_21.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_22.医療機関_療養.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_23.医療機関_療養以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_24.その他の施設.get名称()));
        } else if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_23.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_24.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_25.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_26.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_27.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_28.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_29.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_30.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_31.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_31.その他の施設.get名称()));
        }

        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : riyoShisetsuList) {
            施設利用 = 施設利用.concat(new RString(Boolean.FALSE.toString())).concat(カンマ);
        }

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(riyoShisetsuList);
        return 施設利用;
    }

    /**
     * 予防給付サービス_利用状況_初期設定 を行います。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 予防給付サービスの初期設定値
     */
    public RString 予防給付サービス_利用状況_初期設定(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号, RString 厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = get予防給付サービス連番List(厚労省IF識別コード);

        List<dgRiyoSerViceFirstHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        RString 予防給付状況 = RString.EMPTY;
        if (halfList == null || halfList.isEmpty()) {
            予防給付状況 = 予防給付サービス名称取得(厚労省IF識別コード);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        }

        List<NinteichosahyoServiceJokyo> johoList = manager.get認定調査票_概況調査_サービスの状況By連番List(申請書管理番号, 認定調査履歴番号, 連番);
        NinteichosahyoServiceJokyo joho;
        int index = 0;

        if (halfList != null && !halfList.isEmpty()) {
            予防給付状況 = RString.EMPTY;
            for (dgRiyoSerViceFirstHalf_Row row : halfList) {
                joho = johoList.get(index++);
                if (joho != null) {
                    row.getServiceJokyo().setValue(new Decimal(joho.getサービスの状況()));
                    予防給付状況 = 予防給付状況.concat(new RString(Integer.valueOf(joho.getサービスの状況()).toString())).concat(カンマ);
                } else {
                    予防給付状況 = 予防給付状況.concat(カンマ);
                }
            }
        }
        return 予防給付状況;
    }

    /**
     * 介護給付サービス_利用状況_初期設定 を行います。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 介護給付サービスの初期設定値
     */
    public RString 介護給付サービス_利用状況_初期設定(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号, RString 厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = get介護給付サービス連番List(厚労省IF識別コード);

        List<dgRiyoSerViceSecondHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        RString 介護給付状況 = RString.EMPTY;
        if (halfList == null || halfList.isEmpty()) {
            介護給付状況 = 介護給付サービス名称取得(厚労省IF識別コード);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        }

        List<NinteichosahyoServiceJokyo> johoList = manager.get認定調査票_概況調査_サービスの状況By連番List(申請書管理番号, 認定調査履歴番号, 連番);
        int index = 0;
        NinteichosahyoServiceJokyo joho;

        if (halfList != null && !halfList.isEmpty()) {
            介護給付状況 = RString.EMPTY;
            for (dgRiyoSerViceSecondHalf_Row row : halfList) {
                joho = johoList.get(index++);
                if (joho != null) {
                    row.getServiceJokyo().setValue(new Decimal(joho.getサービスの状況()));
                    介護給付状況 = 介護給付状況.concat(new RString(Integer.valueOf(joho.getサービスの状況()).toString())).concat(カンマ);
                } else {
                    介護給付状況 = 介護給付状況.concat(カンマ);
                }
            }
        }
        return 介護給付状況;
    }

    /**
     * 施設利用フラグの設定を行います。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @return 施設利用の初期設定値
     */
    public RString 施設_施設利用フラグ_初期設定(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号, RString 厚労省IF識別コード) {

        NinteichosahyoShisetsuRiyoManager manager = new NinteichosahyoShisetsuRiyoManager();
        List<Integer> 連番 = get施設利用連番List(厚労省IF識別コード);

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        RString 施設利用 = RString.EMPTY;
        if (shisetsuList.isEmpty()) {
            施設利用 = 施設利用名称取得(厚労省IF識別コード);
            shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        }

        List<NinteichosahyoShisetsuRiyo> johoList = manager.get認定調査票_概況調査_施設利用By連番List(申請書管理番号, 認定調査履歴番号, 連番);
        int index = 0;
        NinteichosahyoShisetsuRiyo joho;

        if (shisetsuList != null && !shisetsuList.isEmpty()) {
            施設利用 = RString.EMPTY;
            for (dgRiyoShisetsu_Row row : shisetsuList) {
                joho = johoList.get(index++);
                if (joho != null && joho.is施設利用フラグ()) {
                    row.setShisetsuRiyoUmu(Boolean.TRUE);
                    施設利用 = 施設利用.concat(new RString(Boolean.TRUE.toString())).concat(カンマ);
                } else {
                    施設利用 = 施設利用.concat(new RString(Boolean.FALSE.toString())).concat(カンマ);
                }
            }
        }
        return 施設利用;
    }

    /**
     * 施設の表示を行います。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     */
    public void 施設の表示(RString 厚労省IF識別コード) {

        if (div.getDgRiyoShisetsu().getDataSource() == null || div.getDgRiyoShisetsu().getDataSource().isEmpty()) {
            施設利用名称取得(厚労省IF識別コード);
        }
    }

    private void 在宅_住宅改修radの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoServiceJokyoFlagManager manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag joho = manager.get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        boolean 住宅改修 = joho != null && joho.isサービスの状況フラグ();
        RString 住宅改修rad = 住宅改修_無;
        if (住宅改修) {
            住宅改修rad = 住宅改修_有;
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修rad);
    }

    private void 在宅_市町村特別給付txtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setValue(joho.getサービスの状況記入());
        }
    }

    private void 在宅_介護保険給付以外の在宅サービスtxtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setValue(joho.getサービスの状況記入());
        }
    }

    private dgRiyoSerViceFirstHalf_Row 予防_介護予防を取り除く(dgRiyoSerViceFirstHalf_Row row) {
        row.getServiceMeisho().setValue(row.getServiceMeisho().getValue().replace(介護予防, RString.EMPTY));
        return row;
    }

    private dgRiyoSerViceFirstHalf_Row 予防データ(RString name, RString tani) {
        dgRiyoSerViceFirstHalf_Row row = new dgRiyoSerViceFirstHalf_Row();
        row.getServiceMeisho().setValue(name);
        row.setTani(tani);
        return row;
    }

    private dgRiyoSerViceSecondHalf_Row 介護_介護予防を取り除く(dgRiyoSerViceSecondHalf_Row row) {
        row.getServiceMeisho().setValue(row.getServiceMeisho().getValue().replace(介護予防, RString.EMPTY));
        return row;
    }

    private dgRiyoSerViceSecondHalf_Row 介護データ(RString name, RString tani) {
        dgRiyoSerViceSecondHalf_Row row = new dgRiyoSerViceSecondHalf_Row();
        row.getServiceMeisho().setValue(name);
        row.setTani(tani);
        return row;
    }

    private dgRiyoShisetsu_Row 施設データ(RString name) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.setShisetsuRiyoName(name);
        return row;
    }

    /**
     * 利用サービス前半or後半の切り替え処理です。
     *
     * @param 現在の選択 現在サービス区分の選択値
     * @param is再調査の場合 true:再調査の場合
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 変更前の設定値 変更前の設定値
     */
    public void 利用サービス前半or後半の切り替え(RString 現在の選択, boolean is再調査の場合, RString 厚労省IF識別コード, RString 変更前の設定値) {

        if (予防給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス前半Grid表示(is再調査の場合, 厚労省IF識別コード, 変更前の設定値);
            利用サービス後半Grid非表示();
            利用サービス後半Gridのクリア();

        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス後半Grid表示(is再調査の場合, 厚労省IF識別コード, 変更前の設定値);
            利用サービス前半Grid非表示();
            利用サービス前半Gridのクリア();

        } else if (なし_選択.toString().equalsIgnoreCase(現在の選択.toString())) {

            利用サービス前半Grid非表示();
            利用サービス後半Grid非表示();
            利用サービス前半Gridのクリア();
            利用サービス後半Gridのクリア();
        }

    }

    /**
     * 利用サービス前半Gridの破棄を行います。
     *
     * @param 変更前の設定値 変更前の設定値
     */
    public void 利用サービス前半Gridの破棄(RString 変更前の設定値) {

        List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();

        if (変更前の設定値 == null || 変更前の設定値.isEmpty()) {
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                row.getServiceJokyo().clearValue();
            }
            return;
        }

        List<RString> 変更前の設定値List = 変更前の設定値.split(カンマ.toString());
        int index = 0;
        RString 数値 = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
            row.setSelected(Boolean.FALSE);
            数値 = 変更前の設定値List.get(index);
            if (数値.isEmpty()) {
                row.getServiceJokyo().clearValue();
            } else {
                row.getServiceJokyo().setValue(new Decimal(数値.toString()));
            }
            index++;
        }
    }

    /**
     * 利用サービス前半Gridのクリアを行います。
     */
    public void 利用サービス前半Gridのクリア() {
        div.getDgRiyoSerViceFirstHalf().getDataSource().clear();
    }

    /**
     * 利用サービス後半Gridの破棄を行います。
     *
     * @param 変更前の設定値 変更前の設定値
     */
    public void 利用サービス後半Gridの破棄(RString 変更前の設定値) {

        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        if (変更前の設定値 == null || 変更前の設定値.isEmpty()) {
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                row.getServiceJokyo().clearValue();
            }
            return;
        }

        List<RString> 変更前の設定値List = 変更前の設定値.split(カンマ.toString());
        int index = 0;
        RString 数値 = RString.EMPTY;
        for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
            row.setSelected(Boolean.FALSE);
            数値 = 変更前の設定値List.get(index);
            if (数値.isEmpty()) {
                row.getServiceJokyo().clearValue();
            } else {
                row.getServiceJokyo().setValue(new Decimal(数値.toString()));
            }
            index++;
        }
    }

    /**
     * 利用サービス後半Gridのクリアを行います。
     */
    public void 利用サービス後半Gridのクリア() {
        div.getDgRiyoSerViceSecondHalf().getDataSource().clear();
    }

    /**
     * 住宅改修と記入項目のクリアを行います。
     */
    public void 住宅改修と記入項目のクリア() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修_無);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().clearValue();
    }

    /**
     * 施設tplのクリアを行います。
     */
    public void 施設tplのクリア() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource().clear();

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().setDomain(new AtenaJusho(RString.EMPTY));
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(RString.EMPTY));
    }

    /**
     * 基本調査の初期化処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param is再調査の場合 true:再調査の場合
     * @param 第1群List 第1群List
     * @param 第2群List 第2群List
     * @param 第3群List 第3群List
     * @param 第4群List 第4群List
     * @param 第5群List 第5群List
     * @param 特別な医療List 特別な医療List
     * @param 自立度List 自立度List
     * @return 基本調査初期の設定値
     */
    public RString 基本調査の初期化(ShinseishoKanriNo 申請書管理番号, boolean is再調査の場合,
            ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List, ArrayList<KihonChosaInput> 第5群List,
            ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {

        ArrayList<KihonChosaInput> 第1群 = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療 = new ArrayList<>();
        RString 自立度 = RString.EMPTY;
        boolean 前回基本調査項目値あり = false;

        KihonChosaInputFinder findler = KihonChosaInputFinder.createInstance();
        List<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        if (is再調査の場合) {
            認定調査基本情報リスト = findler.get認定調査基本情報(申請書管理番号);
        }

        if (認定調査基本情報リスト.isEmpty()) {
            第1群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_1, 調査項目_ない, new Code(), new Code(), データベース内連番_1, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_2, 調査項目_ない, new Code(), new Code(), データベース内連番_2, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_3, 調査項目_ない, new Code(), new Code(), データベース内連番_3, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_4, 調査項目_ない, new Code(), new Code(), データベース内連番_4, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_5, 調査項目_ない, new Code(), new Code(), データベース内連番_5, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_6, 調査項目_ない, new Code(), new Code(), データベース内連番_6, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_7, 調査項目_ない, new Code(), new Code(), データベース内連番_7, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_8, 調査項目_ない, new Code(), new Code(), データベース内連番_8, RString.EMPTY));
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_9, 調査項目_ない, new Code(), new Code(), データベース内連番_9, RString.EMPTY));

            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_63, 調査項目_ない, new Code(), new Code(), データベース内連番_63, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_64, 調査項目_ない, new Code(), new Code(), データベース内連番_64, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_65, 調査項目_ない, new Code(), new Code(), データベース内連番_65, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_66, 調査項目_ない, new Code(), new Code(), データベース内連番_66, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_67, 調査項目_ない, new Code(), new Code(), データベース内連番_67, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_68, 調査項目_ない, new Code(), new Code(), データベース内連番_68, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_69, 調査項目_ない, new Code(), new Code(), データベース内連番_69, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_70, 調査項目_ない, new Code(), new Code(), データベース内連番_70, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_71, 調査項目_ない, new Code(), new Code(), データベース内連番_71, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_72, 調査項目_ない, new Code(), new Code(), データベース内連番_72, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_73, 調査項目_ない, new Code(), new Code(), データベース内連番_73, RString.EMPTY));
            特別な医療.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                    データベース内連番_74, 調査項目_ない, new Code(), new Code(), データベース内連番_74, RString.EMPTY));

            認定調査基本情報リスト.addAll(第1群);
            認定調査基本情報リスト.addAll(特別な医療);

            自立度List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0,
                    new Code(), new Code(), 0, 調査項目_ない, new Code(), new Code(), 0, RString.EMPTY));
            自立度List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0,
                    new Code(), new Code(), 0, 調査項目_ない, new Code(), new Code(), 0, RString.EMPTY));
        } else {

            KihonChosaInput 第7群 = 認定調査基本情報リスト.get(0);

            KihonChosaInput 障害高齢者 = new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), 第7群.get障害高齢者自立度(),
                    0, 調査項目_ない, new Code(), 第7群.get前回障害高齢者自立度(), 0, RString.EMPTY);
            KihonChosaInputBuilder 障害高齢者Builder = 障害高齢者.createBuilderForEdit();
            if (第7群.get障害高齢者自立度() != null && !第7群.get障害高齢者自立度().isEmpty()) {
                障害高齢者Builder.set特記事項有無(true);
            }

            KihonChosaInput 認知症高齢者 = new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, 第7群.get認知症高齢者自立度(),
                    new Code(), 0, 調査項目_ない, 第7群.get前回認知症高齢者自立度(), new Code(), 0, RString.EMPTY);
            KihonChosaInputBuilder 認知症高齢者Builder = 認知症高齢者.createBuilderForEdit();
            if (第7群.get認知症高齢者自立度() != null && !第7群.get認知症高齢者自立度().isEmpty()) {
                認知症高齢者Builder.set特記事項有無(true);
            }

            自立度List.add(障害高齢者Builder.build());
            自立度List.add(認知症高齢者Builder.build());
            自立度 = 自立度.concat(障害高齢者.get障害高齢者自立度().getKey()).concat(認知症高齢者.get認知症高齢者自立度().getKey());

            if ((第7群.get前回認知症高齢者自立度() != null && !第7群.get前回認知症高齢者自立度().isEmpty())
                    || (第7群.get前回障害高齢者自立度() != null && !第7群.get前回障害高齢者自立度().isEmpty())) {
                前回基本調査項目値あり = true;
            }
        }

        return 基本調査初期データの保存(第1群List, 第2群List, 第3群List, 第4群List, 第5群List,
                特別な医療List, 認定調査基本情報リスト, 前回基本調査項目値あり, 自立度);
    }

    private RString 基本調査初期データの保存(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List, ArrayList<KihonChosaInput> 第5群List,
            ArrayList<KihonChosaInput> 特別な医療List, List<KihonChosaInput> 認定調査基本情報リスト,
            boolean 前回基本調査項目値あり, RString 自立度) {

        RString 第1群 = RString.EMPTY;
        RString 第2群 = RString.EMPTY;
        RString 第3群 = RString.EMPTY;
        RString 第4群 = RString.EMPTY;
        RString 第5群 = RString.EMPTY;
        RString 特別な医療 = RString.EMPTY;

        KihonChosaInputBuilder joho;
        for (KihonChosaInput 基本情報 : 認定調査基本情報リスト) {
            if (!前回基本調査項目値あり && ((基本情報.get前回調査項目() != null && !基本情報.get前回調査項目().isEmpty()))) {
                前回基本調査項目値あり = true;
            }

            if (第1群の連番_有無.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                if (調査項目_ある.equals(基本情報.get調査項目())) {
                    joho.set特記事項有無(true);
                }
                第1群List.add(joho.build());
                第1群 = 第1群.concat(基本情報.get調査項目());
            } else if (第1群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第1群List.add(joho.build());
                第1群 = 第1群.concat(基本情報.get調査項目());
            } else if (第2群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第2群List.add(joho.build());
                第2群 = 第2群.concat(基本情報.get調査項目());

            } else if (第3群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第3群List.add(joho.build());
                第3群 = 第3群.concat(基本情報.get調査項目());
            } else if (第4群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第4群List.add(joho.build());
                第4群 = 第4群.concat(基本情報.get調査項目());

            } else if (第5群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第5群List.add(joho.build());
                第5群 = 第5群.concat(基本情報.get調査項目());
            } else if (特別な医療の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                if (調査項目_ある.equals(基本情報.get調査項目())) {
                    joho.set特記事項有無(true);
                }
                特別な医療List.add(joho.build());
                特別な医療 = 特別な医療.concat(String.valueOf(基本情報.get調査項目()));

            }
        }

        RString 認定調査前回結果表示Val = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!認定調査前回結果表示.equals(認定調査前回結果表示Val)) {
            前回基本調査項目値あり = false;
        }

        RString 初期の基本調査 = 第1群.concat(第2群).concat(第3群).concat(第4群).concat(第5群).concat(特別な医療).concat(自立度);
        if (前回基本調査項目値あり) {
            初期の基本調査 = 初期の基本調査.concat(new RString("T"));
        } else {
            初期の基本調査 = 初期の基本調査.concat(new RString("F"));
        }
        return 初期の基本調査;
    }

    /**
     * 予防給付サービスの連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 予防給付サービスの連番リスト
     */
    public List<Integer> get予防給付サービス連番List(RString temp_厚労省IF識別コード) {
        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
        }
        return 連番List;
    }

    /**
     * 介護給付サービスの連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 介護給付サービスの連番リスト
     */
    public List<Integer> get介護給付サービス連番List(RString temp_厚労省IF識別コード) {
        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_13);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
            連番List.add(データベース内連番_17);
            連番List.add(データベース内連番_18);
        }

        if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_19);
            連番List.add(データベース内連番_20);
        }
        return 連番List;
    }

    /**
     * 施設利用の連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 施設利用の連番リスト
     */
    public List<Integer> get施設利用連番List(RString temp_厚労省IF識別コード) {

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
        } else if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_9);
        }
        return 連番List;
    }

    /**
     * 入力内容の変更が存在しないかを判断します。
     *
     * @param 元の市町村特別給付TXT 元の市町村特別給付TXT
     * @param 元の介護保険給付以外の在宅サービスTXT 元の介護保険給付以外の在宅サービスTXT
     * @param 元の特記 元の特記
     * @param 初期の概況調査場所 初期の概況調査場所
     * @param 現在の概況調査場所 現在の概況調査場所
     * @param 初期のサービス区分 初期のサービス区分
     * @param 現在のサービス区分 現在のサービス区分
     * @param 初期の予防給付サービス 初期の予防給付サービス
     * @param 初期の介護給付サービス 初期の介護給付サービス
     * @param 初期の施設利用 初期の施設利用
     * @param 初期の施設連絡先 初期の施設連絡先
     * @param 初期の基本調査 初期の基本調査
     * @return 判断結果(true:変更がない false:変更があり)
     */
    public boolean is入力内容変更なし(RString 元の市町村特別給付TXT, RString 元の介護保険給付以外の在宅サービスTXT,
            RString 元の特記, RString 初期の概況調査場所, RString 現在の概況調査場所,
            RString 初期のサービス区分, RString 現在のサービス区分,
            RString 初期の予防給付サービス, RString 初期の介護給付サービス,
            RString 初期の施設利用, RString 初期の施設連絡先, RString 初期の基本調査) {

        boolean is在宅等しい = is在宅等しい(初期の予防給付サービス, 初期の介護給付サービス);
        boolean is市町村特別給付_等しい = is等しい(元の市町村特別給付TXT, div.getTxtShichosonTokubetsuKyufu().getValue());
        boolean is介護保険給付以外の在宅サービス_等しい = is等しい(元の介護保険給付以外の在宅サービスTXT, div.getTxtKyufuIgaiJutakuService().getValue());
        boolean is特記等しい = is等しい(元の特記,
                div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        boolean is施設等しい = is施設等しい(初期の施設利用);
        boolean is施設連絡先 = is施設連絡先等しい(初期の施設連絡先);

        boolean is状況コード等しい = is等しい(初期の概況調査場所, 現在の概況調査場所);
        boolean サービス区分等しい = is等しい(初期のサービス区分, 現在のサービス区分);

        return is在宅等しい && is市町村特別給付_等しい && is介護保険給付以外の在宅サービス_等しい && is特記等しい
                && is施設等しい && is施設連絡先 && is状況コード等しい && サービス区分等しい;

    }

    /**
     * 共有子DIV調査実施者の変更が存在しないかを判断します。
     *
     * @param 調査実施日 調査実施日
     * @param 調査実施場所 調査実施場所
     * @param 実施場所名称 実施場所名称
     * @param 所属機関 所属機関
     * @param 記入者 記入者
     * @return 判断結果(true:変更がない false:変更があり)
     */
    public boolean is調査実施者等しい(RString 調査実施日, RString 調査実施場所, RString 実施場所名称, RString 所属機関, RString 記入者) {

        boolean is調査実施日等しい = is等しい(調査実施日, div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText());
        boolean is調査実施場所等しい = is等しい(調査実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedValue());
        boolean is実施場所名称等しい = is等しい(実施場所名称, div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText());

        boolean is所属機関等しい = is等しい(所属機関, div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue());
        boolean is記入者等しい = is等しい(記入者, div.getCcdChosaJisshishaJoho().getDdlKinyusha().getSelectedValue());

        return is調査実施日等しい && is調査実施場所等しい && is実施場所名称等しい && is所属機関等しい && is記入者等しい;
    }

    private boolean is在宅等しい(RString 初期の予防給付サービス, RString 初期の介護給付サービス) {
        boolean is在宅等しい;
        RString 選択値 = div.getRadGenzaiservis().getSelectedKey();
        RString 現在の設定値 = RString.EMPTY;
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            is在宅等しい = is等しい(初期の予防給付サービス, 現在の設定値);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceSecondHalf_Row> fistHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
            for (dgRiyoSerViceSecondHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            is在宅等しい = is等しい(初期の介護給付サービス, 現在の設定値);
        } else {
            is在宅等しい = true;
        }
        return is在宅等しい;
    }

    private boolean is施設等しい(RString 初期の施設利用) {

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            施設利用 = 施設利用.concat(new RString(row.getShisetsuRiyoUmu().toString())).concat(カンマ);
        }
        return is等しい(初期の施設利用, 施設利用);
    }

    private boolean is施設連絡先等しい(RString 初期の施設連絡先) {

        RString 施設連絡先 = RString.EMPTY;
        RString 施設名称 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue();
        RString 郵便 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue().getColumnValue();
        RString 住所 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain().getColumnValue();
        RString 電話番号 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain().getColumnValue();

        if (施設名称.isEmpty() && 郵便.isEmpty() && 住所.isEmpty() && 電話番号.isEmpty()) {
            施設連絡先 = null;
        } else {
            施設連絡先 = 施設名称.concat(カンマ).concat(郵便).concat(カンマ).concat(住所).concat(カンマ)
                    .concat(電話番号);
        }
        return is等しい(初期の施設連絡先, 施設連絡先);

    }

    /**
     * 基本調査変更なしかを判断します。
     *
     * @param 初期の基本調査 初期の基本調査
     * @param 第1群List 第1群List
     * @param 第2群List 第2群List
     * @param 第3群List 第3群List
     * @param 第4群List 第4群List
     * @param 第5群List 第5群List
     * @param 特別な医療List 特別な医療List
     * @param 自立度List 自立度List
     * @return true:基本調査入力変更なし
     */
    public boolean is基本調査等しい(RString 初期の基本調査, ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {
        RString 現在の基本調査 = get現在の基本調査(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
        return is等しい(現在の基本調査, 初期の基本調査);
    }

    private boolean is等しい(RString beforeVal, RString afterVal) {
        if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal == null || afterVal.isEmpty())) {
            return true;
        } else if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal != null && !afterVal.isEmpty())) {
            return false;
        }
        return beforeVal.equals(afterVal);
    }

    @SuppressWarnings("unchecked")
    private RString get現在の基本調査(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {

        RString 第1群 = RString.EMPTY;
        RString 第2群 = RString.EMPTY;
        RString 第3群 = RString.EMPTY;
        RString 第4群 = RString.EMPTY;
        RString 第5群 = RString.EMPTY;
        RString 特別な医療 = RString.EMPTY;
        RString 自立度 = RString.EMPTY;

        if (第1群List != null) {
            for (KihonChosaInput 基本情報 : 第1群List) {
                第1群 = 第1群.concat(基本情報.get調査項目());
            }
        }
        if (第2群List != null) {
            for (KihonChosaInput 基本情報 : 第2群List) {
                第2群 = 第2群.concat(基本情報.get調査項目());
            }
        }
        if (第3群List != null) {
            for (KihonChosaInput 基本情報 : 第3群List) {
                第3群 = 第3群.concat(基本情報.get調査項目());
            }
        }
        if (第4群List != null) {
            for (KihonChosaInput 基本情報 : 第4群List) {
                第4群 = 第4群.concat(基本情報.get調査項目());
            }
        }
        if (第5群List != null) {
            for (KihonChosaInput 基本情報 : 第5群List) {
                第5群 = 第5群.concat(基本情報.get調査項目());
            }
        }
        if (特別な医療List != null) {
            for (KihonChosaInput 基本情報 : 特別な医療List) {
                特別な医療 = 特別な医療.concat(String.valueOf(基本情報.get調査項目()));
            }
        }
        if (自立度List != null) {
            int i = 0;
            for (KihonChosaInput 基本情報 : 自立度List) {
                if (i == 0) {
                    自立度 = 自立度.concat(基本情報.get障害高齢者自立度().getKey());
                } else if (i == 1) {
                    自立度 = 自立度.concat(基本情報.get認知症高齢者自立度().getKey());
                }
                i++;
            }
        }

        return 第1群.concat(第2群).concat(第3群).concat(第4群).concat(第5群).concat(特別な医療).concat(自立度);
    }

    /**
     * 基本調査の必須入力チェックを行います。
     *
     * @param 第1群List 第1群List
     * @param 第2群List 第2群List
     * @param 第3群List 第3群List
     * @param 第4群List 第4群List
     * @param 第5群List 第5群List
     * @param 自立度List 自立度List
     */
    public void 基本調査の必須入力チェック(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 自立度List) {
        基本調査1の必須入力チェック(第1群List);
        基本調査2の必須入力チェック(第2群List);
        基本調査3の必須入力チェック(第3群List);
        基本調査4の必須入力チェック(第4群List);
        基本調査5の必須入力チェック(第5群List);
        基本調査7の必須入力チェック(自立度List);
    }

    private void 基本調査1の必須入力チェック(ArrayList<KihonChosaInput> 第1群List) {
        int size = 0;
        int 連番;
        for (KihonChosaInput joho : 第1群List) {
            連番 = joho.get調査連番();
            if (連番 != INDEX_1 && 連番 != INDEX_2 && 連番 != INDEX_3 && 連番 != INDEX_4 && 連番 != INDEX_5
                    && 連番 != INDEX_6 && 連番 != INDEX_7 && 連番 != INDEX_8 && 連番 != INDEX_9) {
                size++;
            }
        }
        if (size == INDEX_11) {
            div.setHiddenKihonChosaInput1Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput1Flag(基本調査入力NG);
        }
    }

    private void 基本調査2の必須入力チェック(ArrayList<KihonChosaInput> 第2群List) {
        if (第2群List != null && 第2群List.size() == INDEX_12) {
            div.setHiddenKihonChosaInput2Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput2Flag(基本調査入力NG);
        }
    }

    private void 基本調査3の必須入力チェック(ArrayList<KihonChosaInput> 第3群List) {
        if (第3群List != null && 第3群List.size() == INDEX_9) {
            div.setHiddenKihonChosaInput3Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput3Flag(基本調査入力NG);
        }
    }

    private void 基本調査4の必須入力チェック(ArrayList<KihonChosaInput> 第4群List) {
        if (第4群List != null && 第4群List.size() == INDEX_15) {
            div.setHiddenKihonChosaInput4Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput4Flag(基本調査入力NG);
        }
    }

    private void 基本調査5の必須入力チェック(ArrayList<KihonChosaInput> 第5群List) {
        if (第5群List != null && 第5群List.size() == INDEX_6) {
            div.setHiddenKihonChosaInput5Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput5Flag(基本調査入力NG);
        }
    }

    private void 基本調査7の必須入力チェック(ArrayList<KihonChosaInput> 自立度List) {
        boolean 障害高齢者の日常生活自立度_選択 = false;
        boolean 認知症高齢者の日常生活自立度_選択 = false;
        for (KihonChosaInput joho : 自立度List) {
            if (!joho.get認知症高齢者自立度().isEmpty()) {
                障害高齢者の日常生活自立度_選択 = true;
            }
            if (!joho.get障害高齢者自立度().isEmpty()) {
                認知症高齢者の日常生活自立度_選択 = true;
            }
        }
        if (障害高齢者の日常生活自立度_選択 && 認知症高齢者の日常生活自立度_選択) {
            div.setHiddenKihonChosaInput7Flag(基本調査入力OK);
        } else {
            div.setHiddenKihonChosaInput7Flag(基本調査入力NG);
        }
    }

    /**
     * ボタン「前回値をコピーする」を押下する処理です。
     *
     * @param 第1群List 第1群List
     * @param 第2群List 第2群List
     * @param 第3群List 第3群List
     * @param 第4群List 第4群List
     * @param 第5群List 第5群List
     * @param 特別な医療List 特別な医療List
     * @param 自立度List 自立度List
     */
    @SuppressWarnings("unchecked")
    public void 前回値コピー処理(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {

        for (KihonChosaInput 基本情報 : 第1群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 特別な医療List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get認知症高齢者自立度(),
                    基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 自立度List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(), 基本情報.get前回認知症高齢者自立度(),
                    基本情報.get前回障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }

    }

    /**
     * ボタン「規定値を設定する」を押下する処理です。
     *
     * @param 第1群List 第1群List
     * @param 第2群List 第2群List
     * @param 第3群List 第3群List
     * @param 第4群List 第4群List
     * @param 第5群List 第5群List
     */
    @SuppressWarnings("unchecked")
    public void 規定値設定処理(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List, ArrayList<KihonChosaInput> 第5群List) {

        for (KihonChosaInput 基本情報 : 第1群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(),
                    基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(),
                    基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(),
                    基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(),
                    基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(), 基本情報.get認定調査依頼履歴番号(),
                    基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目());
        }
    }

}
