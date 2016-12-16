/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5520001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.rirekishusei.RirekiShuseiBusiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001.RirekiShuseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5520001.dgRirekiIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4201NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4201NinteichosaIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4202NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4202NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4301ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4301ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4302ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4302ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JidoWariateJyogaishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.KoikinaiTenkyoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 特殊修正画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
public class RirekiShuseiHandler {

    private final RirekiShuseiDiv div;

    private static final RString BTN_UPDATE = new RString("btnUpdate");
    private static final RString DATA_KU_BUN_1 = new RString("1");
    private static final RString DATA_KU_BUN_2 = new RString("2");
    private static final RString DATA_KU_BUN_3 = new RString("3");
    private static final RString DATA_KU_BUN_4 = new RString("4");
    private static final RString KU_BUN_直 = new RString("直");
    private static final RString KU_BUN_修 = new RString("修");
    private static final RString KU_BUN_削 = new RString("削");
    private static final RString KU_BUN_追 = new RString("追");
    private static final RString SHORI_TYPE_2 = new RString("2");
    private static final RString EDA_BAN_00 = new RString("00");
    private static final RString SAKUJO_KUBUN = new RString("0");
    private static final RString EDABAN_CODE = new RString("000");
    private static final int ZERO_17 = 17;
    private final RString 主治医意見書作成期限年月日;
    private final RString 調査依頼;
    private final RString 調査予定;
    private final RString 作成依頼;
    private final RString 登録予定;
    private final RString 判定予定;
    private final RString 割当予定;
    private final RString 審査会予定;
    private final RString 送信予定;

