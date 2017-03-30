/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbe.business.core.tokkijikoinput.TokkiJikoInputModel;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImageFileItem;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.IGaikyoChosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyoukflg.GaikyoChosahyouServiceJyoukFlg09B;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.ImageFileName;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijipanteisyori.IChiJiPanTeiSyoRiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoServiceJyokyo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplZaitakuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijikoManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInputBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.GaikyoChosaTokkiManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ImageManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoChosaItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKihonChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.chosajisshishajoho.ChosaJisshishaJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ichijipanteisyori.IChiJiPanTeiSyoRiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 認定調査結果登録1のクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public class NinnteiChousaKekkaTouroku1Handler {

    private final NinnteiChousaKekkaTouroku1Div div;

    private static final RString KEY_登録修正 = new RString("0");
    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString カンマ = new RString(",");
    private static final RString png拡張子 = new RString(".png");
    private static final RString 予防給付サービス = new RString("介護予防");
    private static final RString 介護給付サービス = new RString("介護");
    private static final RString 認定調査項目_第1群 = new RString("1");
    private static final RString 認定調査項目_第2群 = new RString("2");
    private static final RString 認定調査項目_第3群 = new RString("3");
    private static final RString 認定調査項目_第4群 = new RString("4");
    private static final RString 認定調査項目_第5群 = new RString("5");
    private static final RString 認定調査項目_第6群 = new RString("6");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final int データベース内連番_1 = 1;
    private static final int データベース内連番_2 = 2;
    private static final int データベース内連番_3 = 3;
    private static final int データベース内連番_4 = 4;
    private static final int データベース内連番_5 = 5;
    private static final int データベース内連番_6 = 6;
    private static final int データベース内連番_7 = 7;
    private static final int データベース内連番_8 = 8;
    private static final int データベース内連番_9 = 9;
    private static final int 第二群開始連番 = 21;
    private static final int 第三群開始連番 = 33;
    private static final int 第四群開始連番 = 42;
    private static final int 第五群開始連番 = 57;
    private static final int 自立度群開始連番 = 75;
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
    private static final int データベース内連番_76 = 76;
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
    private static final RString KEY1 = new RString("第1群");
    private static final RString KEY2 = new RString("第2群");
    private static final RString KEY3 = new RString("第3群");
    private static final RString KEY4 = new RString("第4群");
    private static final RString KEY5 = new RString("第5群");
    private static final RString KEY6 = new RString("特別な医療群");
    private static final RString KEY7 = new RString("自立度群");
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
    private final DbT5121ShinseiRirekiJohoDac DbT5121Dac;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査結果登録1のコントロールdiv
     */
    public NinnteiChousaKekkaTouroku1Handler(NinnteiChousaKekkaTouroku1Div div) {
        this.div = div;
        this.DbT5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
    }

    public void onLoad(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        div.getCcdNinteiShinseishaKihonInfo().initialize(申請書管理番号);
        div.getCcdNinteiShinseiRenrakusakiKihon().initialize(申請書管理番号);
        div.getRadUpdateKind().setSelectedKey(KEY_登録修正);

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData 概況調査情報 = finder.get概況調査情報(申請書管理番号, 認定調査履歴番号);
        initialize概況基本調査情報(申請書管理番号, 認定調査履歴番号, 概況調査情報);
        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        setChosaJisshishaJohoModel(model, 申請書管理番号, 認定調査履歴番号, 概況調査情報);
        調査実施者情報子DIV初期化(model);
    }

    private void initialize概況基本調査情報(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号, TempData 概況調査情報) {
        if (概況調査情報 != null) {
            基本調査の初期化(申請書管理番号, true, 認定調査履歴番号);
            ViewStateHolder.put(ViewStateKeys.概況調査テキスト_イメージ区分, 概況調査情報.getTemp_概況調査テキストイメージ区分());
        } else {
            基本調査の初期化(申請書管理番号, false, 認定調査履歴番号);
            ViewStateHolder.put(ViewStateKeys.概況調査テキスト_イメージ区分, RString.EMPTY);
            div.getRadUpdateKind().setDisabled(true);
        }
        概況調査の初期化(概況調査情報, 申請書管理番号, 認定調査履歴番号);
        概況調査_住宅改修情報の初期化(申請書管理番号, 認定調査履歴番号);
        概況調査_給付関連情報の初期化(概況調査情報, 申請書管理番号, 認定調査履歴番号);
        initialize一次判定(申請書管理番号);
        特記事項情報の初期化(申請書管理番号, 認定調査履歴番号);
    }

    public void 編集前調査実施者情報設定() {
        RStringBuilder builder = new RStringBuilder();

        builder.append(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getText() != null ? div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho() != null ? div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getText() != null ? div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText() != null ? div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText() : RString.EMPTY);
        builder.append(div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText() != null ? div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText() : RString.EMPTY);
        builder.append(div.getRadGenzaiservis().getSelectedKey());
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().getSelectedKey());
        for (dgRiyoServiceJyokyo_Row row : div.getTabChosaShurui().getDgRiyoServiceJyokyo().getDataSource()) {
            builder.append(row.getServiceJokyo() != null ? row.getServiceJokyo().getText() : RString.EMPTY);
        }
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().getText() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().getText() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().getText() : RString.EMPTY);
        for (dgRiyoShisetsu_Row row : div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource()) {
            builder.append(new RString(row.getShisetsuRiyoUmu().toString()));
        }
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho().getText() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuMeisdho().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo().getText() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuYubinNo().getText() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtShisetsuJusho().getDomain().value() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo() != null
                ? div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().getTxtTelNo().getDomain().value() : RString.EMPTY);
        builder.append(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getText() != null
                ? div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue() : RString.EMPTY);
        builder.append(div.getTxtIchijiHanteiKekka().getText() != null
                ? div.getTxtIchijiHanteiKekka().getValue() : RString.EMPTY);
        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class);
        for (KihonChosaInput item : 第1群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第2群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第3群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第4群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 第5群List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 特別な医療List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }

        for (KihonChosaInput item : 自立度List) {
            builder.append(item.get前回認知症高齢者自立度());
            builder.append(item.get前回調査連番());
            builder.append(item.get前回調査項目());
            builder.append(item.get前回障害高齢者自立度());
            builder.append(item.get申請書管理番号().value());
            builder.append(item.get認定調査依頼履歴番号());
            builder.append(item.get認知症高齢者自立度());
            builder.append(item.get調査連番());
            builder.append(item.get調査項目());
            builder.append(item.get障害高齢者自立度());
            builder.append(item.is特記事項有無());
        }
        HashMap gaikyoTokkiNyurokuMap = ViewStateHolder.get(ViewStateKeys.特記事項一覧, LinkedHashMap.class);
        Set<Map.Entry<RString, TokkiJikoInputModel>> set = gaikyoTokkiNyurokuMap.entrySet();
        Iterator<Map.Entry<RString, TokkiJikoInputModel>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<RString, TokkiJikoInputModel> entry = it.next();
            TokkiJikoInputModel value = entry.getValue();
            builder.append(value.get特記事項());
            builder.append(value.get特記事項番号());
            builder.append(value.get特記連番());
        }
        ViewStateHolder.put(ViewStateKeys.画面データ, builder.toRString());
    }

    private void 特記事項情報の初期化(ShinseishoKanriNo temp_申請書管理番号, int temp_認定調査履歴番号) {
        NinteichosahyoTokkijikoManager manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        List<NinteichosahyoTokkijiko> returnList = manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号,
                TokkijikoTextImageKubun.テキスト.getコード(), new Code(GenponMaskKubun.原本.getコード()));
        List<GaikyoTokkiYichiranNyurokuBusiness> tokkiJikoList = new ArrayList<>();
        for (NinteichosahyoTokkijiko 特記事項Entity : returnList) {
            GaikyoTokkiYichiranNyurokuBusiness business = get概況特記一覧Entity(特記事項Entity);
            tokkiJikoList.add(business);
        }
        HashMap<RString, TokkiJikoInputModel> tokkiJikoMap = new LinkedHashMap<>();
        int tokkiJikoMapKey = 1;
        for (GaikyoTokkiYichiranNyurokuBusiness business : tokkiJikoList) {
            TokkiJikoInputModel model = new TokkiJikoInputModel();
            setTokkiJikoInputModel(model, business);
            tokkiJikoMap.put(new RString(tokkiJikoMapKey), model);
            tokkiJikoMapKey++;
        }
        ViewStateHolder.put(ViewStateKeys.特記事項一覧, tokkiJikoMap);
    }

    private GaikyoTokkiYichiranNyurokuBusiness get概況特記一覧Entity(NinteichosahyoTokkijiko 認定調査票特記事項) {
        GaikyoTokkiYichiranNyurokuBusiness entity = new GaikyoTokkiYichiranNyurokuBusiness();
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_認定調査特記事項番号(認定調査票特記事項.get認定調査特記事項番号());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().
                setTemp_認定調査特記事項連番(new RString(String.valueOf(認定調査票特記事項.get認定調査特記事項連番())));
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項テキストイメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_原本マスク区分(GenponMaskKubun.原本.getコード());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項名称(
                NinteichosaKomoku09B.getAllBy調査特記事項番(認定調査票特記事項.get認定調査特記事項番号()).get名称());
        entity.getGaikyoTokkiYichiranNyurokuRelateEntity().setTemp_特記事項(認定調査票特記事項.get特記事項());
        return entity;
    }

    private void setTokkiJikoInputModel(TokkiJikoInputModel model, GaikyoTokkiYichiranNyurokuBusiness business) {
        model.set特記事項番号(business.getTemp_認定調査特記事項番号());
        model.set特記連番(Integer.parseInt(business.getTemp_認定調査特記事項連番().toString()));
        model.set特記事項(business.getTemp_特記事項());
        model.setBeforeRowState(RowState.Unchanged);
        model.setRowState(RowState.Unchanged);
    }

    private void 概況調査の初期化(TempData 概況調査情報, ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        if (概況調査情報 != null) {
            在宅施設タブの設定(概況調査情報.getTemp_現在の状況コード());
            サービス区分の設定(概況調査情報.getTemp_現在のサービス区分コード());
            施設関連の詳細設定(概況調査情報, 申請書管理番号, 認定調査履歴番号);
            概況調査特記の設定(概況調査情報);
        } else {
            div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修_無);
            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoServiceJyokyo().setVisible(true);
            div.getTabChosaShurui().getGaikyoTokkiInput().getTokki().setDisplayNone(true);
            div.getImageGaigyoShisetsuRenrakusaki().setDisplayNone(true);
        }
        給付サービスの初期設定(申請書管理番号, 認定調査履歴番号);
        利用施設の初期設定(申請書管理番号, 認定調査履歴番号);
    }

    private void 概況調査特記の設定(TempData 概況調査情報) {
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(概況調査情報.getTemp_概況調査テキストイメージ区分())) {
            div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setDisplayNone(true);
            setImage概況特記();
        } else {
            div.getTabChosaShurui().getGaikyoTokkiInput().getTokki().setDisplayNone(true);
            div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(概況調査情報.getTemp_特記());
        }
    }

    private void setImage概況特記() {
        RString 出力イメージフォルダパス = ViewStateHolder.get(ViewStateKeys.イメージ取込み, RString.class);

        RString 概況調査特記原本ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.概況調査特記_原本.getImageFileName());
        if (!RString.isNullOrEmpty(概況調査特記原本ImagePath)) {
            div.getTabChosaShurui().getGaikyoTokkiInput().getTokki().getImgTokkiJiko().setSrc(DBEImageUtil.sanitizePath(概況調査特記原本ImagePath));
        } else {
            RString 概況調査特記ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.概況調査特記.getImageFileName());
            div.getTabChosaShurui().getGaikyoTokkiInput().getTokki().getImgTokkiJiko().setSrc(DBEImageUtil.sanitizePath(概況調査特記ImagePath));
        }
        div.getTabChosaShurui().getGaikyoTokkiInput().getBtnTeikeibun().setDisplayNone(true);
    }

    private void 在宅施設タブの設定(RString 現在の状況コード) {
        if (在宅.equals(現在の状況コード)) {
            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
        } else {
            div.getTabChosaBasho().setSelectedItem(new tplShisetsuDiv());
            div.getRadGenzaiservis().setDisabled(Boolean.TRUE);
        }
    }

    private void サービス区分の設定(RString サービス区分コード) {
        if (ServiceKubunCode.予防給付サービス.getコード().equals(サービス区分コード)) {
            div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(サービス区分コード)) {
            div.getRadGenzaiservis().setSelectedKey(介護給付サービス_選択);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoServiceJyokyo().setVisible(true);
        } else {
            div.getRadGenzaiservis().setSelectedKey(なし_選択);
            div.getDgRiyoServiceJyokyo().setDisabled(true);
        }
    }

    private void 施設関連の詳細設定(TempData 概況調査情報, ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        ViewStateHolder.put(ViewStateKeys.概況調査テキスト_イメージ区分, 概況調査情報.getTemp_概況調査テキストイメージ区分());
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(概況調査情報.getTemp_概況調査テキストイメージ区分())) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getGaigyoShisetsuRenrakusaki().setDisplayNone(true);
            setImage施設連絡先(申請書管理番号, 認定調査履歴番号);
        } else {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().setDisplayNone(true);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(概況調査情報.getTemp_利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo()
                    .setValue(new YubinNo(概況調査情報.getTemp_利用施設郵便番号() == null ? RString.EMPTY : 概況調査情報.getTemp_利用施設郵便番号()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho()
                    .setDomain(new AtenaJusho(概況調査情報.getTemp_利用施設住所() == null ? RString.EMPTY : 概況調査情報.getTemp_利用施設住所()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo()
                    .setDomain(new TelNo(概況調査情報.getTemp_利用施設電話番号() == null ? RString.EMPTY : 概況調査情報.getTemp_利用施設電話番号()));
        }
    }

    private void setImage施設連絡先(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        RString toCopyPath = get出力イメージフォルダパス(申請書管理番号, 認定調査履歴番号);
        ViewStateHolder.put(ViewStateKeys.イメージ取込み, toCopyPath);
        RString 出力イメージフォルダパス = ViewStateHolder.get(ViewStateKeys.イメージ取込み, RString.class);

        RString 施設名称ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設名.getImageFileName());
        RString 住所ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設住所.getImageFileName());
        RString 電話番号ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設電話番号.getImageFileName());
        if (!RString.isNullOrEmpty(施設名称ImagePath)) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgShisetsuMeisho().setSrc(DBEImageUtil.sanitizePath(施設名称ImagePath));
        }
        if (!RString.isNullOrEmpty(住所ImagePath)) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgJusho().setSrc(DBEImageUtil.sanitizePath(住所ImagePath));
        }
        if (!RString.isNullOrEmpty(電話番号ImagePath)) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getImageGaigyoShisetsuRenrakusaki().getImgTel().setSrc(DBEImageUtil.sanitizePath(電話番号ImagePath));
        }
    }

    private RString get出力イメージフォルダパス(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号) {
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(申請書管理番号.value(), 認定調査履歴番号, RString.EMPTY, RString.EMPTY);
        Image image = ChosaKekkaInfoGaikyoFinder.createInstance().get5115Image(gaikyoParameter);
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
        RString 共有ファイル名 = 証記載保険者番号.concat(被保険者番号);
        RString 出力イメージフォルダパス = DBEImageUtil.copySharedFiles(image.getイメージ共有ファイルID(), 共有ファイル名);
        return 出力イメージフォルダパス;
    }

    private void setChosaJisshishaJohoModel(ChosaJisshishaJohoModel model, ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号, TempData 概況調査情報) {
        model.set申請書管理番号(申請書管理番号.getColumnValue());
        model.set認定調査依頼履歴番号(認定調査履歴番号);
        if (概況調査情報 != null) {
            model.set調査実施日(概況調査情報.getTemp_調査実施年月日());
            model.set調査実施場所(ChosaJisshiBashoCode.toValue(概況調査情報.getTemp_調査実施場所コード()).get名称());
            model.set実施場所名称(概況調査情報.getTemp_調査実施場所名称());
            model.set所属機関コード(概況調査情報.getTemp_調査委託先コード());
            model.set記入者コード(概況調査情報.getTemp_調査員コード());
            ChosaJisshishaJohoFinder chosaJisshishaJohoFinder = ChosaJisshishaJohoFinder.createInstance();
            List<NinteichosaItakusakiJoho> ninteichosaItakusakiJohoList = chosaJisshishaJohoFinder.getSyozokuKikan(申請書管理番号.value()).records();
            for (NinteichosaItakusakiJoho joho : ninteichosaItakusakiJohoList) {
                if (joho.get認定調査委託先コード().equals(概況調査情報.getTemp_調査委託先コード())) {
                    model.set所属機関名称(joho.get事業者名称());
                }
            }
            List<ChosainJoho> chosainJohoList = chosaJisshishaJohoFinder.getKinyusha(申請書管理番号.value()).records();
            for (ChosainJoho chosainJoho : chosainJohoList) {
                if (chosainJoho.get認定調査員コード().equals(概況調査情報.getTemp_調査員コード())) {
                    model.set記入者名称(chosainJoho.get調査員氏名());
                }
            }
            model.setイメージテキスト区分(ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class));
            model.set実施場所ImagePath(ViewStateHolder.get(ViewStateKeys.イメージ情報, RString.class));
        }
    }

    private void 基本調査の初期化(ShinseishoKanriNo 申請書管理番号, boolean isExistsKihonChosaData, Integer 認定調査履歴番号) {
        ArrayList<KihonChosaInput> 第1群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第2群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第3群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第4群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第5群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療List = new ArrayList<>();
        ArrayList<KihonChosaInput> 自立度List = new ArrayList<>();

        RString 初期の基本調査 = 基本調査の初期化(申請書管理番号, 認定調査履歴番号, isExistsKihonChosaData, 第1群List, 第2群List,
                第3群List, 第4群List, 第5群List, 特別な医療List, 自立度List);
        boolean 前回基本調査項目値あり = new RString("T").equals(初期の基本調査.substring(初期の基本調査.length() - 1, 初期の基本調査.length()));
        ViewStateHolder.put(ViewStateKeys.前回基本調査項目値あり, 前回基本調査項目値あり);
        ViewStateHolder.put(ViewStateKeys.初期の基本調査, 初期の基本調査.substring(0, 初期の基本調査.length() - 1));

        基本調査の必須入力チェック(第1群List, 第2群List, 第3群List, 第4群List, 第5群List, 自立度List);

        ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, 第1群List);
        ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, 第2群List);
        ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, 第3群List);
        ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, 第4群List);
        ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, 第5群List);
        ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, 特別な医療List);
        ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, 自立度List);
    }

    private void initialize一次判定(ShinseishoKanriNo 申請書管理番号) {
        IchijiHanteiKekkaJohoManager ichijiHanteiKekkaJohoManager = new IchijiHanteiKekkaJohoManager();
        IchijiHanteiKekkaJoho result = ichijiHanteiKekkaJohoManager.get要介護認定一次判定結果情報(申請書管理番号);
        Code 厚労省IF識別コード = new Code(ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class));
        div.setIchijiHanteiKekkaJoho(RString.EMPTY);
        if (result != null) {
            div.setIchijiHanteiKekkaJoho(DataPassingConverter.serialize(result));
            RString meisho;
            meisho = result.get一次判定結果名称(厚労省IF識別コード);
            div.getTxtIchijiHanteiKekka().setValue(meisho);
        }
    }

    /**
     * 調査実施者情報子DIV初期化の処理です。
     *
     * @param model 調査実施者情報に渡すパラメータ
     */
    private void 調査実施者情報子DIV初期化(ChosaJisshishaJohoModel model) {
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Input);
        div.getCcdChosaJisshishaJoho().intialize(model);
        RString 概況調査テキストイメージ区分 = ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class);
        if (TokkijikoTextImageKubun.イメージ.getコード().equals(概況調査テキストイメージ区分)) {
            div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().setDisplayNone(true);
            setImage認定調査実施場所();
        } else {
            div.getCcdChosaJisshishaJoho().getImage().setDisplayNone(true);
        }
    }

    private void setImage認定調査実施場所() {
        RString 出力イメージフォルダパス = ViewStateHolder.get(ViewStateKeys.イメージ取込み, RString.class);

        RString 実施場所ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.調査実施場所.getImageFileName());
        if (!RString.isNullOrEmpty(実施場所ImagePath)) {
            div.getCcdChosaJisshishaJoho().getImage().getImgChosaJisshiBashoMeisho().setSrc(DBEImageUtil.sanitizePath(実施場所ImagePath));
            ViewStateHolder.put(ViewStateKeys.イメージ情報, DBEImageUtil.sanitizePath(実施場所ImagePath));
        }
    }

    private void 給付サービスの初期設定(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        NinteichosahyoServiceJokyoManager ninteichosahyoServiceJokyoManager = InstanceProvider.create(NinteichosahyoServiceJokyoManager.class);
        List<NinteichosahyoServiceJokyo> 認定調査票サービス状況リスト = ninteichosahyoServiceJokyoManager.selectサービスの状況(申請書管理番号, 認定調査履歴番号).records();

        List<dgRiyoServiceJyokyo_Row> サービス利用リスト = new ArrayList<>();
        IGaikyoChosahyoServiceJokyo 概況調査サービス状況;
        if (認定調査票サービス状況リスト != null && !認定調査票サービス状況リスト.isEmpty()) {
            for (NinteichosahyoServiceJokyo 認定調査票サービス状況 : 認定調査票サービス状況リスト) {
                try {
                    概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(認定調査票サービス状況.get連番()));
                } catch (Exception e) {
                    概況調査サービス状況 = null;
                }
                if (概況調査サービス状況 != null) {
                    if (介護給付サービス_選択.equals(div.getRadGenzaiservis().getSelectedKey())) {
                        if (予防給付サービス.equals(概況調査サービス状況.get給付区分()) || 介護給付サービス.equals(概況調査サービス状況.get給付区分())) {
                            サービス利用リスト.add(getサービス状況レコード(認定調査票サービス状況, 概況調査サービス状況));
                        }
                    } else {
                        if (予防給付サービス.equals(概況調査サービス状況.get給付区分())) {
                            サービス利用リスト.add(getサービス状況レコード(認定調査票サービス状況, 概況調査サービス状況));
                        }
                    }
                }
            }
        } else {
            サービス利用リスト = 給付サービスの新規設定();
        }
        div.getTabChosaShurui().getDgRiyoServiceJyokyo().setDataSource(サービス利用リスト);
    }

    private dgRiyoServiceJyokyo_Row getサービス状況レコード(NinteichosahyoServiceJokyo 認定調査票サービス状況,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況) {
        dgRiyoServiceJyokyo_Row row = new dgRiyoServiceJyokyo_Row();
        row.getRemban().setValue(Decimal.valueOf(概況調査サービス状況.get連番AsInt()));
        row.getServiceMeisho().setValue(概況調査サービス状況.get名称());
        row.setTani(概況調査サービス状況.get単位1().concat(概況調査サービス状況.get単位2()));
        row.getServiceJokyo().setValue(Decimal.valueOf(認定調査票サービス状況.getサービスの状況()));
        return row;
    }

    private List<dgRiyoServiceJyokyo_Row> 給付サービスの新規設定() {
        RString 厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        List<dgRiyoServiceJyokyo_Row> サービス利用リスト = new ArrayList<>();
        if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
            for (CKGaikyoChosahyouServiceJyouk09B 概況調査サービス状況 : CKGaikyoChosahyouServiceJyouk09B.values()) {
                if (介護給付サービス_選択.equals(div.getRadGenzaiservis().getSelectedKey())) {
                    if (予防給付サービス.equals(概況調査サービス状況.get給付区分()) || 介護給付サービス.equals(概況調査サービス状況.get給付区分())) {
                        サービス利用リスト.add(getサービス状況レコード_OnlyName(概況調査サービス状況));
                    }
                } else {
                    if (予防給付サービス.equals(概況調査サービス状況.get給付区分())) {
                        サービス利用リスト.add(getサービス状況レコード_OnlyName(概況調査サービス状況));
                    }
                }
            }
        }
        return サービス利用リスト;
    }

    private dgRiyoServiceJyokyo_Row getサービス状況レコード_OnlyName(IGaikyoChosahyoServiceJokyo 概況調査サービス状況) {
        dgRiyoServiceJyokyo_Row row = new dgRiyoServiceJyokyo_Row();
        row.getRemban().setValue(Decimal.valueOf(概況調査サービス状況.get連番AsInt()));
        row.getServiceMeisho().setValue(概況調査サービス状況.get名称());
        row.setTani(概況調査サービス状況.get単位1().concat(概況調査サービス状況.get単位2()));
        return row;
    }

    private void 利用施設の初期設定(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号) {
        NinteichosahyoShisetsuRiyoManager ninteichosahyoShisetsuRiyoManager = InstanceProvider.create(NinteichosahyoShisetsuRiyoManager.class);
        List<NinteichosahyoShisetsuRiyo> 認定調査票施設利用リスト
                = ninteichosahyoShisetsuRiyoManager.get連番除外の認定調査票_概況調査_施設利用(申請書管理番号, 認定調査履歴番号).records();

        List<dgRiyoShisetsu_Row> 施設利用リスト = new ArrayList<>();
        GaikyoChosahyouNiteichosahyouSisetuRiy09B 概況調査利用施設;
        if (認定調査票施設利用リスト != null && !認定調査票施設利用リスト.isEmpty()) {
            for (NinteichosahyoShisetsuRiyo 認定調査票施設利用情報 : 認定調査票施設利用リスト) {
                try {
                    概況調査利用施設 = GaikyoChosahyouNiteichosahyouSisetuRiy09B.toValue(new RString(認定調査票施設利用情報.get連番()));
                } catch (Exception e) {
                    概況調査利用施設 = null;
                }
                if (概況調査利用施設 != null) {
                    施設利用リスト.add(get利用施設レコード(認定調査票施設利用情報, 概況調査利用施設));
                }
            }
        } else {
            施設利用リスト = 利用施設の新規設定();
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(施設利用リスト);
    }

    private dgRiyoShisetsu_Row get利用施設レコード(NinteichosahyoShisetsuRiyo 認定調査票施設利用情報,
            GaikyoChosahyouNiteichosahyouSisetuRiy09B 概況調査利用施設) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.getRemban().setValue(Decimal.valueOf(概況調査利用施設.get連番AsInt()));
        row.setShisetsuRiyoName(概況調査利用施設.get名称());
        row.setShisetsuRiyoUmu(認定調査票施設利用情報.is施設利用フラグ());
        return row;
    }

    private List<dgRiyoShisetsu_Row> 利用施設の新規設定() {
        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList<>();
        for (GaikyoChosahyouNiteichosahyouSisetuRiy09B 概況調査利用施設 : GaikyoChosahyouNiteichosahyouSisetuRiy09B.values()) {
            riyoShisetsuList.add(get利用施設レコード_OnlyName(概況調査利用施設));
        }
        return riyoShisetsuList;
    }

    private dgRiyoShisetsu_Row get利用施設レコード_OnlyName(GaikyoChosahyouNiteichosahyouSisetuRiy09B 概況調査利用施設) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.getRemban().setValue(Decimal.valueOf(概況調査利用施設.get連番AsInt()));
        row.setShisetsuRiyoName(概況調査利用施設.get名称());
        return row;
    }

    private void 概況調査_住宅改修情報の初期化(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号) {
        RString 住宅改修 = 住宅改修_無;
        NinteichosahyoServiceJokyoFlagManager manager = new NinteichosahyoServiceJokyoFlagManager();
        List<NinteichosahyoServiceJokyoFlag> servieceFlagList = manager.get認定調査票_概況調査_サービスの状況フラグList(申請書管理番号, 認定調査履歴番号);
        for (NinteichosahyoServiceJokyoFlag serviceFlag : servieceFlagList) {
            if (GaikyoChosahyouServiceJyoukFlg09B.住宅改修.get連番().equals(new RString(serviceFlag.get連番()))) {
                if (serviceFlag.isサービスの状況フラグ()) {
                    住宅改修 = 住宅改修_有;
                }
            }
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修);
    }

    private void 概況調査_給付関連情報の初期化(TempData 概況調査情報, ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号) {
        if (概況調査情報 != null && TokkijikoTextImageKubun.イメージ.getコード().equals(概況調査情報.getTemp_概況調査テキストイメージ区分())) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setDisplayNone(true);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setDisplayNone(true);
            setImage給付関連();
        } else {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getShichosonTokubetsuKyufu().setDisplayNone(true);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getZaitakuService().setDisplayNone(true);
            NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
            List<NinteichosahyoKinyuItem> 認定調査記入項目List = manager.get認定調査票_概況調査_記入項目List(申請書管理番号, 認定調査履歴番号);
            for (NinteichosahyoKinyuItem 認定調査記入項目 : 認定調査記入項目List) {
                if (GaikyoChosahyouKinyuKomoku09B.市町村特別給付.get連番().equals(new RString(認定調査記入項目.get連番()))) {
                    div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setValue(認定調査記入項目.getサービスの状況記入());
                } else if (GaikyoChosahyouKinyuKomoku09B.介護保険給付外の在宅サービス.get連番().equals(new RString(認定調査記入項目.get連番()))) {
                    div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setValue(認定調査記入項目.getサービスの状況記入());
                }
            }
        }
    }

    private void setImage給付関連() {
        RString 出力イメージフォルダパス = ViewStateHolder.get(ViewStateKeys.イメージ取込み, RString.class);

        RString 特別給付ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.市町村特別給付.getImageFileName());
        if (!RString.isNullOrEmpty(特別給付ImagePath)) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getShichosonTokubetsuKyufu().getImgShichosonTokubetsuKyufu().setSrc(DBEImageUtil.sanitizePath(特別給付ImagePath));
        }
        RString 在宅サービスImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.介護保険給付外のサービス.getImageFileName());
        if (!RString.isNullOrEmpty(在宅サービスImagePath)) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getZaitakuService().getImgZaitakuService().setSrc(DBEImageUtil.sanitizePath(在宅サービスImagePath));
        }
    }

    /**
     * 利用サービス区分の切り替え処理です。
     *
     */
    public void サービス区分の切り替え() {
        if (なし_選択.equals(div.getRadGenzaiservis().getSelectedKey())) {
            div.getNinteiChosaNyuryoku().getTplGaikyoChosa().getDgRiyoServiceJyokyo().getDataSource().clear();
            List<dgRiyoServiceJyokyo_Row> DgRiyoServiceJokyo = 給付サービスの新規設定();
            div.getNinteiChosaNyuryoku().getTplGaikyoChosa().getDgRiyoServiceJyokyo().setDataSource(DgRiyoServiceJokyo);
            div.getDgRiyoServiceJyokyo().setDisabled(true);
        } else {
            div.getDgRiyoServiceJyokyo().setDisabled(false);
            利用サービスGrid切り替え();
        }
    }

    private void 利用サービスGrid切り替え() {
        List<dgRiyoServiceJyokyo_Row> currentDgRiyoServiceJokyo = div.getDgRiyoServiceJyokyo().getDataSource();
        List<dgRiyoServiceJyokyo_Row> newDgRiyoServiceJokyo = 給付サービスの新規設定();

        outSide:
        for (dgRiyoServiceJyokyo_Row newRow : newDgRiyoServiceJokyo) {
            for (dgRiyoServiceJyokyo_Row currentRow : currentDgRiyoServiceJokyo) {
                if (newRow.getRemban().getValue().equals(currentRow.getRemban().getValue())) {
                    newRow.setServiceJokyo(currentRow.getServiceJokyo());
                    continue outSide;
                }
            }
        }
        div.getDgRiyoServiceJyokyo().setDataSource(newDgRiyoServiceJokyo);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoServiceJyokyo().setVisible(true);
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
     * 規定値設定前に行う前処理です。
     *
     * @param map 第1群、第2群、特別な医療等の基本調査情報をmapにまとめたもの
     * @return 引数のmapを編集し、前処理を施したものを返す。
     */
    public Map<RString, ArrayList<KihonChosaInput>> 規定値設定の前処理(Map<RString, ArrayList<KihonChosaInput>> map) {
        ArrayList<KihonChosaInput> 第1群List = map.get(KEY1);
        第1群List.clear();
        ArrayList<KihonChosaInput> 第2群List = map.get(KEY2);
        第2群List.clear();
        ArrayList<KihonChosaInput> 第3群List = map.get(KEY3);
        第3群List.clear();
        ArrayList<KihonChosaInput> 第4群List = map.get(KEY4);
        第4群List.clear();
        ArrayList<KihonChosaInput> 第5群List = map.get(KEY5);
        第5群List.clear();
        ArrayList<KihonChosaInput> 特別な医療List = map.get(KEY6);
        特別な医療List.clear();
        ArrayList<KihonChosaInput> 自立度List = map.get(KEY7);
        自立度List.clear();

        for (int i = データベース内連番_1; i < データベース内連番_76 + 1; i++) {
            if (i < 第二群開始連番) {
                第1群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else if (i < 第三群開始連番) {
                第2群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else if (i < 第四群開始連番) {
                第3群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else if (i < 第五群開始連番) {
                第4群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else if (i < データベース内連番_63) {
                第5群List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else if (i < 自立度群開始連番) {
                特別な医療List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            } else {
                自立度List.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
                        i, 調査項目_ない, new Code(), new Code(), i, RString.EMPTY));
            }
        }

        map.put(KEY1, 第1群List);
        map.put(KEY2, 第2群List);
        map.put(KEY3, 第3群List);
        map.put(KEY4, 第4群List);
        map.put(KEY5, 第5群List);
        map.put(KEY6, 特別な医療List);
        map.put(KEY7, 自立度List);

        return map;
    }

    private RString 基本調査の初期化(ShinseishoKanriNo 申請書管理番号, Integer 認定調査履歴番号, boolean isExistsKihonChosaData,
            ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List, ArrayList<KihonChosaInput> 第5群List,
            ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {

        ArrayList<KihonChosaInput> 第1群 = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療 = new ArrayList<>();
        RString 自立度 = RString.EMPTY;
        boolean 前回基本調査項目値あり = false;

        KihonChosaInputFinder findler = KihonChosaInputFinder.createInstance();
        List<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        if (isExistsKihonChosaData) {
            認定調査基本情報リスト = findler.get認定調査基本情報(申請書管理番号);
        } else {
            RString 依頼区分コード = ViewStateHolder.get(ViewStateKeys.認定調査依頼区分コード, RString.class);
            前回申請書管理番号取得(認定調査履歴番号, 依頼区分コード, 申請書管理番号);
        }

        if (認定調査基本情報リスト.isEmpty()) {
            第1群.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, new Code(), new Code(),
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

    private void 前回申請書管理番号取得(Integer 認定調査履歴番号, RString 依頼区分コード, ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        List<DbT5121ShinseiRirekiJohoEntity> 申請履歴情報 = DbT5121Dac.select前回申請管理番号(申請書管理番号);
        if (!申請履歴情報.isEmpty()) {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号2, 申請履歴情報.get(0).getZenkaiShinseishoKanriNo());
        } else {
            ViewStateHolder.put(ViewStateKeys.申請書管理番号2, ShinseishoKanriNo.EMPTY);
        }
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
     * 入力内容を取り消します。
     */
    public void DataReset() {
        ArrayList<KihonChosaInput> list = new ArrayList<>();
        HashMap<RString, TokkiJikoInputModel> map = new LinkedHashMap<>();
        ViewStateHolder.put(ViewStateKeys.第一群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第二群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第三群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第四群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第五群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第六群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.第七群認定調査基本情報リスト, list);
        ViewStateHolder.put(ViewStateKeys.特記事項一覧, map);

        住宅改修と記入項目のクリア();
        div.getDgRiyoServiceJyokyo().getDataSource().clear();
        施設tplのクリア();
        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().clearValue();
    }

    /**
     * 入力内容をクリア後のロード処理です。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査履歴番号 int
     */
    public void onLoadAfterClear(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号) {
        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData 概況調査情報 = finder.get概況調査情報(申請書管理番号, 認定調査履歴番号);
        initialize概況基本調査情報(申請書管理番号, 認定調査履歴番号, 概況調査情報);
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
    public void 前回値コピー処理_前回申請(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {

        第1群List.clear();
        第2群List.clear();
        第3群List.clear();
        第4群List.clear();
        第5群List.clear();
        特別な医療List.clear();
        自立度List.clear();

        ShinseishoKanriNo 前回申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号2, ShinseishoKanriNo.class);
        NinteichosahyoKihonChosaManager ninteichosahyoKihonChosaManager = InstanceProvider.create(NinteichosahyoKihonChosaManager.class);
        NinteichosahyoKihonChosa 前回認定調査票_基本調査 = ninteichosahyoKihonChosaManager.get認定調査票_基本調査_最大履歴(前回申請書管理番号);

        int 前回認定調査履歴番号 = 前回認定調査票_基本調査.get要介護認定調査履歴番号();
        NinteichosahyoChosaItemManager ninteichosahyoChosaItemManager = InstanceProvider.create(NinteichosahyoChosaItemManager.class);
        List<NinteichosahyoChosaItem> 前回認定調査項目リスト
                = ninteichosahyoChosaItemManager.get認定調査票_基本調査_調査項目List(前回申請書管理番号, 前回認定調査履歴番号);

        for (NinteichosahyoChosaItem 前回認定調査項目 : 前回認定調査項目リスト) {
            NinteichosaKomokuMapping09B 認定調査項目マッピング = NinteichosaKomokuMapping09B.toValue(new RString(前回認定調査項目.get連番()));
            if (認定調査項目_第1群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 第1群List);
            } else if (認定調査項目_第2群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 第2群List);
            } else if (認定調査項目_第3群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 第3群List);
            } else if (認定調査項目_第4群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 第4群List);
            } else if (認定調査項目_第5群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 第5群List);
            } else if (認定調査項目_第6群.equals(認定調査項目マッピング.get群番号())) {
                createKihonChosaItemList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 前回認定調査項目, 特別な医療List);
            }
        }
        createKihonChosaList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 自立度List);
        createKihonChosaList(前回申請書管理番号, 前回認定調査履歴番号, 前回認定調査票_基本調査, 自立度List);
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
//    @SuppressWarnings("unchecked")
//    public void 前回値コピー処理_前回履歴(ArrayList<KihonChosaInput> 第1群List, ArrayList<KihonChosaInput> 第2群List,
//            ArrayList<KihonChosaInput> 第3群List, ArrayList<KihonChosaInput> 第4群List,
//            ArrayList<KihonChosaInput> 第5群List, ArrayList<KihonChosaInput> 特別な医療List, ArrayList<KihonChosaInput> 自立度List) {
//
//        第1群List.clear();
//        第2群List.clear();
//        第3群List.clear();
//        第4群List.clear();
//        第5群List.clear();
//        特別な医療List.clear();
//        自立度List.clear();
//        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
//        int 認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
//        int 前回認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class) - 1;
//
//        NinteichosahyoKihonChosaManager ninteichosahyoKihonChosaManager = InstanceProvider.create(NinteichosahyoKihonChosaManager.class);
//        NinteichosahyoKihonChosa 認定調査票_基本調査 = ninteichosahyoKihonChosaManager.get認定調査票_基本調査(申請書管理番号, 前回認定調査履歴番号);
//
//        NinteichosahyoChosaItemManager ninteichosahyoChosaItemManager = InstanceProvider.create(NinteichosahyoChosaItemManager.class);
//        List<NinteichosahyoChosaItem> 認定調査項目リスト = ninteichosahyoChosaItemManager.get認定調査票_基本調査_調査項目List(申請書管理番号, 前回認定調査履歴番号);
//        RString 厚労省IF識別コード = RString.EMPTY;
//        if (認定調査項目リスト != null) {
//            厚労省IF識別コード = 認定調査項目リスト.get(0).get厚労省IF識別コード().value();
//        }
//        if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
//            for (NinteichosahyoChosaItem 認定調査項目 : 認定調査項目リスト) {
//                NinteichosaKomokuMapping09B 認定調査項目マッピング = NinteichosaKomokuMapping09B.toValue(new RString(認定調査項目.get連番()));
//                if (認定調査項目_第1群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 第1群List);
//                } else if (認定調査項目_第2群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 第2群List);
//                } else if (認定調査項目_第3群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 第3群List);
//                } else if (認定調査項目_第4群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 第4群List);
//                } else if (認定調査項目_第5群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 第5群List);
//                } else if (認定調査項目_第6群.equals(認定調査項目マッピング.get群番号())) {
//                    createKihonChosaItemList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 認定調査項目, 特別な医療List);
//                }
//            }
//        }
//        createKihonChosaList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 自立度List);
//        createKihonChosaList(申請書管理番号, 認定調査履歴番号, 認定調査票_基本調査, 自立度List);
//    }
    private void createKihonChosaItemList(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号,
            NinteichosahyoKihonChosa 認定調査票_基本調査, NinteichosahyoChosaItem 認定調査項目, ArrayList<KihonChosaInput> 基本調査List) {
        KihonChosaInput 基本情報 = new KihonChosaInput(申請書管理番号,
                認定調査履歴番号,
                認定調査票_基本調査.get認定調査_認知症高齢者の日常生活自立度コード(),
                認定調査票_基本調査.get認定調査_障害高齢者の日常生活自立度コード(),
                認定調査項目.get連番(),
                認定調査項目.get調査項目(),
                認定調査票_基本調査.get認定調査_認知症高齢者の日常生活自立度コード(),
                認定調査票_基本調査.get認定調査_障害高齢者の日常生活自立度コード(),
                認定調査項目.get連番(),
                認定調査項目.get調査項目());
        基本調査List.add(基本情報);
    }

    private void createKihonChosaList(ShinseishoKanriNo 申請書管理番号, int 認定調査履歴番号,
            NinteichosahyoKihonChosa 認定調査票_基本調査, ArrayList<KihonChosaInput> 基本調査List) {
        KihonChosaInput 基本情報 = new KihonChosaInput(申請書管理番号,
                認定調査履歴番号,
                認定調査票_基本調査.get認定調査_認知症高齢者の日常生活自立度コード(),
                認定調査票_基本調査.get認定調査_障害高齢者の日常生活自立度コード(),
                Decimal.ZERO.intValue(),
                RString.EMPTY,
                認定調査票_基本調査.get認定調査_認知症高齢者の日常生活自立度コード(),
                認定調査票_基本調査.get認定調査_障害高齢者の日常生活自立度コード(),
                Decimal.ZERO.intValue(),
                RString.EMPTY);
        基本調査List.add(基本情報);
    }

    /**
     * 基本調査群に規定値(初期値)を設定する処理です。
     *
     * @param 基本調査群 基本調査群
     * @return 規定値基本調査群
     */
    @SuppressWarnings("unchecked")
    public ArrayList<KihonChosaInput> 基本調査群規定値設定(ArrayList<KihonChosaInput> 基本調査群) {
        ArrayList<KihonChosaInput> 規定値基本調査群 = new ArrayList<>();
        for (KihonChosaInput 基本情報 : 基本調査群) {
            KihonChosaInput 規定値基本情報 = new KihonChosaInput(基本情報.get申請書管理番号(),
                    基本情報.get認定調査依頼履歴番号(), new Code(NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード()),
                    new Code(ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード()), 基本情報.get調査連番(), 項目値１,
                    基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(), 基本情報.get前回調査連番(), 基本情報.get前回調査項目());
            規定値基本調査群.add(規定値基本情報);
        }
        return 規定値基本調査群;
    }

    @Transaction
    public void 更新処理() {
        認定調査依頼情報の更新();
        概況調査の更新();
        給付サービス状況の更新();
        サービス状況フラグの更新();
        記入項目の更新();
        施設利用の更新();
        調査項目の更新(false);
        if (!div.getNinteiChosaNyuryoku().getTplKihonChosa().getBtnTokkiJiko().isDisabled()) {
            特記事項の更新();
        }
    }

    @Transaction
    public void 削除処理() {
        認定調査依頼情報の削除();
        概況調査の削除();
        給付サービス状況の削除();
        サービス状況フラグの削除();
        記入項目の削除();
        施設利用の削除();
        調査項目の更新(true);

        概況調査特記マスクの削除();
        特記事項の削除();
        一次判定結果情報の削除();
        完了情報の削除();
        イメージ情報の削除();
    }

    private void 特記事項の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        HashMap gaikyoTokkiNyurokuMap = ViewStateHolder.get(ViewStateKeys.特記事項一覧, LinkedHashMap.class);
        if (gaikyoTokkiNyurokuMap != null && !gaikyoTokkiNyurokuMap.isEmpty()) {
            特記事項の削除();
            save認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号, gaikyoTokkiNyurokuMap.entrySet());
        }
    }

    private void save認定調査票_特記情報(ShinseishoKanriNo temp_申請書管理番号,
            int temp_認定調査履歴番号,
            Set<Map.Entry<RString, TokkiJikoInputModel>> set) {
        NinteichosahyoTokkijikoManager dbt5205Manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        Iterator<Map.Entry<RString, TokkiJikoInputModel>> it = set.iterator();
        RString 前認定調査特記事項番号 = RString.EMPTY;
        int 認定調査特記事項連番 = 1;

        while (it.hasNext()) {
            Map.Entry<RString, TokkiJikoInputModel> entry = it.next();
            TokkiJikoInputModel value = entry.getValue();
            if (RowState.Deleted.equals(value.getRowState())) {
                continue;
            }
            if (前認定調査特記事項番号.equals(value.get特記事項番号())) {
                認定調査特記事項連番++;
            } else {
                認定調査特記事項連番 = 1;
            }
            NinteichosahyoTokkijiko ninteichosahyoTokkijiko = new NinteichosahyoTokkijiko(
                    temp_申請書管理番号,
                    temp_認定調査履歴番号,
                    value.get特記事項番号(),
                    認定調査特記事項連番,
                    TokkijikoTextImageKubun.テキスト.getコード(),
                    GenponMaskKubun.原本.getCode());
            NinteichosahyoTokkijikoBuilder builder = ninteichosahyoTokkijiko.createBuilderForEdit();
            builder.set特記事項(value.get特記事項());
            dbt5205Manager.save認定調査票_特記情報(builder.build());
            前認定調査特記事項番号 = value.get特記事項番号();
        }
    }

    private void 認定調査依頼情報の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5201 == null) {
            dbt5201 = new NinteichosaIraiJoho(temp_申請書管理番号, temp_認定調査履歴番号);
        } else {
            dbt5201 = dbt5201.modifiedModel();
        }
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        if (NinteiChousaIraiKubunCode.再調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())) {
            dbt5201Bulid.set認定調査回数(dbt5201.get認定調査回数() + 1);
        } else {
            dbt5201Bulid.set認定調査回数(1);
        }
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 認定調査依頼情報の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosaIraiJohoManager dbt5201Manager = NinteichosaIraiJohoManager.createInstance();
        NinteichosaIraiJoho dbt5201 = dbt5201Manager.get認定調査依頼情報(temp_申請書管理番号, temp_認定調査履歴番号);
        dbt5201 = dbt5201.modifiedModel();
        NinteichosaIraiJohoBuilder dbt5201Bulid = dbt5201.createBuilderForEdit();
        dbt5201Bulid.set認定調査回数(dbt5201.get認定調査回数() - 1);
        dbt5201Manager.save認定調査依頼情報(dbt5201Bulid.build());
    }

    private void 概況調査の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        RString temp_認定調査依頼区分コード = ViewStateHolder.get(ViewStateKeys.認定調査依頼区分コード, RString.class);

        RString 概況調査テキストイメージ区分 = ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class);
        if (RString.isNullOrEmpty(概況調査テキストイメージ区分)) {
            概況調査テキストイメージ区分 = TokkijikoTextImageKubun.テキスト.getコード();
        }
        NinteichosahyoGaikyoChosaManager dbt5202Manager = InstanceProvider.create(NinteichosahyoGaikyoChosaManager.class);
        NinteichosahyoGaikyoChosa dbt5202 = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        if (dbt5202 == null) {
            dbt5202 = new NinteichosahyoGaikyoChosa(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        } else {
            dbt5202 = dbt5202.modifiedModel();
        }
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();

        RString 認定調査依頼区分コード;
        if (NinteiChousaIraiKubunCode.初回.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())) {
            認定調査依頼区分コード = NinteiChousaIraiKubunCode.初回.getコード();
        } else if (NinteiChousaIraiKubunCode.再調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())) {
            認定調査依頼区分コード = NinteiChousaIraiKubunCode.再調査.getコード();
        } else {
            認定調査依頼区分コード = NinteiChousaIraiKubunCode.再依頼.getコード();
        }

        RString サービス区分コード = div.getRadGenzaiservis().getSelectedKey();
        if (予防給付サービス_選択.equals(サービス区分コード)) {
            サービス区分コード = ServiceKubunCode.予防給付サービス.getコード();
        } else if (介護給付サービス_選択.equals(サービス区分コード)) {
            サービス区分コード = ServiceKubunCode.介護給付サービス.getコード();
        } else {
            サービス区分コード = ServiceKubunCode.なし.getコード();
        }

        dbt5202builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5202builder.set認定調査依頼区分コード(new Code(temp_認定調査依頼区分コード));
        if (NinteiChousaIraiKubunCode.再調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue())) {
            dbt5202builder.set認定調査回数(dbt5202.get認定調査回数() + 1);
        } else {
            dbt5202builder.set認定調査回数(1);
        }
        dbt5202builder.set認定調査実施年月日(new FlexibleDate(div.getCcdChosaJisshishaJoho().getTxtChosaJisshiDate().getValue().toDateString()));
        if (!EntityDataState.Modified.equals(dbt5202builder.getEntityDataState())) {
            dbt5202builder.set認定調査受領年月日(FlexibleDate.getNowDate());
        }
        dbt5202builder.set認定調査区分コード(new Code(認定調査依頼区分コード));
        dbt5202builder.set認定調査委託先コード(new JigyoshaNo(div.getCcdChosaJisshishaJoho().getTxtShozokuKikanCode().getText()));
        dbt5202builder.set認定調査員コード(div.getCcdChosaJisshishaJoho().getTxtKinyushaCode().getText());
        dbt5202builder.set認定調査実施場所コード(new Code(div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey()));
        if (div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho() != null) {
            dbt5202builder.set認定調査実施場所名称(div.getCcdChosaJisshishaJoho().getTxtJisshiBashoMeisho().getValue());
        }
        dbt5202builder.set認定調査_サービス区分コード(new Code(サービス区分コード));
        dbt5202builder.set利用施設名(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue());
        dbt5202builder.set利用施設住所(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain());
        dbt5202builder.set利用施設電話番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain());
        dbt5202builder.set利用施設郵便番号(div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue());
        dbt5202builder.set特記(div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        dbt5202builder.set認定調査特記事項受付年月日(new FlexibleDate(RString.EMPTY));
        dbt5202builder.set認定調査特記事項受領年月日(new FlexibleDate(RString.EMPTY));

        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void 概況調査の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString 概況調査テキストイメージ区分 = ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class);
        NinteichosahyoGaikyoChosaManager dbt5202Manager = InstanceProvider.create(NinteichosahyoGaikyoChosaManager.class);
        NinteichosahyoGaikyoChosa dbt5202 = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        dbt5202 = dbt5202.deleted();
        NinteichosahyoGaikyoChosaBuilder dbt5202builder = dbt5202.createBuilderForEdit();
        dbt5202Manager.save認定調査票_概況調査_子(dbt5202builder.build());
    }

    private void サービス状況フラグの更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);
        RString 住宅改修 = div.getRadJutakuKaishu().getSelectedKey();

        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = InstanceProvider.create(NinteichosahyoServiceJokyoFlagManager.class);
        NinteichosahyoServiceJokyoFlag dbt5208 = dbt5208Manager.
                get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        if (dbt5208 == null) {
            dbt5208 = new NinteichosahyoServiceJokyoFlag(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        } else {
            dbt5208 = dbt5208.modifiedModel();
        }
        NinteichosahyoServiceJokyoFlagBuilder dbt5208Builder = dbt5208.createBuilderForEdit();
        dbt5208Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        if (is住宅改修あり(住宅改修)) {
            dbt5208Builder.setサービスの状況フラグ(Boolean.TRUE);
        } else {
            dbt5208Builder.setサービスの状況フラグ(Boolean.FALSE);
        }
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5208Builder.build());
    }

    private void サービス状況フラグの削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        NinteichosahyoServiceJokyoFlagManager dbt5208Manager = InstanceProvider.create(NinteichosahyoServiceJokyoFlagManager.class);
        NinteichosahyoServiceJokyoFlag dbt5208 = dbt5208Manager.
                get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        dbt5208 = dbt5208.deleted();
        NinteichosahyoServiceJokyoFlagBuilder dbt5208Builder = dbt5208.createBuilderForEdit();
        dbt5208Manager.save認定調査票_概況調査_サービスの状況フラグ(dbt5208Builder.build());
    }

    private boolean is住宅改修あり(RString 住宅改修) {
        if (住宅改修_有.equals(住宅改修)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private void 記入項目の更新() {
        saveサービス状況記入項目(市町村特別給付_連番);
        saveサービス状況記入項目(介護保険給付外の在宅サービス_連番);
    }

    private void 記入項目の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoKinyuItemManager dbt5209Manager = InstanceProvider.create(NinteichosahyoKinyuItemManager.class);
        List<NinteichosahyoKinyuItem> dbt5209List = dbt5209Manager.get認定調査票_概況調査_記入項目List(temp_申請書管理番号, temp_認定調査履歴番号);
        for (NinteichosahyoKinyuItem 認定調査票記入項目 : dbt5209List) {
            NinteichosahyoKinyuItem dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 認定調査票記入項目.get連番());
            dbt5209 = dbt5209.deleted();
            NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
            dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
        }
    }

    private void saveサービス状況記入項目(int 記入項目種類連番) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        NinteichosahyoKinyuItemManager dbt5209Manager = InstanceProvider.create(NinteichosahyoKinyuItemManager.class);
        NinteichosahyoKinyuItem dbt5209 = dbt5209Manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 記入項目種類連番);
        RString サービス状況;
        if (市町村特別給付_連番 == 記入項目種類連番) {
            サービス状況 = div.getTxtShichosonTokubetsuKyufu().getValue();
        } else {
            サービス状況 = div.getTxtKyufuIgaiJutakuService().getValue();
        }
        if (dbt5209 == null) {
            dbt5209 = new NinteichosahyoKinyuItem(temp_申請書管理番号, temp_認定調査履歴番号, 記入項目種類連番);
        } else {
            dbt5209 = dbt5209.modifiedModel();
        }
        NinteichosahyoKinyuItemBuilder dbt5209Builder = dbt5209.createBuilderForEdit();
        dbt5209Builder.setサービスの状況記入(サービス状況);
        dbt5209Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        dbt5209Manager.save認定調査票_概況調査_記入項目(dbt5209Builder.build());
    }

    private void 施設利用の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = InstanceProvider.create(NinteichosahyoShisetsuRiyoManager.class);
        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        if (shisetsuList.isEmpty()) {
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(
                    temp_申請書管理番号, temp_認定調査履歴番号, GaikyoChosahyouNiteichosahyouSisetuRiy09B.居宅.get連番AsInt());
            if (dbt5210 == null) {
                for (GaikyoChosahyouNiteichosahyouSisetuRiy09B 概況調査利用施設 : GaikyoChosahyouNiteichosahyouSisetuRiy09B.values()) {
                    dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査利用施設.get連番AsInt());
                    NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
                    dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
                    dbt5210Builder.set施設利用フラグ(false);
                    dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
                }
            }
        }
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(
                    temp_申請書管理番号, temp_認定調査履歴番号, row.getRemban().getValue().intValue());
            if (dbt5210 == null) {
                dbt5210 = new NinteichosahyoShisetsuRiyo(temp_申請書管理番号, temp_認定調査履歴番号, row.getRemban().getValue().intValue());
            } else {
                dbt5210 = dbt5210.modifiedModel();
            }
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5210Builder.set施設利用フラグ(row.getShisetsuRiyoUmu());
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 施設利用の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoShisetsuRiyoManager dbt5210Manager = InstanceProvider.create(NinteichosahyoShisetsuRiyoManager.class);
        List<NinteichosahyoShisetsuRiyo> dbt5210List = dbt5210Manager.get連番除外の認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号).records();
        for (NinteichosahyoShisetsuRiyo 認定調査票施設利用 : dbt5210List) {
            NinteichosahyoShisetsuRiyo dbt5210 = dbt5210Manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 認定調査票施設利用.get連番());
            dbt5210 = dbt5210.deleted();
            NinteichosahyoShisetsuRiyoBuilder dbt5210Builder = dbt5210.createBuilderForEdit();
            dbt5210Manager.save認定調査票_概況調査_施設利用(dbt5210Builder.build());
        }
    }

    private void 調査項目の更新(boolean isDelete) {
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第一群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第二群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第三群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第四群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第五群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査群更新(ViewStateHolder.get(ViewStateKeys.第六群認定調査基本情報リスト, ArrayList.class), isDelete);
        基本調査第7群更新(ViewStateHolder.get(ViewStateKeys.第七群認定調査基本情報リスト, ArrayList.class), isDelete);
    }

    private void 基本調査群更新(ArrayList<KihonChosaInput> 基本調査群List, boolean isDelete) {
        if (基本調査群List == null || 基本調査群List.isEmpty()) {
            return;
        }
        for (KihonChosaInput 基本情報 : 基本調査群List) {
            if (isDelete) {
                調査項目の削除(基本情報.get調査連番());
            } else {
                調査項目の保存(基本情報.get調査連番(), 基本情報.get調査項目());
            }
        }
    }

    private void 調査項目の保存(int 連番, RString 調査項目) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoChosaItemManager manager = InstanceProvider.create(NinteichosahyoChosaItemManager.class);
        NinteichosahyoChosaItem dbt5211 = manager.get認定調査票_基本調査_調査項目(temp_申請書管理番号, temp_認定調査履歴番号, 連番);

        if (dbt5211 == null) {
            dbt5211 = new NinteichosahyoChosaItem(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        } else {
            dbt5211 = dbt5211.modifiedModel();
        }
        NinteichosahyoChosaItemBuilder builder = dbt5211.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class)));
        builder.set調査項目(調査項目);
        manager.save認定調査票_基本調査_調査項目(builder.build());
    }

    private void 調査項目の削除(int 連番) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoChosaItemManager manager = InstanceProvider.create(NinteichosahyoChosaItemManager.class);
        NinteichosahyoChosaItem dbt5211 = manager.get認定調査票_基本調査_調査項目(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        dbt5211 = dbt5211.deleted();
        NinteichosahyoChosaItemBuilder builder = dbt5211.createBuilderForEdit();
        manager.save認定調査票_基本調査_調査項目(builder.build());
    }

    private void 基本調査第7群更新(ArrayList<KihonChosaInput> 基本調査群List, boolean isDelete) {
        if (基本調査群List == null || 基本調査群List.isEmpty()) {
            return;
        }
        if (isDelete) {
            認定調査票基本調査の削除();
        } else {
            認定調査票基本調査の更新(基本調査群List);
        }

    }

    private void 認定調査票基本調査の更新(ArrayList<KihonChosaInput> 基本調査群List) {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        NinteichosahyoKihonChosaManager manager = InstanceProvider.create(NinteichosahyoKihonChosaManager.class);

        Code 障害高齢者の日常生活自立度コード = 基本調査群List.get(0).get障害高齢者自立度();
        Code 認知症高齢者の日常生活自立度コード = 基本調査群List.get(1).get認知症高齢者自立度();

        NinteichosahyoKihonChosa dbt5203 = manager.get認定調査票_基本調査(temp_申請書管理番号, temp_認定調査履歴番号);
        if (dbt5203 == null) {
            dbt5203 = new NinteichosahyoKihonChosa(temp_申請書管理番号, temp_認定調査履歴番号);
        } else {
            dbt5203 = dbt5203.modifiedModel();
        }
        NinteichosahyoKihonChosaBuilder builder = dbt5203.createBuilderForEdit();
        builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
        builder.set認定調査_障害高齢者の日常生活自立度コード(障害高齢者の日常生活自立度コード);
        builder.set認定調査_認知症高齢者の日常生活自立度コード(認知症高齢者の日常生活自立度コード);
        manager.save認定調査票_基本調査(builder.build());
    }

    private void 認定調査票基本調査の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoKihonChosaManager manager = InstanceProvider.create(NinteichosahyoKihonChosaManager.class);
        NinteichosahyoKihonChosa dbt5203 = manager.get認定調査票_基本調査(temp_申請書管理番号, temp_認定調査履歴番号);
        dbt5203 = dbt5203.deleted();
        NinteichosahyoKihonChosaBuilder builder = dbt5203.createBuilderForEdit();
        manager.save認定調査票_基本調査(builder.build());
    }

    private EntityDataState getDbT5203EntityDataState(NinteichosahyoKihonChosa dbt5203,
            Code 障害高齢者の日常生活自立度コード, Code 認知症高齢者の日常生活自立度コード) {
        if (dbt5203.get認定調査_障害高齢者の日常生活自立度コード().equals(障害高齢者の日常生活自立度コード)
                && dbt5203.get認定調査_認知症高齢者の日常生活自立度コード().equals(認知症高齢者の日常生活自立度コード)) {
            return EntityDataState.Unchanged;
        } else {
            return EntityDataState.Modified;
        }
    }

    private void 給付サービス状況の更新() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(ViewStateKeys.厚労省IF識別コード, RString.class);

        NinteichosahyoServiceJokyoManager dbt5207Manager = InstanceProvider.create(NinteichosahyoServiceJokyoManager.class);
        List<dgRiyoServiceJyokyo_Row> 給付サービス利用状況レコードリスト = div.getDgRiyoServiceJyokyo().getDataSource();
        if (給付サービス利用状況レコードリスト == null) {
            return;
        }
        Decimal 利用状況;
        for (dgRiyoServiceJyokyo_Row 給付サービス利用状況レコード : 給付サービス利用状況レコードリスト) {
            利用状況 = 給付サービス利用状況レコード.getServiceJokyo().getValue();
            if (利用状況 == null || 利用状況.toString().isEmpty()) {
                利用状況 = Decimal.ZERO;
            }
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(
                    temp_申請書管理番号, temp_認定調査履歴番号, 給付サービス利用状況レコード.getRemban().getValue().intValue());
            if (dbt5207 == null) {
                dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 給付サービス利用状況レコード.getRemban().getValue().intValue());
            } else {
                dbt5207 = dbt5207.modifiedModel();
            }
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
            dbt5207Builder.setサービスの状況(利用状況.intValue());
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
        if (!介護給付サービス_選択.equals(div.getRadGenzaiservis().getSelectedKey())) {
            給付サービス状況の更新_介護給付サービス(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード, dbt5207Manager);
        }
    }

    private void 給付サービス状況の更新_介護給付サービス(ShinseishoKanriNo temp_申請書管理番号,
            int temp_認定調査履歴番号, RString temp_厚労省IF識別コード, NinteichosahyoServiceJokyoManager dbt5207Manager) {
        for (CKGaikyoChosahyouServiceJyouk09B 概況調査サービス状況 : CKGaikyoChosahyouServiceJyouk09B.values()) {
            if (介護給付サービス.equals(概況調査サービス状況.get給付区分())) {
                NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(
                        temp_申請書管理番号, temp_認定調査履歴番号, 概況調査サービス状況.get連番AsInt());
                if (dbt5207 == null) {
                    dbt5207 = new NinteichosahyoServiceJokyo(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査サービス状況.get連番AsInt());
                } else {
                    dbt5207 = dbt5207.modifiedModel();
                }
                NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
                dbt5207Builder.set厚労省IF識別コード(new Code(temp_厚労省IF識別コード));
                dbt5207Builder.setサービスの状況(Decimal.ZERO.intValue());
                dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
            }
        }
    }

    private void 給付サービス状況の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoServiceJokyoManager dbt5207Manager = InstanceProvider.create(NinteichosahyoServiceJokyoManager.class);
        List<NinteichosahyoServiceJokyo> dbt5207List = dbt5207Manager.selectサービスの状況(temp_申請書管理番号, temp_認定調査履歴番号).records();
        for (NinteichosahyoServiceJokyo 認定調査票サービス状況 : dbt5207List) {
            NinteichosahyoServiceJokyo dbt5207 = dbt5207Manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 認定調査票サービス状況.get連番());
            dbt5207 = dbt5207.deleted();
            NinteichosahyoServiceJokyoBuilder dbt5207Builder = dbt5207.createBuilderForEdit();
            dbt5207Manager.save認定調査票_概況調査_サービスの状況(dbt5207Builder.build());
        }
    }

    /**
     * 対象者一覧を更新します。また、一次判定結果にエラーが出なかったデータのみ、ViewState上のデータも合わせて更新します。
     *
     * @param kekkaList 一次判定処理結果List
     */
    public void updateGridAndViewStateData(List<IchijiHanteiShoriKekka> kekkaList) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        List<RString> shinseishoKanriNoList = new ArrayList<>();
        shinseishoKanriNoList.add(申請書管理番号.value());
        IChiJiPanTeiSyoRiParameter parameter = IChiJiPanTeiSyoRiParameter.
                createParameterOf一次判定完了処理(
                        ShoKisaiHokenshaNo.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        Decimal.ZERO,
                        RString.EMPTY,
                        shinseishoKanriNoList,
                        RString.EMPTY);
        IChiJiPanTeiSyoRiManager manager = IChiJiPanTeiSyoRiManager.createInstance();
        List<IchijiHanteiKekkaJoho> kekkaJohoList = manager.get一次判定結果情報_調査結果(parameter).records();
        Models<IchijiHanteiKekkaJohoIdentifier, IchijiHanteiKekkaJoho> models;
        if (!kekkaJohoList.isEmpty()) {
            models = Models.create(kekkaJohoList);
        } else {
            models = Models.create(new ArrayList<IchijiHanteiKekkaJoho>());
        }
        IchijiHanteiShoriKekka kekka = getKekka(kekkaList, 申請書管理番号);

        if (!kekka.isError()) {
            IchijiHanteiKekkaJoho joho = models.get(kekka.getHanteiKekka().identifier());
            if (joho == null) {
                models.add(get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka()));
            } else {
                joho = updateIchijiHanteiKekkaJoho(joho, get一次判定結果情報_仮一次判定区分編集(kekka.getHanteiKekka()));
                models.add(joho);
            }
        }

        List<IchijiHanteiKekkaJoho> torokuTaishoList = new ArrayList<>();
        torokuTaishoList.addAll(models.values());
        manager.save要介護認定一次判定結果情報List(torokuTaishoList);
    }

    private IchijiHanteiKekkaJoho get一次判定結果情報_仮一次判定区分編集(IchijiHanteiKekkaJoho ichijiHanteiKekkaJoho) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        DbT5105NinteiKanryoJohoDac dbt5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        DbT5105NinteiKanryoJohoEntity entity = dbt5105Dac.selectByShinseishoKanriNo(申請書管理番号);
        IchijiHanteiKekkaJohoBuilder builder = ichijiHanteiKekkaJoho.createBuilderForEdit();
        if (entity != null) {
            if (entity.getNinteichosaKanryoYMD() == null || entity.getIkenshoTorokuKanryoYMD() == null) {
                builder.set仮一次判定区分(Boolean.TRUE);
            } else {
                builder.set仮一次判定区分(Boolean.FALSE);
            }
        } else {
            builder.set仮一次判定区分(Boolean.TRUE);
        }
        return builder.build();
    }

    private IchijiHanteiKekkaJoho updateIchijiHanteiKekkaJoho(IchijiHanteiKekkaJoho original, IchijiHanteiKekkaJoho updateData) {

        IchijiHanteiKekkaJohoBuilder builder = original.createBuilderForEdit();
        builder.set仮一次判定区分(updateData.get仮一次判定区分());
        builder.set要介護認定一次判定年月日(new FlexibleDate(RDate.getNowDate().toDateString()));

        builder.set要介護認定一次判定結果コード(updateData.get要介護認定一次判定結果コード());
        builder.set要介護認定一次判定結果コード_認知症加算(updateData.get要介護認定一次判定結果コード_認知症加算());

        builder.set要介護認定等基準時間(updateData.get要介護認定等基準時間());
        builder.set要介護認定等基準時間_食事(updateData.get要介護認定等基準時間_食事());
        builder.set要介護認定等基準時間_排泄(updateData.get要介護認定等基準時間_排泄());
        builder.set要介護認定等基準時間_移動(updateData.get要介護認定等基準時間_移動());
        builder.set要介護認定等基準時間_清潔保持(updateData.get要介護認定等基準時間_清潔保持());
        builder.set要介護認定等基準時間_間接ケア(updateData.get要介護認定等基準時間_間接ケア());
        builder.set要介護認定等基準時間_BPSD関連(updateData.get要介護認定等基準時間_BPSD関連());
        builder.set要介護認定等基準時間_機能訓練(updateData.get要介護認定等基準時間_機能訓練());
        builder.set要介護認定等基準時間_医療関連(updateData.get要介護認定等基準時間_医療関連());
        builder.set要介護認定等基準時間_認知症加算(updateData.get要介護認定等基準時間_認知症加算());
        builder.set中間評価項目得点第1群(updateData.get中間評価項目得点第1群());
        builder.set中間評価項目得点第2群(updateData.get中間評価項目得点第2群());
        builder.set中間評価項目得点第3群(updateData.get中間評価項目得点第3群());
        builder.set中間評価項目得点第4群(updateData.get中間評価項目得点第4群());
        builder.set中間評価項目得点第5群(updateData.get中間評価項目得点第5群());
        builder.set中間評価項目得点第6群(updateData.get中間評価項目得点第6群());
        builder.set中間評価項目得点第7群(updateData.get中間評価項目得点第7群());

        builder.set要介護認定状態の安定性コード(updateData.get要介護認定状態の安定性コード());
        builder.set認知症自立度Ⅱ以上の蓋然性(updateData.get認知症自立度Ⅱ以上の蓋然性());
        builder.set認知機能及び状態安定性から推定される給付区分コード(updateData.get認知機能及び状態安定性から推定される給付区分コード());

        builder.set運動能力の低下していない認知症高齢者の指標コード(Code.EMPTY);
        builder.set日常生活自立度の組み合わせ_自立(0);
        builder.set日常生活自立度の組み合わせ_要支援(0);
        builder.set日常生活自立度の組み合わせ_要介護１(0);
        builder.set日常生活自立度の組み合わせ_要介護２(0);
        builder.set日常生活自立度の組み合わせ_要介護３(0);
        builder.set日常生活自立度の組み合わせ_要介護４(0);
        builder.set日常生活自立度の組み合わせ_要介護５(0);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価コード(Code.EMPTY);
        builder.set認知症高齢者の日常生活自立度の蓋然性評価(0);
        builder.set一次判定結果送付区分(RString.EMPTY);
        builder.set一次判定結果送付年月日(FlexibleDate.EMPTY);
        builder.setチャート(RString.EMPTY);
        builder.set状態像(RString.EMPTY);

        return builder.build();
    }

    private IchijiHanteiShoriKekka getKekka(List<IchijiHanteiShoriKekka> kekkaList, ShinseishoKanriNo shinseishoKanriNo) {
        for (IchijiHanteiShoriKekka kekka : kekkaList) {
            if (kekka.getShinseishoKanriNo().equals(shinseishoKanriNo)) {
                return kekka;
            }
        }
        return null;
    }

    private void 概況調査特記マスクの削除() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int 認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString 概況調査テキストイメージ区分 = ViewStateHolder.get(ViewStateKeys.概況調査テキスト_イメージ区分, RString.class);
        GaikyoChosaTokkiManager dbt5213Manager = InstanceProvider.create(GaikyoChosaTokkiManager.class);
        GaikyoChosaTokki dbt5213 = dbt5213Manager.get概況調査特記マスク(申請書管理番号, 認定調査履歴番号, 概況調査テキストイメージ区分);
        if (dbt5213 != null) {
            dbt5213 = dbt5213.deleted();
            GaikyoChosaTokkiBuilder dbt5213builder = dbt5213.createBuilderForEdit();
            dbt5213Manager.save概況調査特記(dbt5213builder.build());
        }
    }

    private void 特記事項の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        int temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        NinteichosahyoTokkijikoManager dbt5205Manager = InstanceProvider.create(NinteichosahyoTokkijikoManager.class);
        List<NinteichosahyoTokkijiko> dbt5205List = dbt5205Manager.get認定調査票_特記情報(temp_申請書管理番号, temp_認定調査履歴番号);
        for (NinteichosahyoTokkijiko 特記事項 : dbt5205List) {
            NinteichosahyoTokkijiko dbt5205 = dbt5205Manager.get認定調査票_特記情報ByKey(temp_申請書管理番号,
                    temp_認定調査履歴番号, 特記事項.get認定調査特記事項番号(), 特記事項.get認定調査特記事項連番(), 特記事項.get特記事項テキスト_イメージ区分(), 特記事項.get原本マスク区分());
            dbt5205 = dbt5205.deleted();
            NinteichosahyoTokkijikoBuilder dbt5205Builder = dbt5205.createBuilderForEdit();
            dbt5205Manager.save認定調査票_特記情報(dbt5205Builder.build());
        }
    }

    private void 一次判定結果情報の削除() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        IchijiHanteiKekkaJohoManager dbt5116Manager = InstanceProvider.create(IchijiHanteiKekkaJohoManager.class);
        IchijiHanteiKekkaJoho dbt5116 = dbt5116Manager.get要介護認定一次判定結果情報(申請書管理番号);
        if (dbt5116 != null) {
            dbt5116 = dbt5116.deleted();
            IchijiHanteiKekkaJohoBuilder dbt5116builder = dbt5116.createBuilderForEdit();
            dbt5116Manager.saveOrDeletePhysical要介護認定一次判定結果情報(dbt5116builder.build());
        }
    }

    private void 完了情報の削除() {
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        NinteiKanryoJohoManager dbt5105Manager = InstanceProvider.create(NinteiKanryoJohoManager.class);
        NinteiKanryoJoho dbt5105 = dbt5105Manager.get要介護認定完了情報(temp_申請書管理番号);
        dbt5105 = dbt5105.modifiedModel();
        NinteiKanryoJohoBuilder dbt5105Bulid = dbt5105.createBuilderForEdit();
        dbt5105Bulid.set認定調査完了年月日(null);
        dbt5105Manager.save要介護認定完了情報(dbt5105Bulid.build());
    }

    private void イメージ情報の削除() {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        ImageManager imageManager = InstanceProvider.create(ImageManager.class);
        Image イメージ情報 = imageManager.getイメージ情報(申請書管理番号);
        if (イメージ情報 != null) {
            ReadOnlySharedFileEntryDescriptor descriptor = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(
                    div.getCcdNinteiShinseishaKihonInfo().get証記載保険者番号().concat(div.getCcdNinteiShinseishaKihonInfo().get被保険者番号())),
                    イメージ情報.getイメージ共有ファイルID());
            RString localCopyPath = DBEImageUtil.copySharedFiles(descriptor.getSharedFileId(), descriptor.getSharedFileName().toRString());
            deleteImageFile(descriptor, localCopyPath);
        }
    }

    private void deleteImageFile(ReadOnlySharedFileEntryDescriptor descriptor, RString localCopyPath) {
        List<RString> gaikyoChosaImageList = ImageFileItem.getGaikyoChosaImageFileList_ALL();
        deleteAllSharedFileInEntry(descriptor, gaikyoChosaImageList, localCopyPath);

        List<RString> tokkiJikoImageList = ImageFileItem.getChosahyoTokkiImageFileList_ALL();
        deleteAllSharedFileInEntry(descriptor, tokkiJikoImageList, localCopyPath);

        List<RString> gaikyoTokkiImageList = ImageFileItem.getGaikyoTokkiImageFileList_ALL();
        deleteAllSharedFileInEntry(descriptor, gaikyoTokkiImageList, localCopyPath);
    }

    private void deleteAllSharedFileInEntry(ReadOnlySharedFileEntryDescriptor descriptor,
            List<RString> deleteTargetImageFileList,
            RString localCopyPath) {
        RString imageFilePath;
        for (RString deleteTargetImageFile : deleteTargetImageFileList) {
            imageFilePath = DBEImageUtil.getMaskOrOriginalImageFilePath(localCopyPath, deleteTargetImageFile);
            if (!RString.isNullOrEmpty(imageFilePath)) {
                SharedFile.deleteFileInEntry(descriptor, deleteTargetImageFile.concat(png拡張子).toString());
            }
        }
    }
}