    /**
     * コンストラクタです。
     *
     * @param div 特殊修正のコントロールdiv
     */
    public RirekiShuseiHandler(RirekiShuseiDiv div) {
        this.div = div;
        RDate configDate = RDate.getNowDate();
        主治医意見書作成期限年月日 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数, configDate, SubGyomuCode.DBE認定支援);
        調査依頼 = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼予定年月日, configDate, SubGyomuCode.DBE認定支援);
        調査予定 = DbBusinessConfig.get(ConfigNameDBE.認定調査予定年月日, configDate, SubGyomuCode.DBE認定支援);
        作成依頼 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼予定年月日, configDate, SubGyomuCode.DBE認定支援);
        登録予定 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書登録予定年月日, configDate, SubGyomuCode.DBE認定支援);
        判定予定 = DbBusinessConfig.get(ConfigNameDBE.要介護認定一次判定予定年月日, configDate, SubGyomuCode.DBE認定支援);
        割当予定 = DbBusinessConfig.get(ConfigNameDBE.認定審査会割当予定年月日, configDate, SubGyomuCode.DBE認定支援);
        審査会予定 = DbBusinessConfig.get(ConfigNameDBE.認定審査会予定年月日, configDate, SubGyomuCode.DBE認定支援);
        送信予定 = DbBusinessConfig.get(ConfigNameDBE.センター送信予定年月日, configDate, SubGyomuCode.DBE認定支援);
    }

    /**
     * 画面初期化処理です。
     *
     * @param rstList 受給履歴情報
     * @param 介護導入形態 介護導入形態
     * @param key 前画面からのデータ
     */
    public void load(List<RirekiShuseiBusiness> rstList, RString 介護導入形態, TaishoshaKey key) {
        div.getCcdKaigoNinteiAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, key.get識別コード());
        div.getCcdKaigoNinteiAtenaInfo().setShoriType(SHORI_TYPE_2);
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        for (RirekiShuseiBusiness business : rstList) {
            if (business.get受給者台帳().is直近フラグ()) {
                div.getCcdKaigoNinteiShikakuInfo().initialize(rstList.get(0).get受給者台帳().get市町村コード().value(), key.get被保険者番号().value());
                break;
            }
        }
        div.setHdnSubGyomuCode(SubGyomuCode.DBD介護受給.value());
        setRowList(rstList);
    }

    /**
     * 選択されたグリッドの行によって、選択行のボタンの状態を変化させる。
     *
     * @param selRow 選択されたグリッドの行
     * @return 選択されたグリッドの行
     */
    public dgRirekiIchiran_Row setデータグリッド状態(dgRirekiIchiran_Row selRow) {
        for (dgRirekiIchiran_Row row : div.getDgRirekiIchiran().getDataSource()) {
            row.getShusei().setDisabled(true);
            row.getSakujo().setDisabled(true);
            row.getKaihuku().setDisabled(true);
        }
        if (KU_BUN_直.equals(selRow.getKubun())) {
            div.getBtnBeforeRirekiTsuika().setDisabled(false);
            div.getBtnAfterRirekiTsuika().setDisabled(true);
            selRow.getShusei().setDisabled(true);
            selRow.getSakujo().setDisabled(true);
            selRow.getKaihuku().setDisabled(true);
        } else if (KU_BUN_修.equals(selRow.getKubun())) {
            div.getBtnAfterRirekiTsuika().setDisabled(false);
            div.getBtnBeforeRirekiTsuika().setDisabled(false);
            selRow.getShusei().setDisabled(false);
            selRow.getSakujo().setDisabled(true);
            selRow.getKaihuku().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_UPDATE, false);
        } else if (KU_BUN_削.equals(selRow.getKubun())) {
            div.getBtnAfterRirekiTsuika().setDisabled(false);
            div.getBtnBeforeRirekiTsuika().setDisabled(false);
            selRow.getShusei().setDisabled(false);
            selRow.getSakujo().setDisabled(true);
            selRow.getKaihuku().setDisabled(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_UPDATE, false);
        } else {
            div.getBtnAfterRirekiTsuika().setDisabled(false);
            div.getBtnBeforeRirekiTsuika().setDisabled(false);
            selRow.getShusei().setDisabled(false);
            selRow.getSakujo().setDisabled(false);
            selRow.getKaihuku().setDisabled(true);
            if (!RString.isNullOrEmpty(selRow.getKubun())) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_UPDATE, false);
            }
        }
        return selRow;
    }

    /**
     * 共有子Divで入力した履歴情報を画面で受け取る。
     *
     * @param business 履歴情報
     * @return グリッドの新規行
     */
    public dgRirekiIchiran_Row getRowByDialog(RirekiShuseiDataPass business) {
        dgRirekiIchiran_Row row = new dgRirekiIchiran_Row();
        row.getShusei().setDisabled(true);
        row.getSakujo().setDisabled(true);
        row.getKaihuku().setDisabled(true);
        row.setKubun(KU_BUN_追);
        if (business.getデータ区分() != null && !business.getデータ区分().isEmpty()) {
            row.setNinteiNaiyo(Datakubun.toValue(business.getデータ区分().value()).get名称());
            row.setDataKubun(business.getデータ区分().value());
        }
        row.getNiteiDay().setValue(business.get認定年月日());
        set要介護認定状態区分コード(row, business.get厚労省IF識別コード(), business.get要介護状態区分コード());
        row.getYukoKaishi().setValue(business.get認定有効開始年月日());
        row.getYukoShuryo().setValue(business.get認定有効終了年月日());
        row.setKyusochi(business.is旧措置フラグ());
        row.setShinsakaiIken(business.get介護認定審査会意見());
        row.setShinseishoKanriNo(business.get申請書管理番号().value());
        row.setDataPass(DataPassingConverter.serialize(business));
        return row;
    }

    /**
     * 共有子Divで入力した履歴情報を画面で受け取る。
     *
     * @param business 履歴情報
     * @param row 選択行
     * @return グリッドの新規行
     */
    public dgRirekiIchiran_Row setRowByDialog(RirekiShuseiDataPass business, dgRirekiIchiran_Row row) {
        if (business.getデータ区分() != null && !business.getデータ区分().isEmpty()) {
            row.setNinteiNaiyo(Datakubun.toValue(business.getデータ区分().value()).get名称());
            row.setDataKubun(business.getデータ区分().value());
        }
        row.getNiteiDay().setValue(business.get認定年月日());
        set要介護認定状態区分コード(row, business.get厚労省IF識別コード(), business.get要介護状態区分コード());
        row.getYukoKaishi().setValue(business.get認定有効開始年月日());
        row.getYukoShuryo().setValue(business.get認定有効終了年月日());
        row.setKyusochi(business.is旧措置フラグ());
        row.setShinsakaiIken(business.get介護認定審査会意見());
        row.setShinseishoKanriNo(business.get申請書管理番号().value());
        row.setDataPass(DataPassingConverter.serialize(business));
        return row;
    }

    /**
     * 次回行の取得します
     *
     * @param rowId 選択行
     * @return 次回行
     */
    public dgRirekiIchiran_Row getNextRow(int rowId) {
        for (int i = rowId + 1; i < div.getDgRirekiIchiran().getDataSource().size(); i++) {
            dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getDataSource().get(i);
            if (!KU_BUN_削.equals(row.getKubun())) {
                return row;
            }
        }
        return null;
    }

    /**
     * 前回行の取得します
     *
     * @param rowId 選択行
     * @return 前回行
     */
    public dgRirekiIchiran_Row getPreviousRow(int rowId) {
        for (int i = rowId - 1; i >= 0; i--) {
            dgRirekiIchiran_Row row = div.getDgRirekiIchiran().getDataSource().get(i);
            if (!KU_BUN_削.equals(row.getKubun())) {
                return row;
            }
        }
        return null;
    }

    /**
     * 受給者台帳の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 受給者台帳
     */
    public JukyushaDaicho set受給者台帳For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        JukyushaDaicho 受給者台帳 = new JukyushaDaicho(new LasdecCode(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode()),
                new HihokenshaNo(div.getCcdKaigoNinteiShikakuInfo().getTxtHihokenshaNo().getValue()),
                row.getRirekiNo(), EDA_BAN_00, new Code(JukyuShinseiJiyu.追加_申請なしの追加.getコード()));
        RirekiShuseiDataPass business
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        JukyushaDaichoBuilder 受給者台帳Builder = 受給者台帳.createBuilderForEdit();
        受給者台帳Builder.set申請書管理番号(申請書管理番号);
        受給者台帳Builder.set申請状況区分(ShinseiJokyoKubun.認定完了.getコード());
        受給者台帳Builder.set支所コード(business.get支所コード());
        受給者台帳Builder.set直近フラグ(false);
        受給者台帳Builder.set識別コード(new ShikibetsuCode(
                ObjectUtil.defaultIfNull(div.getCcdKaigoNinteiAtenaInfo().get識別コード(), RString.EMPTY)));
        受給者台帳Builder.set申請理由(ObjectUtil.defaultIfNull(business.get認定申請理由(), RString.EMPTY));
        受給者台帳Builder.set届出者_申請者関係コード(new Code(ObjectUtil.defaultIfNull(business.get事業者区分(), RString.EMPTY)));
        受給者台帳Builder.set届出者_本人との関係(ObjectUtil.defaultIfNull(business.get本人との関係性(), RString.EMPTY));
        受給者台帳Builder.set受給申請年月日(ObjectUtil.defaultIfNull(business.get認定申請年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set２号特定疾病コード(business.get二号特定疾病コード());
        受給者台帳Builder.set要介護認定状態区分コード(business.get要介護状態区分コード());
        受給者台帳Builder.set認定有効期間開始年月日(ObjectUtil.defaultIfNull(new FlexibleDate(business.get認定有効開始年月日().toDateString()), FlexibleDate.EMPTY));
        受給者台帳Builder.set認定有効期間終了年月日(ObjectUtil.defaultIfNull(new FlexibleDate(business.get認定有効終了年月日().toDateString()), FlexibleDate.EMPTY));
        受給者台帳Builder.set認定年月日(ObjectUtil.defaultIfNull(new FlexibleDate(business.get認定年月日().toDateString()), FlexibleDate.EMPTY));
        受給者台帳Builder.setみなし要介護区分コード(business.getみなし要介護区分コード());
        set指定サービス種類(business, 受給者台帳Builder);
        受給者台帳Builder.set喪失年月日(ObjectUtil.defaultIfNull(business.get喪失年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set直近異動年月日(FlexibleDate.getNowDate());
        受給者台帳Builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.履歴修正.getコード()));
        if (business.getデータ区分() != null && !business.getデータ区分().isEmpty()
                && business.getデータ区分().value().startsWith(DATA_KU_BUN_2)) {
            受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
        } else {
            受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
        }
        受給者台帳Builder.setデータ区分(business.getデータ区分());
        受給者台帳Builder.set同一連番(row.getRirekiNo());
        受給者台帳Builder.set異動理由(ObjectUtil.defaultIfNull(business.get異動理由(), RString.EMPTY));
        受給者台帳Builder.set申請書区分(new Code(business.get要介護申請_要支援申請の区分()));
        受給者台帳Builder.set削除事由コード(business.get削除事由コード());
        受給者台帳Builder.set当初認定有効開始年月日(ObjectUtil.defaultIfNull(business.get当初認定有効開始年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set当初認定有効終了年月日(ObjectUtil.defaultIfNull(business.get当初認定有効終了年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set受給資格証明書発行年月日１(ObjectUtil.defaultIfNull(business.get受給資格証明書発行年月日１(), FlexibleDate.EMPTY));
        受給者台帳Builder.set受給資格証明書発行年月日２(ObjectUtil.defaultIfNull(business.get受給資格証明書発行年月日２(), FlexibleDate.EMPTY));
        受給者台帳Builder.set旧措置者フラグ(business.is旧措置フラグ());
        if (row.getTsuikaKubun().isValue()) {
            受給者台帳Builder.set論理削除フラグ(true);
        } else {
            受給者台帳Builder.set論理削除フラグ(false);
        }
        return 受給者台帳Builder.build();
    }

    /**
     * 受給者台帳の削除回復処理
     *
     * @param row 画面のレコード
     * @return 受給者台帳
     */
    public JukyushaDaicho set受給者台帳For削除回復(dgRirekiIchiran_Row row) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        JukyushaDaichoBuilder 受給者台帳Builder = business.get受給者台帳().createBuilderForEdit();
        受給者台帳Builder.set直近異動年月日(FlexibleDate.getNowDate());
        受給者台帳Builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.履歴修正.getコード()));
        if (EDA_BAN_00.equals(row.getDataKubun()) || row.getDataKubun().startsWith(DATA_KU_BUN_2)) {
            受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
        } else {
            受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
        }
        受給者台帳Builder.set削除事由コード(Code.EMPTY);
        受給者台帳Builder.set論理削除フラグ(false);
        return 受給者台帳Builder.build().modifiedModel();
    }

    /**
     * 受給者台帳の履歴削除処理
     *
     * @param row 画面のレコード
     * @return 受給者台帳
     */
    public JukyushaDaicho set受給者台帳For履歴削除(dgRirekiIchiran_Row row) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        JukyushaDaichoBuilder 受給者台帳Builder = business.get受給者台帳().createBuilderForEdit();
        受給者台帳Builder.set直近異動年月日(FlexibleDate.getNowDate());
        受給者台帳Builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.履歴修正.getコード()));
        受給者台帳Builder.set削除事由コード(Code.EMPTY);
        受給者台帳Builder.set論理削除フラグ(true);
        return 受給者台帳Builder.build().modifiedModel();
    }

    /**
     * 受給者台帳の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 受給者台帳
     */
    public JukyushaDaicho set受給者台帳For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        JukyushaDaichoBuilder 受給者台帳Builder = business.get受給者台帳().createBuilderForEdit();
        if (dataPass.get削除事由コード() != null && !dataPass.get削除事由コード().isEmpty()) {
            受給者台帳Builder.set削除事由コード(dataPass.get削除事由コード());
            受給者台帳Builder.set論理削除フラグ(true);
        } else {
            受給者台帳Builder.set申請理由(ObjectUtil.defaultIfNull(dataPass.get認定申請理由(), RString.EMPTY));
            受給者台帳Builder.set届出者_申請者関係コード(new Code(dataPass.get事業者区分()));
            受給者台帳Builder.set届出者_本人との関係(ObjectUtil.defaultIfNull(dataPass.get本人との関係性(), RString.EMPTY));
            受給者台帳Builder.set受給申請年月日(ObjectUtil.defaultIfNull(dataPass.get認定申請年月日(), FlexibleDate.EMPTY));
            if (row.getDataKubun().startsWith(DATA_KU_BUN_1)) {
                受給者台帳Builder.set認定年月日(ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get認定年月日().toDateString()), FlexibleDate.EMPTY));
                set指定サービス種類(dataPass, 受給者台帳Builder);
                受給者台帳Builder.set喪失年月日(ObjectUtil.defaultIfNull(dataPass.get喪失年月日(), FlexibleDate.EMPTY));
                set有効無効区分(受給者台帳Builder, business, dataPass, true);
            } else if (row.getDataKubun().startsWith(DATA_KU_BUN_2)) {
                set有効無効区分(受給者台帳Builder, business, dataPass, false);
                受給者台帳Builder.set認定有効期間開始年月日(ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get認定有効開始年月日().toDateString()), FlexibleDate.EMPTY));
                受給者台帳Builder.set認定有効期間終了年月日(ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get認定有効終了年月日().toDateString()), FlexibleDate.EMPTY));
                受給者台帳Builder.set認定年月日(ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get認定年月日().toDateString()), FlexibleDate.EMPTY));
                set指定サービス種類(dataPass, 受給者台帳Builder);
            } else if (row.getDataKubun().startsWith(DATA_KU_BUN_3)) {
                受給者台帳Builder.set認定年月日(ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get認定年月日().toDateString()), FlexibleDate.EMPTY));
                set指定サービス種類(dataPass, 受給者台帳Builder);
                set有効無効区分(受給者台帳Builder, business, dataPass, true);
            } else if (row.getDataKubun().startsWith(DATA_KU_BUN_4)) {
                set有効無効区分(受給者台帳Builder, business, dataPass, true);
            }
            受給者台帳Builder.setデータ区分(dataPass.getデータ区分());
            受給者台帳Builder.set異動理由(ObjectUtil.defaultIfNull(dataPass.get異動理由(), RString.EMPTY));
            受給者台帳Builder.set申請書区分(new Code(dataPass.get要介護申請_要支援申請の区分()));
            受給者台帳Builder.set旧措置者フラグ(dataPass.is旧措置フラグ());
            受給者台帳Builder.set資格取得前申請フラグ(dataPass.is資格取得前申請フラグ());
        }

        受給者台帳Builder.set直近異動年月日(FlexibleDate.getNowDate());
        受給者台帳Builder.set直近異動事由コード(new Code(ChokkinIdoJiyuCode.履歴修正.getコード()));
        受給者台帳Builder.set当初認定有効開始年月日(ObjectUtil.defaultIfNull(dataPass.get当初認定有効開始年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set当初認定有効終了年月日(ObjectUtil.defaultIfNull(dataPass.get当初認定有効終了年月日(), FlexibleDate.EMPTY));
        受給者台帳Builder.set受給資格証明書発行年月日１(ObjectUtil.defaultIfNull(dataPass.get受給資格証明書発行年月日１(), FlexibleDate.EMPTY));
        受給者台帳Builder.set受給資格証明書発行年月日２(ObjectUtil.defaultIfNull(dataPass.get受給資格証明書発行年月日２(), FlexibleDate.EMPTY));
        return 受給者台帳Builder.build().modifiedModel();
    }

    private void set有効無効区分(JukyushaDaichoBuilder 受給者台帳Builder, RirekiShuseiBusiness business, RirekiShuseiDataPass dataPass, boolean flag) {
        if (flag) {
            受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
        } else {
            受給者台帳Builder.set要介護認定状態区分コード(dataPass.get要介護状態区分コード());
            受給者台帳Builder.setみなし要介護区分コード(dataPass.getみなし要介護区分コード());
            if (YokaigoJotaiKubun.非該当.getコード().equals(business.get受給者台帳().get要介護認定状態区分コード().value())
                    && !business.get受給者台帳().is旧措置者フラグ()) {
                受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            } else {
                受給者台帳Builder.set有効無効区分(new Code(YukoMukoKubun.有効.getコード()));
            }
        }
    }

    private void set指定サービス種類(RirekiShuseiDataPass dataPass, JukyushaDaichoBuilder 受給者台帳Builder) {
        受給者台帳Builder.set指定サービス種類01(dataPass.get指定サービス種類01());
        受給者台帳Builder.set指定サービス種類02(dataPass.get指定サービス種類02());
        受給者台帳Builder.set指定サービス種類03(dataPass.get指定サービス種類03());
        受給者台帳Builder.set指定サービス種類04(dataPass.get指定サービス種類04());
        受給者台帳Builder.set指定サービス種類05(dataPass.get指定サービス種類05());
        受給者台帳Builder.set指定サービス種類06(dataPass.get指定サービス種類06());
        受給者台帳Builder.set指定サービス種類07(dataPass.get指定サービス種類07());
        受給者台帳Builder.set指定サービス種類08(dataPass.get指定サービス種類08());
        受給者台帳Builder.set指定サービス種類09(dataPass.get指定サービス種類09());
        受給者台帳Builder.set指定サービス種類10(dataPass.get指定サービス種類10());
        受給者台帳Builder.set指定サービス種類11(dataPass.get指定サービス種類11());
        受給者台帳Builder.set指定サービス種類12(dataPass.get指定サービス種類12());
        受給者台帳Builder.set指定サービス種類13(dataPass.get指定サービス種類13());
        受給者台帳Builder.set指定サービス種類14(dataPass.get指定サービス種類14());
        受給者台帳Builder.set指定サービス種類15(dataPass.get指定サービス種類15());
        受給者台帳Builder.set指定サービス種類16(dataPass.get指定サービス種類16());
        受給者台帳Builder.set指定サービス種類17(dataPass.get指定サービス種類17());
        受給者台帳Builder.set指定サービス種類18(dataPass.get指定サービス種類18());
        受給者台帳Builder.set指定サービス種類19(dataPass.get指定サービス種類19());
        受給者台帳Builder.set指定サービス種類20(dataPass.get指定サービス種類20());
        受給者台帳Builder.set指定サービス種類21(dataPass.get指定サービス種類21());
        受給者台帳Builder.set指定サービス種類22(dataPass.get指定サービス種類22());
        受給者台帳Builder.set指定サービス種類23(dataPass.get指定サービス種類23());
        受給者台帳Builder.set指定サービス種類24(dataPass.get指定サービス種類24());
        受給者台帳Builder.set指定サービス種類25(dataPass.get指定サービス種類25());
        受給者台帳Builder.set指定サービス種類26(dataPass.get指定サービス種類26());
        受給者台帳Builder.set指定サービス種類27(dataPass.get指定サービス種類27());
        受給者台帳Builder.set指定サービス種類28(dataPass.get指定サービス種類28());
        受給者台帳Builder.set指定サービス種類29(dataPass.get指定サービス種類29());
        受給者台帳Builder.set指定サービス種類30(dataPass.get指定サービス種類30());
    }

    private void setRowList(List<RirekiShuseiBusiness> rstList) {
        List<dgRirekiIchiran_Row> rowList = new ArrayList<>();
        for (RirekiShuseiBusiness business : rstList) {
            if (ShinseiJokyoKubun.申請中.getコード().equals(business.get受給者台帳().get申請状況区分())) {
                div.getDgRirekiIchiran().setDataSource(Collections.<dgRirekiIchiran_Row>emptyList());
                return;
            }
            dgRirekiIchiran_Row row = new dgRirekiIchiran_Row();
            row.getShusei().setDisabled(true);
            row.getSakujo().setDisabled(true);
            row.getKaihuku().setDisabled(true);
            row.setShinseishoKanriNo(business.get受給者台帳().get申請書管理番号().value());
            if (business.get受給者台帳().is論理削除フラグ()) {
                row.setKubun(KU_BUN_削);
                DbT4121ShinseiRirekiJoho 申請履歴情報 = new DbT4121ShinseiRirekiJoho(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                row.setShinseirirekiJoho(DataPassingConverter.serialize(申請履歴情報));
                row.setMaeGoKubun(SAKUJO_KUBUN);
            } else if (business.get受給者台帳().is直近フラグ()) {
                row.setKubun(KU_BUN_直);
                row.setShinseirirekiJoho(DataPassingConverter.serialize(business.get申請履歴情報()));
            } else {
                row.setShinseirirekiJoho(DataPassingConverter.serialize(business.get申請履歴情報()));
                row.setKubun(RString.EMPTY);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_UPDATE, false);
            }
            if (business.get受給者台帳().getデータ区分() != null && !business.get受給者台帳().getデータ区分().isEmpty()) {
                row.setNinteiNaiyo(Datakubun.toValue(business.get受給者台帳().getデータ区分().value()).get名称());
                row.setDataKubun(business.get受給者台帳().getデータ区分().value());
            }
            row.getNiteiDay().setValue(flexToRDate(business.get受給者台帳().get認定年月日()));
            set要介護認定状態区分コード(row, business.get要介護認定申請情報().get厚労省IF識別コード(), business.get受給者台帳().get要介護認定状態区分コード());
            row.getYukoKaishi().setValue(flexToRDate(business.get受給者台帳().get認定有効期間開始年月日()));
            row.getYukoShuryo().setValue(flexToRDate(business.get受給者台帳().get認定有効期間終了年月日()));
            row.setKyusochi(business.get受給者台帳().is旧措置者フラグ());
            row.setShinsakaiIken(business.get要介護認定結果情報().get介護認定審査会意見());
            row.setDeserializedBusiness(DataPassingConverter.serialize(business));
            row.getUpdateCount().setValue(new Decimal(business.getUpdateCount()));
            rowList.add(row);
        }
        div.getDgRirekiIchiran().setDataSource(rowList);
    }

    private RDate flexToRDate(FlexibleDate before) {
        if (before == null || before.isEmpty()) {
            return null;
        }
        return new RDate(before.wareki().toDateString().toString());
    }

    private FlexibleDate rDateTOFlexDate(RDate fromDate) {
        if (fromDate != null) {
            return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
        }
        return FlexibleDate.EMPTY;
    }

    private void set要介護認定状態区分コード(dgRirekiIchiran_Row row, Code 厚労省IF識別コード, Code 要介護認定状態区分コード) {
        if (!(要介護認定状態区分コード != null && !要介護認定状態区分コード.isEmpty())) {
            return;
        }
        if (!(厚労省IF識別コード != null && 厚労省IF識別コード.isEmpty())) {
            return;
        }
        switch (KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード.value())) {
            case 認定ｿﾌﾄ2009:
            case 認定ｿﾌﾄ2009_SP3:
                row.setYokaigodo(YokaigoJotaiKubun09.toValue(要介護認定状態区分コード.value()).get名称());
                break;
            case 認定ｿﾌﾄ2002:
                row.setYokaigodo(YokaigoJotaiKubun02.toValue(要介護認定状態区分コード.value()).get名称());
                break;
            case 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用:
                row.setYokaigodo(YokaigoJotaiKubun06.toValue(要介護認定状態区分コード.value()).get名称());
                break;
            case 認定ｿﾌﾄ99:
                row.setYokaigodo(YokaigoJotaiKubun99.toValue(要介護認定状態区分コード.value()).get名称());
                break;
            default:
                break;
        }
    }

    /**
     * 認定申請の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 認定申請
     */
    public DbT4101NinteiShinseiJoho set認定申請For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        DbT4101NinteiShinseiJoho 認定申請 = new DbT4101NinteiShinseiJoho(申請書管理番号);
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4101NinteiShinseiJohoBuilder 認定申請Builder = 認定申請.createBuilderForEdit();
        認定申請Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        認定申請Builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        認定申請Builder.set申請年度(dataPass.get認定申請年月日().getNendo());
        認定申請Builder.set被保険者番号(div.getCcdKaigoNinteiShikakuInfo().getTxtHihokenshaNo().getValue());
        認定申請Builder.set認定申請年月日(ObjectUtil.defaultIfNull(dataPass.get認定申請年月日(), FlexibleDate.EMPTY));
        認定申請Builder.set認定申請枝番コード(new EdabanCode(EDABAN_CODE));
        認定申請Builder.set認定申請区分_法令_コード(dataPass.get認定申請区分_法令_コード());
        認定申請Builder.set認定申請区分_申請時_コード(dataPass.get認定申請区分_申請時_コード());
        認定申請Builder.set被保険者区分コード(dataPass.get被保険者区分コード());
        認定申請Builder.set生年月日(rDateTOFlexDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日()));
        if (!RString.isNullOrEmpty(div.getCcdKaigoNinteiAtenaInfo().get年齢())) {
            認定申請Builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        }
        if (!RString.isNullOrEmpty(div.getCcdKaigoNinteiAtenaInfo().get性別())) {
            認定申請Builder.set性別(new Code(Seibetsu.valueOf(div.getCcdKaigoNinteiAtenaInfo().get性別().toString()).getコード()));
        }
        if (div.getCcdKaigoNinteiAtenaInfo().get被保険者氏名カナ() == null) {
            認定申請Builder.set被保険者氏名カナ(AtenaKanaMeisho.EMPTY);
        } else {
            認定申請Builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoNinteiAtenaInfo().get被保険者氏名カナ()));
        }
        認定申請Builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoNinteiAtenaInfo().get被保険者氏名()));
        認定申請Builder.set郵便番号(div.getCcdKaigoNinteiAtenaInfo().get郵便番号());
        認定申請Builder.set住所(new AtenaJusho(div.getCcdKaigoNinteiAtenaInfo().get住所()));
        認定申請Builder.set電話番号(new TelNo(div.getCcdKaigoNinteiAtenaInfo().get電話番号()));
        認定申請Builder.set支所コード(ObjectUtil.defaultIfNull(dataPass.get支所コード(), RString.EMPTY));
        認定申請Builder.set識別コード(new ShikibetsuCode(div.getCcdKaigoNinteiAtenaInfo().get識別コード()));
        if (HihokenshaKubunCode.生活保護.getコード().equals(dataPass.get被保険者区分コード())) {
            認定申請Builder.setみなし２号等対象フラグ(true);
        } else {
            認定申請Builder.setみなし２号等対象フラグ(false);
        }
        認定申請Builder.set広域内転居区分(new Code(KoikinaiTenkyoKubun.対象外.getコード()));
        認定申請Builder.set認定申請有効区分(new Code(NinteiShinseiYukoKubunCode.有効.getコード()));
        認定申請Builder.set要介護申請_要支援申請の区分(ObjectUtil.defaultIfNull(dataPass.get要介護申請_要支援申請の区分(), RString.EMPTY));
        認定申請Builder.set認定申請理由(ObjectUtil.defaultIfNull(dataPass.get認定申請理由(), RString.EMPTY));
        認定申請Builder.set前回要介護状態区分コード(dataPass.get前回要介護状態区分コード());
        認定申請Builder.set前回認定年月日(ObjectUtil.defaultIfNull(dataPass.get前回認定年月日(), FlexibleDate.EMPTY));
        認定申請Builder.set前回認定有効期間_開始(ObjectUtil.defaultIfNull(dataPass.get前回認定有効開始年月日(), FlexibleDate.EMPTY));
        認定申請Builder.set前回認定有効期間_終了(ObjectUtil.defaultIfNull(dataPass.get前回認定有効終了年月日(), FlexibleDate.EMPTY));
        認定申請Builder.set2号特定疾病コード(dataPass.get二号特定疾病コード());
        認定申請Builder.set自動割当除外者区分(JidoWariateJyogaishaKubun.除外.getコード());
        認定申請Builder.set情報提供への同意有無(false);
        認定申請Builder.set認定調査委託先コード(new ChosaItakusakiCode(dataPass.get調査状況用情報().get認定調査委託先コード()));
        認定申請Builder.set認定調査員コード(new ChosainCode(dataPass.get調査状況用情報().get認定調査員コード()));
        認定申請Builder.set調査員への連絡事項(ObjectUtil.defaultIfNull(dataPass.get調査員への連絡事項(), RString.EMPTY));
        認定申請Builder.set主治医医療機関コード(
                ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get主治医医療機関コード(), RString.EMPTY));
        認定申請Builder.set主治医コード(ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get主治医コード(), RString.EMPTY));
        認定申請Builder.set指定医フラグ(dataPass.get調査状況用情報().is指定医フラグ());
        認定申請Builder.set主治医への連絡事項(ObjectUtil.defaultIfNull(dataPass.get主治医への連絡事項(), RString.EMPTY));
        認定申請Builder.set訪問調査先郵便番号(dataPass.get調査状況用情報().get訪問調査先郵便番号());
        認定申請Builder.set訪問調査先住所(dataPass.get調査状況用情報().get訪問調査先住所());
        認定申請Builder.set訪問調査先名称(dataPass.get調査状況用情報().get訪問調査先名称());
        認定申請Builder.set訪問調査先電話番号(dataPass.get調査状況用情報().get訪問調査先電話番号());
        if (dataPass.get取下年月日() != null && !dataPass.get取下年月日().isEmpty()) {
            認定申請Builder.set取下年月日(ObjectUtil.defaultIfNull(dataPass.get取下年月日(), FlexibleDate.EMPTY));
            認定申請Builder.set取下理由(ObjectUtil.defaultIfNull(dataPass.get異動理由(), RString.EMPTY));
        }
        if (dataPass.get喪失年月日() != null && !dataPass.get喪失年月日().isEmpty()) {
            認定申請Builder.set却下年月日(ObjectUtil.defaultIfNull(dataPass.get喪失年月日(), FlexibleDate.EMPTY));
            認定申請Builder.set却下理由(ObjectUtil.defaultIfNull(dataPass.get異動理由(), RString.EMPTY));
        }
        認定申請Builder.set延期通知発行年月日(new FlexibleDate(dataPass.get調査状況用情報().get延期通知発行年月日().toDateString()));
        認定申請Builder.set延期通知発行回数(dataPass.get調査状況用情報().get延期通知発行回数());
        認定申請Builder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        認定申請Builder.set論理削除フラグ(false);
        return 認定申請Builder.build();
    }

    /**
     * 認定申請の履歴削除処理
     *
     * @param row 画面のレコード
     * @return 認定申請
     */
    public DbT4101NinteiShinseiJoho set認定申請For履歴削除(dgRirekiIchiran_Row row) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4101NinteiShinseiJohoBuilder 認定申請Builder = business.get要介護認定申請情報().createBuilderForEdit();
        認定申請Builder.set論理削除フラグ(true);
        return 認定申請Builder.build().modifiedModel();
    }

    /**
     * 認定申請の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 認定申請
     */
    public DbT4101NinteiShinseiJoho set認定申請For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4101NinteiShinseiJohoBuilder 認定申請Builder = business.get要介護認定申請情報().createBuilderForEdit();
        if (!(dataPass.get削除事由コード() != null && !dataPass.get削除事由コード().isEmpty())) {
            if (row.getDataKubun().startsWith(DATA_KU_BUN_3)) {
                認定申請Builder.set却下年月日(ObjectUtil.defaultIfNull(dataPass.get喪失年月日(), FlexibleDate.EMPTY));
                認定申請Builder.set却下理由(ObjectUtil.defaultIfNull(dataPass.get異動理由(), RString.EMPTY));
            } else if (row.getDataKubun().startsWith(DATA_KU_BUN_4)) {
                認定申請Builder.set取下年月日(ObjectUtil.defaultIfNull(dataPass.get取下年月日(), FlexibleDate.EMPTY));
                認定申請Builder.set取下理由(ObjectUtil.defaultIfNull(dataPass.get異動理由(), RString.EMPTY));
            }
            認定申請Builder.set申請年度(dataPass.get認定申請年月日().getNendo());
            認定申請Builder.set認定申請年月日(ObjectUtil.defaultIfNull(dataPass.get認定申請年月日(), FlexibleDate.EMPTY));
            if (business.get要介護認定申請情報().get生年月日() != null && !business.get要介護認定申請情報().get生年月日().isEmpty()) {
                AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory
                        .createInstance(business.get要介護認定申請情報().get生年月日()), JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
                RString age = ageCalculator.get年齢();
                認定申請Builder.set年齢(Integer.parseInt(age.toString()));
            }
        }

        認定申請Builder.set認定申請区分_法令_コード(dataPass.get認定申請区分_法令_コード());
        認定申請Builder.set認定申請区分_申請時_コード(dataPass.get認定申請区分_申請時_コード());
        認定申請Builder.set要介護申請_要支援申請の区分(ObjectUtil.defaultIfNull(dataPass.get要介護申請_要支援申請の区分(), RString.EMPTY));
        認定申請Builder.set認定申請理由(ObjectUtil.defaultIfNull(dataPass.get認定申請理由(), RString.EMPTY));
        認定申請Builder.set認定調査委託先コード(new ChosaItakusakiCode(dataPass.get調査状況用情報().get認定調査委託先コード()));
        認定申請Builder.set認定調査員コード(new ChosainCode(dataPass.get調査状況用情報().get認定調査員コード()));
        認定申請Builder.set主治医医療機関コード(ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get主治医医療機関コード(), RString.EMPTY));
        認定申請Builder.set主治医コード(ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get主治医コード(), RString.EMPTY));
        認定申請Builder.set指定医フラグ(dataPass.get調査状況用情報().is指定医フラグ());
        認定申請Builder.set訪問調査先郵便番号(dataPass.get調査状況用情報().get訪問調査先郵便番号());
        認定申請Builder.set訪問調査先住所(dataPass.get調査状況用情報().get訪問調査先住所());
        認定申請Builder.set訪問調査先名称(dataPass.get調査状況用情報().get訪問調査先名称());
        認定申請Builder.set訪問調査先電話番号(dataPass.get調査状況用情報().get訪問調査先電話番号());
        認定申請Builder.set延期通知発行年月日(new FlexibleDate(dataPass.get調査状況用情報().get延期通知発行年月日().toDateString()));
        認定申請Builder.set延期通知発行回数(dataPass.get調査状況用情報().get延期通知発行回数());
        return 認定申請Builder.build().modifiedModel();
    }

    /**
     * 認定申請の削除回復処理
     *
     * @param row 画面のレコード
     * @param previousRow 選択行以前
     * @return 認定申請
     */
    public DbT4101NinteiShinseiJoho set認定申請For削除回復(dgRirekiIchiran_Row row, dgRirekiIchiran_Row previousRow) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4101NinteiShinseiJohoBuilder 認定申請Builder = business.get要介護認定申請情報().createBuilderForEdit();
        if (previousRow != null) {
            if (!RString.isNullOrEmpty(previousRow.getDataPass())) {
                RirekiShuseiDataPass previousBusiness
                        = DataPassingConverter.deserialize(previousRow.getDataPass(), RirekiShuseiDataPass.class);
                認定申請Builder.set前回要介護状態区分コード(
                        ObjectUtil.defaultIfNull(previousBusiness.get前回要介護状態区分コード(), Code.EMPTY));
                認定申請Builder.set前回認定年月日(
                        ObjectUtil.defaultIfNull(previousBusiness.get前回認定年月日(), FlexibleDate.EMPTY));
                認定申請Builder.set前回認定有効期間_開始(
                        ObjectUtil.defaultIfNull(previousBusiness.get前回認定有効開始年月日(), FlexibleDate.EMPTY));
                認定申請Builder.set前回認定有効期間_終了(
                        ObjectUtil.defaultIfNull(previousBusiness.get前回認定有効終了年月日(), FlexibleDate.EMPTY));
            } else {
                RirekiShuseiBusiness previousBusiness
                        = DataPassingConverter.deserialize(previousRow.getDeserializedBusiness(), RirekiShuseiBusiness.class);
                認定申請Builder.set前回要介護状態区分コード(
                        ObjectUtil.defaultIfNull(previousBusiness.get要介護認定申請情報().get前回要介護状態区分コード(), Code.EMPTY));
                認定申請Builder.set前回認定年月日(
                        ObjectUtil.defaultIfNull(previousBusiness.get要介護認定申請情報().get前回認定年月日(), FlexibleDate.EMPTY));
                認定申請Builder.set前回認定有効期間_開始(
                        ObjectUtil.defaultIfNull(previousBusiness.get要介護認定申請情報().get前回認定有効期間_開始(), FlexibleDate.EMPTY));
                認定申請Builder.set前回認定有効期間_終了(
                        ObjectUtil.defaultIfNull(previousBusiness.get要介護認定申請情報().get前回認定有効期間_終了(), FlexibleDate.EMPTY));
            }
        }
        認定申請Builder.set論理削除フラグ(false);
        return 認定申請Builder.build().modifiedModel();
    }

    /**
     * 認定申請の削除回復処理
     *
     * @param row 画面のレコード
     * @param nextRow 選択行以降
     * @return 認定申請
     */
    public DbT4101NinteiShinseiJoho set認定申請For削除回復次回行(dgRirekiIchiran_Row row, dgRirekiIchiran_Row nextRow) {
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        if (nextRow != null) {
            if (!RString.isNullOrEmpty(nextRow.getDataKubun()) && KU_BUN_直.equals(nextRow.getDataKubun())) {
                RirekiShuseiDataPass nextBusiness
                        = DataPassingConverter.deserialize(nextRow.getDataPass(), RirekiShuseiDataPass.class);
                nextBusiness.set前回要介護状態区分コード(
                        ObjectUtil.defaultIfNull(business.get受給者台帳().get要介護認定状態区分コード(), Code.EMPTY));
                nextBusiness.set前回認定年月日(
                        ObjectUtil.defaultIfNull(business.get受給者台帳().get認定年月日(), FlexibleDate.EMPTY));
                nextBusiness.set前回認定有効開始年月日(
                        ObjectUtil.defaultIfNull(business.get受給者台帳().get認定有効期間開始年月日(), FlexibleDate.EMPTY));
                nextBusiness.set前回認定有効終了年月日(
                        ObjectUtil.defaultIfNull(business.get受給者台帳().get認定有効期間終了年月日(), FlexibleDate.EMPTY));
                nextRow.setDataPass(DataPassingConverter.serialize(nextBusiness));
                return null;
            }
            RirekiShuseiBusiness nextBusiness
                    = DataPassingConverter.deserialize(nextRow.getDeserializedBusiness(), RirekiShuseiBusiness.class);
            DbT4101NinteiShinseiJohoBuilder 認定申請Builder = nextBusiness.get要介護認定申請情報().createBuilderForEdit();
            認定申請Builder.set前回要介護状態区分コード(
                    ObjectUtil.defaultIfNull(business.get受給者台帳().get要介護認定状態区分コード(), Code.EMPTY));
            認定申請Builder.set前回認定年月日(
                    ObjectUtil.defaultIfNull(business.get受給者台帳().get認定年月日(), FlexibleDate.EMPTY));
            認定申請Builder.set前回認定有効期間_開始(
                    ObjectUtil.defaultIfNull(business.get受給者台帳().get認定有効期間開始年月日(), FlexibleDate.EMPTY));
            認定申請Builder.set前回認定有効期間_終了(
                    ObjectUtil.defaultIfNull(business.get受給者台帳().get認定有効期間終了年月日(), FlexibleDate.EMPTY));
            return 認定申請Builder.build().modifiedModel();
        }
        return null;
    }

    /**
     * 調査依頼情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 調査依頼情報
     */
    public DbT4201NinteichosaIraiJoho set調査依頼情報For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4201NinteichosaIraiJoho 調査依頼情報 = new DbT4201NinteichosaIraiJoho(申請書管理番号, 1);
        DbT4201NinteichosaIraiJohoBuilder 調査依頼情報Builder = 調査依頼情報.createBuilderForEdit();
        調査依頼情報Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        調査依頼情報Builder.set認定調査委託先コード(new JigyoshaNo(dataPass.get調査状況用情報().get認定調査委託先コード()));
        調査依頼情報Builder.set認定調査員コード(ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get認定調査員コード(), RString.EMPTY));
        調査依頼情報Builder.set認定調査依頼区分コード(new Code(NinteiChousaIraiKubunCode.初回.getコード()));
        調査依頼情報Builder.set認定調査回数(1);
        調査依頼情報Builder.set認定調査依頼年月日(
                ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get調査状況用情報().get認定調査依頼年月日().toDateString()), FlexibleDate.EMPTY));
        RString 日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        調査依頼情報Builder.set認定調査期限年月日(new FlexibleDate(dataPass.get調査状況用情報().get認定調査依頼年月日().plusDay(Integer.parseInt(日数.toString())).toDateString()));
        調査依頼情報Builder.set論理削除フラグ(false);
        return 調査依頼情報Builder.build();
    }

    /**
     * 調査依頼情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 調査依頼情報
     */
    public DbT4201NinteichosaIraiJoho set調査依頼情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4201NinteichosaIraiJohoBuilder 調査依頼情報Builder = business.get認定調査依頼情報().createBuilderForEdit();
        調査依頼情報Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        調査依頼情報Builder.set認定調査委託先コード(new JigyoshaNo(dataPass.get調査状況用情報().get認定調査委託先コード()));
        調査依頼情報Builder.set認定調査員コード(
                ObjectUtil.defaultIfNull(dataPass.get調査状況用情報().get認定調査員コード(), RString.EMPTY));
        調査依頼情報Builder.set認定調査依頼年月日(
                ObjectUtil.defaultIfNull(new FlexibleDate(dataPass.get調査状況用情報().get認定調査依頼年月日().toDateString()), FlexibleDate.EMPTY));
        RString 日数 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        調査依頼情報Builder.set認定調査期限年月日(new FlexibleDate(dataPass.get調査状況用情報().get認定調査依頼年月日().plusDay(Integer.parseInt(日数.toString())).toDateString()));
        return 調査依頼情報Builder.build().modifiedModel();
    }

    /**
     * 認定調査票の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 認定調査票
     */
    public DbT4202NinteichosahyoGaikyoChosa set認定調査票For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4202NinteichosahyoGaikyoChosa 認定調査票 = new DbT4202NinteichosahyoGaikyoChosa(申請書管理番号, 1, new RString("1"));
        DbT4202NinteichosahyoGaikyoChosaBuilder 認定調査票Builder = 認定調査票.createBuilderForEdit();

        認定調査票Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        認定調査票Builder.set認定調査依頼区分コード(new Code(NinteiChousaIraiKubunCode.初回.getコード()));
        認定調査票Builder.set認定調査回数(1);
        認定調査票Builder.set認定調査実施年月日(new FlexibleDate(dataPass.get調査状況用情報().get認定調査実施年月日().toDateString()));
        認定調査票Builder.set認定調査受領年月日(FlexibleDate.EMPTY);
        認定調査票Builder.set認定調査区分コード(new Code(ChosaKubun.新規調査.getコード()));
        認定調査票Builder.set認定調査委託先コード(new JigyoshaNo(dataPass.get調査状況用情報().get認定調査委託先コード()));
        認定調査票Builder.set認定調査員コード(dataPass.get調査状況用情報().get認定調査員コード());
        認定調査票Builder.set認定調査実施場所コード(Code.EMPTY);
        認定調査票Builder.set認定調査_サービス区分コード(Code.EMPTY);
        認定調査票Builder.set特記(RString.EMPTY);
        return 認定調査票Builder.build();
    }

    /**
     * 認定調査票の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 認定調査票
     */
    public DbT4202NinteichosahyoGaikyoChosa set認定調査票For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4202NinteichosahyoGaikyoChosaBuilder 認定調査票Builder = business.get認定調査票_概況調査().createBuilderForEdit();
        認定調査票Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        認定調査票Builder.set認定調査実施年月日(new FlexibleDate(dataPass.get調査状況用情報().get認定調査実施年月日().toDateString()));
        認定調査票Builder.set認定調査委託先コード(new JigyoshaNo(dataPass.get調査状況用情報().get認定調査委託先コード()));
        認定調査票Builder.set認定調査員コード(dataPass.get調査状況用情報().get認定調査員コード());
        return 認定調査票Builder.build().modifiedModel();
    }

    /**
     * 主治医意見書作成依頼情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 主治医意見書作成依頼情報
     */
    public DbT4301ShujiiIkenshoIraiJoho set主治医意見書作成依頼情報For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4301ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 = new DbT4301ShujiiIkenshoIraiJoho(申請書管理番号, 1);
        DbT4301ShujiiIkenshoIraiJohoBuilder 主治医意見書作成依頼Builder = 主治医意見書作成依頼情報.createBuilderForEdit();
        主治医意見書作成依頼Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        主治医意見書作成依頼Builder.set主治医医療機関コード(dataPass.get調査状況用情報().get主治医医療機関コード());
        主治医意見書作成依頼Builder.set主治医コード(dataPass.get調査状況用情報().get主治医コード());
        主治医意見書作成依頼Builder.set主治医意見書依頼区分(IkenshoIraiKubun.初回依頼.getコード());
        主治医意見書作成依頼Builder.set主治医意見書作成回数(1);
        if (dataPass.get調査状況用情報().is指定医フラグ()) {
            主治医意見書作成依頼Builder.set医師区分コード(new Code(IshiKubunCode.指定医.getコード()));
        } else {
            主治医意見書作成依頼Builder.set医師区分コード(new Code(IshiKubunCode.主治医.getコード()));
        }
        主治医意見書作成依頼Builder.set主治医意見書作成依頼年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書作成依頼年月日().toDateString()));
        主治医意見書作成依頼Builder.set主治医意見書作成期限年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書作成依頼年月日().
                plusDay(Integer.parseInt(主治医意見書作成期限年月日.toString())).toDateString()));
        主治医意見書作成依頼Builder.set論理削除フラグ(false);
        return 主治医意見書作成依頼Builder.build();
    }

    /**
     * 主治医意見書作成依頼情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 主治医意見書作成依頼情報
     */
    public DbT4301ShujiiIkenshoIraiJoho set主治医意見書作成依頼情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4301ShujiiIkenshoIraiJohoBuilder 主治医意見書作成依頼Builder = business.get主治医意見書作成依頼情報().createBuilderForEdit();
        主治医意見書作成依頼Builder.set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード()));
        主治医意見書作成依頼Builder.set主治医医療機関コード(dataPass.get調査状況用情報().get主治医医療機関コード());
        主治医意見書作成依頼Builder.set主治医コード(dataPass.get調査状況用情報().get主治医コード());
        if (dataPass.get調査状況用情報().is指定医フラグ()) {
            主治医意見書作成依頼Builder.set医師区分コード(new Code(IshiKubunCode.指定医.getコード()));
        } else {
            主治医意見書作成依頼Builder.set医師区分コード(new Code(IshiKubunCode.主治医.getコード()));
        }
        主治医意見書作成依頼Builder.set主治医意見書作成依頼年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書作成依頼年月日().toDateString()));
        主治医意見書作成依頼Builder.set主治医意見書作成期限年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書作成依頼年月日().
                plusDay(Integer.parseInt(主治医意見書作成期限年月日.toString())).toDateString()));
        return 主治医意見書作成依頼Builder.build().modifiedModel();
    }

    /**
     * 主治医意見書情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 主治医意見書情報
     */
    public DbT4302ShujiiIkenshoJoho set主治医意見書情報For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4302ShujiiIkenshoJoho 主治医意見書情報 = new DbT4302ShujiiIkenshoJoho(申請書管理番号, 1);
        DbT4302ShujiiIkenshoJohoBuilder 主治医意見書情報Builder = 主治医意見書情報.createBuilderForEdit();
        主治医意見書情報Builder.set厚労省IF識別コード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());
        主治医意見書情報Builder.set主治医医療機関コード(dataPass.get調査状況用情報().get主治医医療機関コード());
        主治医意見書情報Builder.set主治医コード(dataPass.get調査状況用情報().get主治医コード());
        主治医意見書情報Builder.set主治医意見書依頼区分(IkenshoIraiKubun.初回依頼.getコード());
        主治医意見書情報Builder.set主治医意見書受領年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書記入年月日().toDateString()));
        主治医意見書情報Builder.set主治医意見書記入年月日(FlexibleDate.EMPTY);
        主治医意見書情報Builder.set意見書作成回数区分(new Code(IkenshoSakuseiKaisuKubun.初回.getコード()));
        主治医意見書情報Builder.set在宅_施設区分(Code.EMPTY);
        return 主治医意見書情報Builder.build();
    }

    /**
     * 主治医意見書情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 主治医意見書情報
     */
    public DbT4302ShujiiIkenshoJoho set主治医意見書情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4302ShujiiIkenshoJohoBuilder 主治医意見書情報Builder = business.get要介護認定主治医意見書情報().createBuilderForEdit();
        主治医意見書情報Builder.set厚労省IF識別コード(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード());
        主治医意見書情報Builder.set主治医医療機関コード(dataPass.get調査状況用情報().get主治医医療機関コード());
        主治医意見書情報Builder.set主治医コード(dataPass.get調査状況用情報().get主治医コード());
        主治医意見書情報Builder.set主治医意見書受領年月日(new FlexibleDate(dataPass.get調査状況用情報().get主治医意見書記入年月日().toDateString()));
        return 主治医意見書情報Builder.build().modifiedModel();
    }

    /**
     * 一次判定結果の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 一次判定結果
     */
    public IchijiHanteiKekkaJoho set一次判定結果For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        IchijiHanteiKekkaJoho 一次判定結果 = new IchijiHanteiKekkaJoho(申請書管理番号);
        IchijiHanteiKekkaJohoBuilder 一次判定結果Builder = 一次判定結果.createBuilderForEdit();
        一次判定結果Builder.set仮一次判定区分(false);
        一次判定結果Builder.set要介護認定一次判定年月日(new FlexibleDate(dataPass.get調査状況用情報().get要介護認定一次判定年月日().toDateString()));
        一次判定結果Builder.set要介護認定一次判定結果コード(dataPass.get調査状況用情報().get要介護認定一次判定結果コード());
        一次判定結果Builder.set要介護認定一次判定結果コード_認知症加算(dataPass.get調査状況用情報().get要介護認定一次判定結果コード_認知症加算());
        return 一次判定結果Builder.build();
    }

    /**
     * 一次判定結果の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 一次判定結果
     */
    public IchijiHanteiKekkaJoho set一次判定結果For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        IchijiHanteiKekkaJohoBuilder 一次判定結果Builder = business.get一次判定結果().createBuilderForEdit();
        一次判定結果Builder.set要介護認定一次判定年月日(new FlexibleDate(dataPass.get調査状況用情報().get要介護認定一次判定年月日().toDateString()));
        一次判定結果Builder.set要介護認定一次判定結果コード(dataPass.get調査状況用情報().get要介護認定一次判定結果コード());
        一次判定結果Builder.set要介護認定一次判定結果コード_認知症加算(dataPass.get調査状況用情報().get要介護認定一次判定結果コード_認知症加算());
        return 一次判定結果Builder.build().modifiedModel();
    }

    /**
     * 要介護認定結果情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 要介護認定結果情報
     */
    public DbT4102NinteiKekkaJoho set要介護認定結果情報For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4102NinteiKekkaJoho 認定結果情報 = new DbT4102NinteiKekkaJoho(申請書管理番号);
        DbT4102NinteiKekkaJohoBuilder 認定結果情報Builder = 認定結果情報.createBuilderForEdit();
        認定結果情報Builder.set二次判定年月日(new FlexibleDate(dataPass.get調査状況用情報().get二次判定年月日().toDateString()));
        認定結果情報Builder.set二次判定要介護状態区分コード(dataPass.get調査状況用情報().get二次判定要介護状態区分コード());
        認定結果情報Builder.set二次判定認定有効期間(dataPass.get調査状況用情報().get二次判定認定有効期間());
        認定結果情報Builder.set二次判定認定有効開始年月日(dataPass.get調査状況用情報().get二次判定認定有効開始年月日());
        認定結果情報Builder.set二次判定認定有効終了年月日(dataPass.get調査状況用情報().get二次判定認定有効終了年月日());
        認定結果情報Builder.set介護認定審査会意見(dataPass.get介護認定審査会意見());
        return 認定結果情報Builder.build();
    }

    /**
     * 要介護認定結果情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 要介護認定結果情報
     */
    public DbT4102NinteiKekkaJoho set要介護認定結果情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4102NinteiKekkaJohoBuilder 認定結果情報Builder = business.get要介護認定結果情報().createBuilderForEdit();
        認定結果情報Builder.set二次判定年月日(new FlexibleDate(dataPass.get調査状況用情報().get二次判定年月日().toDateString()));
        認定結果情報Builder.set二次判定要介護状態区分コード(dataPass.get調査状況用情報().get二次判定要介護状態区分コード());
        認定結果情報Builder.set二次判定認定有効期間(dataPass.get調査状況用情報().get二次判定認定有効期間());
        認定結果情報Builder.set二次判定認定有効開始年月日(dataPass.get調査状況用情報().get二次判定認定有効開始年月日());
        認定結果情報Builder.set二次判定認定有効終了年月日(dataPass.get調査状況用情報().get二次判定認定有効終了年月日());
        認定結果情報Builder.set介護認定審査会意見(dataPass.get介護認定審査会意見());
        return 認定結果情報Builder.build().modifiedModel();
    }

    /**
     * 申請届出情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @param row 画面のレコード
     * @return 申請届出情報
     */
    public DbT4120ShinseitodokedeJoho set申請届出情報For履歴追加(ShinseishoKanriNo 申請書管理番号, dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        DbT4120ShinseitodokedeJoho 申請届出情報 = new DbT4120ShinseitodokedeJoho(申請書管理番号);
        DbT4120ShinseitodokedeJohoBuilder 申請届出情報Builder = 申請届出情報.createBuilderForEdit();
        申請届出情報Builder.set申請届出代行区分コード(dataPass.get届出代行区分());
        申請届出情報Builder.set申請届出者氏名(dataPass.get氏名());
        申請届出情報Builder.set申請届出者氏名カナ(dataPass.getカナ氏名());
        申請届出情報Builder.set申請届出者続柄(dataPass.get本人との関係性());
        if (dataPass.get事業者番号() != null && !dataPass.get事業者番号().isEmpty()) {
            申請届出情報Builder.set申請届出代行事業者番号(dataPass.get事業者番号());
        }
        申請届出情報Builder.set事業者区分(dataPass.get事業者区分());
        申請届出情報Builder.set申請届出者郵便番号(dataPass.get郵便番号());
        申請届出情報Builder.set申請届出者電話番号(dataPass.get電話番号());
        申請届出情報Builder.set申請届出者住所(dataPass.get住所());
        return 申請届出情報Builder.build();
    }

    /**
     * 申請届出情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 申請届出情報
     */
    public DbT4120ShinseitodokedeJoho set申請届出情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4120ShinseitodokedeJohoBuilder 申請届出情報Builder = business.get申請届出情報().createBuilderForEdit();
        申請届出情報Builder.set申請届出代行区分コード(dataPass.get届出代行区分());
        申請届出情報Builder.set申請届出者氏名(dataPass.get氏名());
        申請届出情報Builder.set申請届出者氏名カナ(dataPass.getカナ氏名());
        申請届出情報Builder.set申請届出者続柄(dataPass.get本人との関係性());
        if (dataPass.get事業者番号() != null && !dataPass.get事業者番号().isEmpty()) {
            申請届出情報Builder.set申請届出代行事業者番号(dataPass.get事業者番号());
        }
        申請届出情報Builder.set事業者区分(dataPass.get事業者区分());
        申請届出情報Builder.set申請届出者郵便番号(dataPass.get郵便番号());
        申請届出情報Builder.set申請届出者電話番号(dataPass.get電話番号());
        申請届出情報Builder.set申請届出者住所(dataPass.get住所());
        return 申請届出情報Builder.build().modifiedModel();
    }

    /**
     * 認定計画情報の履歴追加処理
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定計画情報
     */
    public DbT4123NinteiKeikakuJoho set認定計画情報For履歴追加(ShinseishoKanriNo 申請書管理番号) {
        DbT4123NinteiKeikakuJoho 認定計画情報 = new DbT4123NinteiKeikakuJoho(申請書管理番号);
        DbT4123NinteiKeikakuJohoBuilder 認定計画情報Builder = 認定計画情報.createBuilderForEdit();
        FlexibleDate sysDate = FlexibleDate.getNowDate();
        認定計画情報Builder.set認定調査依頼予定年月日(sysDate.plusDay(Integer.parseInt(調査依頼.toString())));
        認定計画情報Builder.set認定調査予定年月日(sysDate.plusDay(Integer.parseInt(調査予定.toString())));
        認定計画情報Builder.set主治医意見書作成依頼予定年月日(sysDate.plusDay(Integer.parseInt(作成依頼.toString())));
        認定計画情報Builder.set主治医意見書登録予定年月日(sysDate.plusDay(Integer.parseInt(登録予定.toString())));
        認定計画情報Builder.set要介護認定一次判定予定年月日(sysDate.plusDay(Integer.parseInt(判定予定.toString())));
        認定計画情報Builder.set認定審査会割当予定年月日(sysDate.plusDay(Integer.parseInt(割当予定.toString())));
        認定計画情報Builder.set認定審査会予定年月日(sysDate.plusDay(Integer.parseInt(審査会予定.toString())));
        認定計画情報Builder.setセンター送信予定年月日(sysDate.plusDay(Integer.parseInt(送信予定.toString())));
        return 認定計画情報Builder.build();
    }

    /**
     * 認定計画情報の履歴修正処理
     *
     * @param row 画面のレコード
     * @return 認定計画情報
     */
    public DbT4123NinteiKeikakuJoho set認定計画情報For履歴修正(dgRirekiIchiran_Row row) {
        RirekiShuseiDataPass dataPass
                = DataPassingConverter.deserialize(row.getDataPass(), RirekiShuseiDataPass.class);
        RirekiShuseiBusiness business
                = DataPassingConverter.deserialize(row.getDeserializedBusiness(), RirekiShuseiBusiness.class);
        DbT4123NinteiKeikakuJohoBuilder 認定計画情報Builder = business.get要介護認定計画情報().createBuilderForEdit();
        FlexibleDate sysDate = dataPass.get認定申請年月日();
        認定計画情報Builder.set認定調査依頼予定年月日(sysDate.plusDay(Integer.parseInt(調査依頼.toString())));
        認定計画情報Builder.set認定調査予定年月日(sysDate.plusDay(Integer.parseInt(調査予定.toString())));
        認定計画情報Builder.set主治医意見書作成依頼予定年月日(sysDate.plusDay(Integer.parseInt(作成依頼.toString())));
        認定計画情報Builder.set主治医意見書登録予定年月日(sysDate.plusDay(Integer.parseInt(登録予定.toString())));
        認定計画情報Builder.set要介護認定一次判定予定年月日(sysDate.plusDay(Integer.parseInt(判定予定.toString())));
        認定計画情報Builder.set認定審査会割当予定年月日(sysDate.plusDay(Integer.parseInt(割当予定.toString())));
        認定計画情報Builder.set認定審査会予定年月日(sysDate.plusDay(Integer.parseInt(審査会予定.toString())));
        認定計画情報Builder.setセンター送信予定年月日(sysDate.plusDay(Integer.parseInt(送信予定.toString())));
        return 認定計画情報Builder.build().modifiedModel();
    }

    /**
     * 前回行にて、申請履歴情報の削除回復
     *
     * @param row 選択行
     * @param previousRow 前回行
     * @return 申請履歴情報
     */
    public DbT4121ShinseiRirekiJoho set申請履歴情報For削除回復前回(dgRirekiIchiran_Row row, dgRirekiIchiran_Row previousRow) {
        DbT4121ShinseiRirekiJoho 申請履歴情報 = new DbT4121ShinseiRirekiJoho(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        DbT4121ShinseiRirekiJohoBuilder builder = 申請履歴情報.createBuilderForEdit();
        if (previousRow != null) {
            DbT4121ShinseiRirekiJoho 前回行申請履歴情報 = DataPassingConverter.deserialize(previousRow.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
            builder.set前回申請管理番号(前回行申請履歴情報.get申請管理番号());
        } else {
            builder.set前回申請管理番号(new ShinseishoKanriNo(RString.EMPTY.padZeroToLeft(ZERO_17)));
        }
        return builder.build();
    }

    /**
     * 次回行にて、申請履歴情報の削除回復
     *
     * @param row 選択行
     * @param nextRow 次回行
     * @return 申請履歴情報
     */
    public DbT4121ShinseiRirekiJoho set申請履歴情報For削除回復次回(dgRirekiIchiran_Row row, dgRirekiIchiran_Row nextRow) {
        if (nextRow != null) {
            DbT4121ShinseiRirekiJoho 次回行申請履歴情報 = DataPassingConverter.deserialize(nextRow.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
            DbT4121ShinseiRirekiJohoBuilder builder = 次回行申請履歴情報.createBuilderForEdit();
            builder.set前回申請管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            return builder.build().modifiedModel();
        }
        return null;
    }

    /**
     * 申請履歴情報の履歴削除
     *
     * @param previousRow 前回行
     * @param nextRow 次回行
     * @param 申請履歴情報 選択行の申請履歴情報
     * @return 申請履歴情報
     */
    public DbT4121ShinseiRirekiJoho set申請履歴情報For履歴削除(dgRirekiIchiran_Row previousRow,
            dgRirekiIchiran_Row nextRow, DbT4121ShinseiRirekiJoho 申請履歴情報) {
        if (nextRow == null) {
            return null;
        }
        DbT4121ShinseiRirekiJoho 次回行申請履歴情報
                = DataPassingConverter.deserialize(nextRow.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
        DbT4121ShinseiRirekiJohoBuilder builder = 次回行申請履歴情報.createBuilderForEdit();
        if (previousRow == null) {
            builder.set前回申請管理番号(申請履歴情報.get前回申請管理番号());
        } else {
            DbT4121ShinseiRirekiJoho 前回行申請履歴情報
                    = DataPassingConverter.deserialize(previousRow.getShinseirirekiJoho(), DbT4121ShinseiRirekiJoho.class);
            builder.set前回申請管理番号(前回行申請履歴情報.get申請管理番号());
        }
        if (KU_BUN_追.equals(nextRow.getKubun()) && !nextRow.getTsuikaKubun().isValue()) {
            return builder.build();
        }
        return builder.build().modifiedModel();
    }
}
