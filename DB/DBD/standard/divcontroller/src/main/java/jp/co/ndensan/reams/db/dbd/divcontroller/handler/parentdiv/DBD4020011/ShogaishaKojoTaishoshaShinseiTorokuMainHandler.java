/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4020011;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.ShinseiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoToJotai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.ShogaishaKojoTaishoshaShinseiTorokuMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shogaishakoujo.ShogaishaKojoTaishoshaShinseiTorokuManager;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shogaishakoujo.ShogaishaKoujoManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 障がい者控除対象者申請登録画面ハンドラクラスです。
 *
 * @reamsid_L DBD-3840-010 wangjie2
 */
public class ShogaishaKojoTaishoshaShinseiTorokuMainHandler {

    private final ShogaishaKojoTaishoshaShinseiTorokuMainDiv div;
    private final RString 保存する = new RString("btnUpdate");
    private final RString 申請メニュー = new RString("DBDMN41002");
    private final RString 申請情報を追加する = new RString("申請情報を追加する");
    private final RString 承認情報を追加する = new RString("承認情報を追加する");
    private final RString 申請情報を保存する = new RString("申請情報を");
    private final RString 承認情報を保存する = new RString("承認情報を");
    private final RString 申請情報を確定する = new RString("申請情報を確定する");
    private final RString 承認情報を確定する = new RString("承認情報を確定する");
    private final RString 被保険者番号_Name = new RString("被保険者番号");
    private final RString 承認する = new RString("1");
    private final RString 承認しない = new RString("0");
    private final RString 漢字承認する = new RString("承認する");
    private final RString 漢字承認しない = new RString("承認しない");
    private final RString 状態_追加 = new RString("追加");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_削除 = new RString("削除");
    private final RString 申請情報 = new RString("申請情報");
    private final RString 承認情報 = new RString("承認情報");
    private final RString あり = new RString("あり");
    private final RString なし = new RString("なし");
    private final RString 対象外 = new RString("対象外");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString KEY0 = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div 障がい者控除対象者申請登録Div
     */
    public ShogaishaKojoTaishoshaShinseiTorokuMainHandler(ShogaishaKojoTaishoshaShinseiTorokuMainDiv div) {
        this.div = div;
    }

    /**
     * ViewState.被保険者番号に、該当する申請一覧の情報をすべて取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<ShogaishaKoujo> 申請一覧情報の取得(HihokenshaNo 被保険者番号) {
        return ShogaishaKoujoManager.createInstance().getすべて障がい書控除申請一覧情報By被保険者番号(被保険者番号);
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 申請一覧情報 申請一覧情報
     * @return 情報と状態List
     */
    public List<ShogaishaKoujoToJotai> onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, List<ShogaishaKoujo> 申請一覧情報) {
        div.getShogaishaKojoTaishoshaShinseiToroku().setHihokenshaNo(被保険者番号.getColumnValue());
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdKaigoKihon().initialize(被保険者番号);
        div.getCcdGemmenGengakuShinsei().initialize(識別コード);
        List<ShogaishaKoujoToJotai> 情報と状態List = 情報と状態初期化(申請一覧情報);
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            申請情報を追加するボタン活性設定(申請一覧情報);
        }
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態List));
        div.getDdlNinchishoKoreishaJiritsudo().setDataSource(get認知症高齢者自立度DataSource());
        div.getDdlNinchishoKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        div.getDdlShogaiKoreishaJiritsudo().setDataSource(get障害高齢者自立度DataSource());
        div.getDdlShogaiKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        div.getDdlNinteiKubun().setDataSource(get認定区分DataSource());
        div.getDdlNinteiKubun().setSelectedKey(RString.EMPTY);
        div.getDdlNinteiNaiyo().setDataSource(get認定内容DataSource());
        div.getDdlNinteiNaiyo().setSelectedKey(RString.EMPTY);
        画面初期化制御();
        PersonalData personalData
                = PersonalData.of(識別コード, new ExpandedInformation(CODE_0003, 被保険者番号_Name, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.照会, personalData);
        申請情報エリア非活性制御();
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("ShogaishaKoujo"))));
        return 情報と状態List;
    }

    /**
     * 前排他解除処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他解除(HihokenshaNo 被保険者番号) {
        RealInitialLocker.release(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue().concat("ShogaishaKoujo"))));
    }

    private void 申請情報を追加するボタン活性設定(List<ShogaishaKoujo> 申請一覧情報) {
        for (ShogaishaKoujo 申請情報 : 申請一覧情報) {
            if (null == 申請情報.get決定年月日() || 申請情報.get決定年月日().isEmpty()) {
                div.getBtnAddShinsei().setDisabled(true);
                return;
            }
        }
    }

    private List<KeyValueDataSource> get認知症高齢者自立度DataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinchishoNichijoSeikatsuJiritsudoCode value : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            dataSource.add(new KeyValueDataSource(value.getコード(), value.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get障害高齢者自立度DataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (ShogaiNichijoSeikatsuJiritsudoCode value : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            dataSource.add(new KeyValueDataSource(value.getコード(), value.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get認定区分DataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (Ninteikubun value : Ninteikubun.values()) {
            dataSource.add(new KeyValueDataSource(value.getコード(), value.get名称()));
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get認定内容DataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        for (NinteiNaiyoKubun value : NinteiNaiyoKubun.values()) {
            dataSource.add(new KeyValueDataSource(value.getコード(), value.get名称()));
        }
        return dataSource;
    }

    private List<dgShinseiList_Row> getDataSource(List<ShogaishaKoujoToJotai> 情報と状態List) {
        List<dgShinseiList_Row> rowList = new ArrayList<>();
        for (ShogaishaKoujoToJotai 情報と状態 : 情報と状態List) {
            ShogaishaKoujo 障がい書控除申請登録情報 = 情報と状態.get障がい書控除申請登録情報();
            dgShinseiList_Row row = new dgShinseiList_Row();
            row.setJotai(情報と状態.get状態());
            TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
            申請日.setValue(障がい書控除申請登録情報.get申請年月日());
            row.setTxtShinseiYMD(申請日);
            row.setShinseiRiyu(障がい書控除申請登録情報.get申請事由());
            row.setKetteiKubun(get決定区分(障がい書控除申請登録情報.get決定区分()));
            if (障がい書控除申請登録情報.get決定年月日() != null) {
                TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
                決定日.setValue(障がい書控除申請登録情報.get決定年月日());
                row.setTxtKetteiYMD(決定日);
            }
            row.setShoninShinaiRiyu(障がい書控除申請登録情報.get非承認理由());
            if (障がい書控除申請登録情報.get対象年度() != null) {
                row.setShinseiJiyu(障がい書控除申請登録情報.get対象年度().wareki().toDateString());
            }
            if (障がい書控除申請登録情報.get認定区分() != null && !障がい書控除申請登録情報.get認定区分().isEmpty()) {
                row.setNinteiKubun(Ninteikubun.toValue(障がい書控除申請登録情報.get認定区分()).get名称());
            }
            if (障がい書控除申請登録情報.get認定内容() != null && !障がい書控除申請登録情報.get認定内容().isEmpty()) {
                row.setNinteiNaiyo(NinteiNaiyoKubun.toValue(障がい書控除申請登録情報.get認定内容()).get名称());
            }
            if (障がい書控除申請登録情報.get基準日() != null && !障がい書控除申請登録情報.get基準日().isEmpty()) {
                row.setKijunYMD(障がい書控除申請登録情報.get基準日().wareki().toDateString());
            }
            if (障がい書控除申請登録情報.get把握日() != null && !障がい書控除申請登録情報.get把握日().isEmpty()) {
                row.setHaakuYMD(障がい書控除申請登録情報.get把握日().wareki().toDateString());
            }
            if (!isCodeEmpty(障がい書控除申請登録情報.get認知症高齢者の日常生活自立度コード())) {
                row.setNinchishoKoreisha(NinchishoNichijoSeikatsuJiritsudoCode
                        .toValue(障がい書控除申請登録情報.get認知症高齢者の日常生活自立度コード().getColumnValue()).get名称());
            }
            if (!isCodeEmpty(障がい書控除申請登録情報.get障がい高齢者の日常生活自立度コード())) {
                row.setNichijoSeikatsu(ShogaiNichijoSeikatsuJiritsudoCode
                        .toValue(障がい書控除申請登録情報.get障がい高齢者の日常生活自立度コード().getColumnValue()).get名称());
            }
            row.setShogaishatech(get障がい者手帳有無(障がい書控除申請登録情報.is障がい者手帳有無()));
            row.setNinteishoHakko(get認定証発行対象外フラグ(障がい書控除申請登録情報.is認定証発行対象外フラグ()));
            row.setDadaId(DataPassingConverter.serialize(障がい書控除申請登録情報.identifier()));
            rowList.add(row);
        }
        return rowList;
    }

    private RString get障がい者手帳有無(boolean 障がい者手帳有無) {
        if (障がい者手帳有無) {
            return あり;
        }
        return なし;
    }

    private RString get認定証発行対象外フラグ(boolean 認定証発行対象外フラグ) {
        if (認定証発行対象外フラグ) {
            return 対象外;
        }
        return RString.EMPTY;
    }

    private boolean isCodeEmpty(Code code) {
        return null == code || code.isEmpty();
    }

    /**
     * 世帯所得一覧の初期化処理です。
     *
     * @param 識別コード 識別コード
     */
    public void 世帯所得一覧の初期化(ShikibetsuCode 識別コード) {
        YMDHMS 現在年月日日時時分秒 = YMDHMS.now();
        div.getCcdSetaiShotokuIchiran().initialize(
                識別コード,
                new FlexibleDate(現在年月日日時時分秒.getDate().toDateString()),
                new HizukeConfig().get所得年度(),
                現在年月日日時時分秒);
    }

    private RString get決定区分(RString 決定区分) {
        if (null == 決定区分) {
            return RString.EMPTY;
        }
        if (承認する.equals(決定区分)) {
            return 漢字承認する;
        } else if (承認しない.equals(決定区分)) {
            return 漢字承認しない;
        }
        return RString.EMPTY;
    }

    private List<ShogaishaKoujoToJotai> 情報と状態初期化(List<ShogaishaKoujo> 申請一覧情報) {
        List<ShogaishaKoujoToJotai> 情報と状態List = new ArrayList<>();
        for (ShogaishaKoujo 申請情報 : 申請一覧情報) {
            情報と状態List.add(new ShogaishaKoujoToJotai(申請情報, RString.EMPTY, 申請情報.get履歴番号()));
        }
        return 情報と状態List;
    }

    /**
     * 申請情報エリア非活性制御処理です。
     *
     */
    public void 申請情報エリア非活性制御() {
        div.getTxtShinseiYMD().setDisabled(true);
        div.getTxtShinseiRiyu().setDisabled(true);
        div.getCcdGemmenGengakuShinsei().setDisabled(true);
        div.getKetteiJoho().setDisabled(true);
        div.getBtnBackToShinseiList().setDisabled(true);
        div.getTxtDetermineShinsei().setDisabled(true);
    }

    private void 画面初期化制御() {

        div.getBtnShowSetaiJoho().setDisplayNone(false);
        div.getBtnCloseSetaiJoho().setDisplayNone(true);
        if (申請メニュー.equals(ResponseHolder.getMenuID())) {
            div.getBtnAddShinsei().setText(申請情報を追加する);
            div.getTxtDetermineShinsei().setText(申請情報を確定する);
            div.getShinseiDetail().setTitle(申請情報);
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, 申請情報を保存する.toString());
        } else {
            CommonButtonHolder.setAdditionalTextByCommonButtonFieldName(保存する, 承認情報を保存する.toString());
            div.getBtnAddShinsei().setText(承認情報を追加する);
            div.getTxtDetermineShinsei().setText(承認情報を確定する);
            div.getShinseiDetail().setTitle(承認情報);
        }
    }

    /**
     * 「申請情報を追加する」（また「承認情報を追加する」）を押下処理です。
     *
     * @param 識別コード 識別コード
     */
    public void onClick_btnAddShinsei(ShikibetsuCode 識別コード) {
        div.getTxtShinseiYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        clear申請情報エリア(識別コード);
        一覧制御(true, true, false);
    }

    private void clear申請情報エリア(ShikibetsuCode 識別コード) {
        div.getTxtShinseiYMD().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        div.getTxtShinseiRiyu().clearValue();
        div.getCcdGemmenGengakuShinsei().initialize(識別コード);
        div.getRadKettaiKubun().setSelectedValue(漢字承認する);
        div.getTxtKettaiYMD().clearValue();
        div.getTxtTaishoNendo().clearDomain();
        div.getTxtKijunYMD().clearValue();
        div.getTxtHaakuYMD().clearValue();
        List<RString> selectedKeys = new ArrayList<>();
        div.getChkHasShogaishaTecho().setSelectedItemsByKey(selectedKeys);
        div.getChkIsNinteishoHakkoTaishoGai().setSelectedItemsByKey(selectedKeys);
        div.getTxtHiShoninRiyu().clearValue();
        div.getDdlNinchishoKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        div.getDdlShogaiKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        div.getDdlNinteiKubun().setSelectedKey(RString.EMPTY);
        div.getDdlNinteiNaiyo().setSelectedKey(RString.EMPTY);
    }

    private void 一覧制御(boolean is追加修正, boolean is承認する, boolean is承認情報) {
        div.getBtnAddShinsei().setDisabled(true);
        div.getDgShinseiList().setDisabled(true);
        div.getTxtShinseiYMD().setDisabled(!is追加修正);
        div.getTxtShinseiRiyu().setDisabled(false);
        div.getCcdGemmenGengakuShinsei().setDisabled(false);
        div.getKetteiJoho().setDisabled(false);
        div.getBtnBackToShinseiList().setDisabled(false);
        div.getTxtDetermineShinsei().setDisabled(false);
        boolean is申請メニュー = 申請メニュー.equals(ResponseHolder.getMenuID());
        div.getRadKettaiKubun().setDisabled(is申請メニュー);
        div.getTxtKettaiYMD().setDisabled(is申請メニュー);
        div.getTxtKijunYMD().setDisabled(is申請メニュー);
        div.getTxtHaakuYMD().setDisabled(is申請メニュー);
        div.getChkHasShogaishaTecho().setDisabled(is申請メニュー);
        div.getChkIsNinteishoHakkoTaishoGai().setDisabled(is申請メニュー);
        if (is申請メニュー) {
            div.getDdlNinchishoKoreishaJiritsudo().setDisabled(true);
            div.getDdlShogaiKoreishaJiritsudo().setDisabled(true);
            div.getDdlNinteiKubun().setDisabled(true);
            div.getDdlNinteiNaiyo().setDisabled(true);
            div.getTxtTaishoNendo().setDisabled(true);
        } else {
            div.getDdlNinchishoKoreishaJiritsudo().setDisabled(!is承認する);
            div.getDdlShogaiKoreishaJiritsudo().setDisabled(!is承認する);
            div.getDdlNinteiKubun().setDisabled(!is承認する);
            div.getDdlNinteiNaiyo().setDisabled(!is承認する);
            div.getTxtTaishoNendo().setDisabled(is承認情報);
        }
        div.getTxtHiShoninRiyu().setDisabled(is申請メニュー || is承認する);
        div.getBtnHiShoninRiyu().setDisabled(is申請メニュー || is承認する);
    }

    /**
     * 申請一覧の修正ボタンを押下処理です。
     *
     * @param 情報と状態 情報と状態
     */
    public void onSelectByModifyButton(ShogaishaKoujoToJotai 情報と状態, boolean is承認情報) {
        set申請情報エリア(情報と状態);
        一覧制御(状態_追加.equals(情報と状態.get状態()), 承認する.equals(情報と状態.get障がい書控除申請登録情報().get決定区分()), is承認情報);
    }

    private void set申請情報エリア(ShogaishaKoujoToJotai 情報と状態) {
        ShogaishaKoujo 障がい書控除申請登録情報 = 情報と状態.get障がい書控除申請登録情報();
        div.getTxtShinseiYMD().setValue(障がい書控除申請登録情報.get申請年月日());
        div.getTxtShinseiRiyu().setValue(障がい書控除申請登録情報.get申請事由());
        div.getCcdGemmenGengakuShinsei().set減免減額申請情報(getShinseiJoho(障がい書控除申請登録情報), 障がい書控除申請登録情報.get申請年月日());
        if (障がい書控除申請登録情報.get決定区分() != null && !障がい書控除申請登録情報.get決定区分().isEmpty()) {
            div.getRadKettaiKubun().setSelectedKey(障がい書控除申請登録情報.get決定区分());
        } else {
            div.getRadKettaiKubun().setSelectedKey(承認しない);
        }
        if (障がい書控除申請登録情報.get決定年月日() != null) {
            div.getTxtKettaiYMD().setValue(障がい書控除申請登録情報.get決定年月日());
        } else {
            div.getTxtKettaiYMD().clearValue();
        }
        if (障がい書控除申請登録情報.get対象年度() != null) {
            div.getTxtTaishoNendo().setDomain(障がい書控除申請登録情報.get対象年度());
        } else {
            div.getTxtTaishoNendo().clearDomain();
        }
        List<RString> selectedKeys = new ArrayList<>();
        List<RString> selectedKeysEmpty = new ArrayList<>();
        selectedKeys.add(KEY0);
        if (障がい書控除申請登録情報.is障がい者手帳有無()) {
            div.getChkHasShogaishaTecho().setSelectedItemsByKey(selectedKeys);
        } else {
            div.getChkHasShogaishaTecho().setSelectedItemsByKey(selectedKeysEmpty);
        }
        if (障がい書控除申請登録情報.is認定証発行対象外フラグ()) {
            div.getChkIsNinteishoHakkoTaishoGai().setSelectedItemsByKey(selectedKeys);
        } else {
            div.getChkIsNinteishoHakkoTaishoGai().setSelectedItemsByKey(selectedKeysEmpty);
        }
        if (障がい書控除申請登録情報.get基準日() != null) {
            div.getTxtKijunYMD().setValue(障がい書控除申請登録情報.get基準日());
        } else {
            div.getTxtKijunYMD().clearValue();
        }
        if (障がい書控除申請登録情報.get把握日() != null) {
            div.getTxtHaakuYMD().setValue(障がい書控除申請登録情報.get把握日());
        } else {
            div.getTxtHaakuYMD().clearValue();
        }
        setDdl(障がい書控除申請登録情報);
        if (null == 障がい書控除申請登録情報.get決定区分()
                || 障がい書控除申請登録情報.get決定区分().isEmpty()
                || 承認しない.equals(障がい書控除申請登録情報.get決定区分())) {
            div.getTxtHiShoninRiyu().setDisabled(false);
            div.getBtnHiShoninRiyu().setDisabled(false);
            div.getDdlNinchishoKoreishaJiritsudo().setDisabled(true);
            div.getDdlShogaiKoreishaJiritsudo().setDisabled(true);
            div.getDdlNinteiKubun().setDisabled(true);
            div.getDdlNinteiNaiyo().setDisabled(true);
        } else {
            div.getTxtHiShoninRiyu().setDisabled(true);
            div.getBtnHiShoninRiyu().setDisabled(true);
            div.getDdlNinchishoKoreishaJiritsudo().setDisabled(false);
            div.getDdlShogaiKoreishaJiritsudo().setDisabled(false);
            div.getDdlNinteiKubun().setDisabled(false);
            div.getDdlNinteiNaiyo().setDisabled(false);
        }
        if (障がい書控除申請登録情報.get非承認理由() != null) {
            div.getTxtHiShoninRiyu().setValue(障がい書控除申請登録情報.get非承認理由());
        } else {
            div.getTxtHiShoninRiyu().clearValue();
        }
    }

    private void setDdl(ShogaishaKoujo 障がい書控除申請登録情報) {
        if (!isCodeEmpty(障がい書控除申請登録情報.get認知症高齢者の日常生活自立度コード())) {
            div.getDdlNinchishoKoreishaJiritsudo().setSelectedKey(障がい書控除申請登録情報.get認知症高齢者の日常生活自立度コード().getColumnValue());
        } else {
            div.getDdlNinchishoKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        }
        if (!isCodeEmpty(障がい書控除申請登録情報.get障がい高齢者の日常生活自立度コード())) {
            div.getDdlShogaiKoreishaJiritsudo().setSelectedKey(障がい書控除申請登録情報.get障がい高齢者の日常生活自立度コード().getColumnValue());
        } else {
            div.getDdlShogaiKoreishaJiritsudo().setSelectedKey(RString.EMPTY);
        }
        if (障がい書控除申請登録情報.get認定区分() != null && !障がい書控除申請登録情報.get認定区分().isEmpty()) {
            div.getDdlNinteiKubun().setSelectedKey(障がい書控除申請登録情報.get認定区分());
        } else {
            div.getDdlNinteiKubun().setSelectedKey(RString.EMPTY);
        }
        if (障がい書控除申請登録情報.get認定内容() != null && !障がい書控除申請登録情報.get認定内容().isEmpty()) {
            div.getDdlNinteiNaiyo().setSelectedKey(障がい書控除申請登録情報.get認定内容());
        } else {
            div.getDdlNinteiNaiyo().setSelectedKey(RString.EMPTY);
        }
    }

    private ShinseiJoho getShinseiJoho(ShogaishaKoujo 障がい書控除申請登録情報) {
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 障がい書控除申請登録情報.getGemmenGengakuShinseiList();
        if (null == gemmenGengakuShinseiList || gemmenGengakuShinseiList.isEmpty()) {
            return new ShinseiJoho(null, AtenaMeisho.EMPTY, AtenaKanaMeisho.EMPTY,
                    RString.EMPTY, JigyoshaNo.EMPTY, null, YubinNo.EMPTY, AtenaJusho.EMPTY, TelNo.EMPTY);
        }
        GemmenGengakuShinsei gemmenGengakuShinsei = gemmenGengakuShinseiList.get(0);
        ShinseiTodokedeDaikoKubunCode 申請届出代行区分 = null;
        if (gemmenGengakuShinsei.get申請届出代行区分() != null && !gemmenGengakuShinsei.get申請届出代行区分().isEmpty()) {
            申請届出代行区分 = ShinseiTodokedeDaikoKubunCode.toValue(gemmenGengakuShinsei.get申請届出代行区分());
        }
        JigyoshaKubun 事業者区分 = null;
        if (gemmenGengakuShinsei.get事業者区分() != null && !gemmenGengakuShinsei.get事業者区分().isEmpty()) {
            事業者区分 = JigyoshaKubun.toValue(gemmenGengakuShinsei.get事業者区分());
        }
        JigyoshaNo 事業者番号 = gemmenGengakuShinsei.get申請届出代行事業者番号();
        if (null == 事業者番号) {
            事業者番号 = JigyoshaNo.EMPTY;
        }
        return new ShinseiJoho(申請届出代行区分, gemmenGengakuShinsei.get申請届出者氏名(), gemmenGengakuShinsei.get申請届出者氏名カナ(),
                gemmenGengakuShinsei.get申請届出者続柄(), 事業者番号, 事業者区分, gemmenGengakuShinsei.get申請届出者郵便番号(),
                gemmenGengakuShinsei.get申請届出者住所(), gemmenGengakuShinsei.get申請届出者電話番号());
    }

    /**
     * DataSouce情報取得処理する。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @return 情報と状態
     */
    public ShogaishaKoujoToJotai get情報と状態BySelectDataSouce(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        ShogaishaKoujoIdentifier id
                = DataPassingConverter.deserialize(row.getDadaId(), ShogaishaKoujoIdentifier.class);
        for (ShogaishaKoujoToJotai 情報と状態 : 情報と状態ArrayList) {
            if (id.equals(情報と状態.get障がい書控除申請登録情報().identifier())) {
                return 情報と状態;
            }
        }
        return null;
    }

    /**
     * 決定区分を押下処理です。
     *
     */
    public void onChange_radKettaiKubun() {
        boolean is承認する = 漢字承認する.equals(div.getRadKettaiKubun().getSelectedValue());
        div.getDdlNinchishoKoreishaJiritsudo().setDisabled(!is承認する);
        div.getDdlShogaiKoreishaJiritsudo().setDisabled(!is承認する);
        div.getDdlNinteiKubun().setDisabled(!is承認する);
        div.getDdlNinteiNaiyo().setDisabled(!is承認する);
        div.getTxtHiShoninRiyu().setDisabled(is承認する);
        div.getBtnHiShoninRiyu().setDisabled(is承認する);
    }

    /**
     * 「申請情報を確定する」（また「承認情報を確定する」）ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 編集情報 編集情報
     * @param 追加履歴番号 追加履歴番号
     * @param 最初情報 最初情報
     * @param 被保険者番号 被保険者番号
     */
    public void onClick_btnConfirm(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList,
            ShogaishaKoujoToJotai 編集情報, Integer 追加履歴番号,
            ShogaishaKoujoToJotai 最初情報, HihokenshaNo 被保険者番号) {
        if (null == 編集情報) {
            ShogaishaKoujoToJotai 画面情報 = get情報と状態From画面(追加履歴番号, 被保険者番号);
            追加処理(情報と状態ArrayList, 画面情報);
        } else {
            if (状態_追加.equals(編集情報.get状態())) {
                追加修正処理(情報と状態ArrayList, 編集情報);
            } else {
                修正処理(情報と状態ArrayList, 編集情報, 最初情報);
            }
        }
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態ArrayList));
        div.getBtnAddShinsei().setDisabled(false);
        div.getDgShinseiList().setDisabled(false);
        申請情報エリア非活性制御();
    }

    private void 追加修正処理(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, ShogaishaKoujoToJotai 編集情報) {
        ShogaishaKoujo 編集障がい書控除申請登録情報 = 編集情報.get障がい書控除申請登録情報();
        ShogaishaKoujoIdentifier id = 編集障がい書控除申請登録情報.identifier();
        boolean isDeleteed = false;
        for (int index = 0; index < 情報と状態ArrayList.size() && !isDeleteed; index++) {
            if (id.equals(情報と状態ArrayList.get(index).get障がい書控除申請登録情報().identifier())) {
                情報と状態ArrayList.remove(index);
                isDeleteed = true;
            } else {
                情報と状態ArrayList.get(index).set新履歴番号(情報と状態ArrayList.get(index).get新履歴番号() - 1);
            }
        }
        修正情報と状態(編集情報);
        追加処理(情報と状態ArrayList, 編集情報);
    }

    private void 修正処理(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, ShogaishaKoujoToJotai 編集情報, ShogaishaKoujoToJotai 最初情報) {
        ShogaishaKoujo 編集障がい書控除申請登録情報 = 編集情報.get障がい書控除申請登録情報();
        ShogaishaKoujoIdentifier id = 編集障がい書控除申請登録情報.identifier();
        int size = 情報と状態ArrayList.size();
        for (int index = 0; index < size; index++) {
            ShogaishaKoujoToJotai 情報と状態 = 情報と状態ArrayList.get(index);
            if (id.equals(情報と状態.get障がい書控除申請登録情報().identifier())) {
                if (!is修正(最初情報)) {
                    最初情報.set状態(RString.EMPTY);
                    最初情報.set新履歴番号(情報と状態.get新履歴番号());
                    情報と状態ArrayList.remove(index);
                    add情報と状態(情報と状態ArrayList, 最初情報, index, size);
                } else {
                    修正情報と状態(情報と状態);
                }
            }
        }
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態ArrayList));
    }

    private void 修正情報と状態(ShogaishaKoujoToJotai 情報と状態) {
        ShogaishaKoujo 情報 = 情報と状態.get障がい書控除申請登録情報();
        ShogaishaKoujoBuilder builder = 情報.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        if (!申請メニュー.equals(ResponseHolder.getMenuID()) && 承認する.equals(div.getRadKettaiKubun().getSelectedKey())) {
            builder.set非承認理由(RString.EMPTY);
            builder.set認知症高齢者の日常生活自立度コード(rStringToCode(div.getDdlNinchishoKoreishaJiritsudo().getSelectedKey()));
            builder.set障がい高齢者の日常生活自立度コード(rStringToCode(div.getDdlShogaiKoreishaJiritsudo().getSelectedKey()));
            builder.set認定区分(get認定区分Or認定内容Key(div.getDdlNinteiKubun().getSelectedKey()));
            builder.set認定内容(get認定区分Or認定内容Key(div.getDdlNinteiNaiyo().getSelectedKey()));
        }
        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            builder.set決定区分(div.getRadKettaiKubun().getSelectedKey());
            builder.set決定年月日(div.getTxtKettaiYMD().getValue());
            builder.set対象年度(div.getTxtTaishoNendo().getDomain());
            if (div.getTxtKijunYMD().getValue() != null) {
                builder.set基準日(div.getTxtKijunYMD().getValue());
            } else {
                builder.set基準日(FlexibleDate.EMPTY);
            }
            if (div.getTxtHaakuYMD().getValue() != null) {
                builder.set把握日(div.getTxtHaakuYMD().getValue());
            } else {
                builder.set把握日(FlexibleDate.EMPTY);
            }
            builder.set障がい者手帳有無(!div.getChkHasShogaishaTecho().getSelectedKeys().isEmpty());
            builder.set認定証発行対象外フラグ(!div.getChkIsNinteishoHakkoTaishoGai().getSelectedKeys().isEmpty());
            if (承認しない.equals(div.getRadKettaiKubun().getSelectedKey())) {
                builder.set非承認理由(div.getTxtHiShoninRiyu().getValue());
                builder.set認知症高齢者の日常生活自立度コード(null);
                builder.set障がい高齢者の日常生活自立度コード(null);
                builder.set認定区分(null);
                builder.set認定内容(null);
            }
        }
        List<GemmenGengakuShinsei> 減免減額申請リスト = 情報.getGemmenGengakuShinseiList();
        if (null == 減免減額申請リスト || 減免減額申請リスト.isEmpty()) {
            builder.setGemmenGengakuShinsei(
                    get減免減額申請From画面(情報.get証記載保険者番号(), 情報.get履歴番号(), 情報.get被保険者番号()));
        } else {
            GemmenGengakuShinsei 減免減額申請 = 減免減額申請リスト.get(0);
            builder.setGemmenGengakuShinsei(get修正減免減額申請(減免減額申請));
        }
        情報と状態.set障がい書控除申請登録情報(builder.build());
        if (isNullOrEmpty(情報と状態.get状態()) || 状態_修正.equals(情報と状態.get状態()) || 状態_削除.equals(情報と状態.get状態())) {
            情報と状態.set状態(状態_修正);
        }
    }

    private boolean isNullOrEmpty(RString value) {
        return null == value || value.isEmpty();
    }

    private RString get認定区分Or認定内容Key(RString key) {
        if (null == key || key.isEmpty()) {
            return null;
        }
        return key;
    }

    private Code rStringToCode(RString value) {
        if (null == value || value.isEmpty()) {
            return null;
        }
        return new Code(value);
    }

    private GemmenGengakuShinsei get修正減免減額申請(GemmenGengakuShinsei 減免減額申請) {
        GemmenGengakuShinseiBuilder builder = 減免減額申請.createBuilderForEdit();
        ShinseiJoho 減免減額申請情報 = div.getCcdGemmenGengakuShinsei().get減免減額申請情報();
        if (減免減額申請情報.get申請届出代行区分() != null) {
            builder.set申請届出代行区分(減免減額申請情報.get申請届出代行区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者氏名()) {
            builder.set申請届出者氏名(AtenaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名(減免減額申請情報.get申請届出者氏名());
        }
        if (null == 減免減額申請情報.get申請届出者氏名カナ()) {
            builder.set申請届出者氏名カナ(AtenaKanaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名カナ(減免減額申請情報.get申請届出者氏名カナ());
        }
        if (null == 減免減額申請情報.get申請届出者続柄()) {
            builder.set申請届出者続柄(RString.EMPTY);
        } else {
            builder.set申請届出者続柄(減免減額申請情報.get申請届出者続柄());
        }
        if (減免減額申請情報.get申請届出代行事業者番号() != null && !減免減額申請情報.get申請届出代行事業者番号().isEmpty()) {
            builder.set申請届出代行事業者番号(減免減額申請情報.get申請届出代行事業者番号());
        }
        if (減免減額申請情報.get事業者区分() != null) {
            builder.set事業者区分(減免減額申請情報.get事業者区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者郵便番号()) {
            builder.set申請届出者郵便番号(YubinNo.EMPTY);
        } else {
            builder.set申請届出者郵便番号(減免減額申請情報.get申請届出者郵便番号());
        }
        if (null == 減免減額申請情報.get申請届出者住所()) {
            builder.set申請届出者住所(AtenaJusho.EMPTY);
        } else {
            builder.set申請届出者住所(減免減額申請情報.get申請届出者住所());
        }
        if (null == 減免減額申請情報.get申請届出者電話番号()) {
            builder.set申請届出者電話番号(TelNo.EMPTY);
        } else {
            builder.set申請届出者電話番号(減免減額申請情報.get申請届出者電話番号());
        }
        return builder.build();

    }

    private void add情報と状態(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, ShogaishaKoujoToJotai 情報と状態, int index, int size) {
        if (index == size) {
            情報と状態ArrayList.add(情報と状態);
        } else {
            情報と状態ArrayList.add(index, 情報と状態);
        }
    }

    private boolean is修正(ShogaishaKoujoToJotai 最初情報) {
        ShogaishaKoujo 障がい書控除申請 = 最初情報.get障がい書控除申請登録情報();
        if (!障がい書控除申請.get申請年月日().equals(div.getTxtShinseiYMD().getValue())) {
            return true;
        }
        if (!isEquals(障がい書控除申請.get申請事由(), div.getTxtShinseiRiyu().getValue())) {
            return true;
        }
        if (!申請メニュー.equals(ResponseHolder.getMenuID()) && is承認情報修正(障がい書控除申請)) {
            return true;
        }
        return is減免減額申請修正(障がい書控除申請);
    }

    private boolean is減免減額申請修正(ShogaishaKoujo 障がい書控除申請) {
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = 障がい書控除申請.getGemmenGengakuShinseiList();
        if (gemmenGengakuShinseiList.isEmpty()) {
            return true;
        }
        GemmenGengakuShinsei 減免減額申請 = gemmenGengakuShinseiList.get(0);
        ShinseiJoho 画面減免減額申請 = div.getCcdGemmenGengakuShinsei().get減免減額申請情報();
        return !isEquals(減免減額申請.get事業者区分(), null == 画面減免減額申請.get事業者区分() ? null : 画面減免減額申請.get事業者区分().getCode())
                || !isEquals(減免減額申請.get申請届出者氏名カナ(), 画面減免減額申請.get申請届出者氏名カナ())
                || !isEquals(減免減額申請.get申請届出者氏名(), 画面減免減額申請.get申請届出者氏名())
                || !isEquals(減免減額申請.get申請届出者続柄(), 画面減免減額申請.get申請届出者続柄())
                || !isEquals(減免減額申請.get申請届出者郵便番号(), 画面減免減額申請.get申請届出者郵便番号())
                || !isEquals(減免減額申請.get申請届出者電話番号(), 画面減免減額申請.get申請届出者電話番号())
                || !isEquals(減免減額申請.get申請届出者住所(), 画面減免減額申請.get申請届出者住所())
                || !isEquals(減免減額申請.get申請届出代行区分(),
                        null == 画面減免減額申請.get申請届出代行区分() ? null : 画面減免減額申請.get申請届出代行区分().getCode());
    }

    private boolean is承認情報修正(ShogaishaKoujo 障がい書控除申請) {
        if (!div.getRadKettaiKubun().getSelectedKey().equals(障がい書控除申請.get決定区分())) {
            return true;
        }
        if (承認する.equals(div.getRadKettaiKubun().getSelectedKey())) {
            if (!div.getTxtKettaiYMD().getValue().equals(障がい書控除申請.get決定年月日())
                    || !div.getTxtTaishoNendo().getDomain().equals(障がい書控除申請.get対象年度())
                    || !isEquals(div.getTxtKettaiYMD().getValue(), 障がい書控除申請.get決定年月日())
                    || !isEquals(div.getTxtKettaiYMD().getValue(), 障がい書控除申請.get決定年月日())) {
                return true;
            }
        } else if (!isEquals(div.getTxtHiShoninRiyu().getValue(), 障がい書控除申請.get非承認理由())) {
            return true;
        }
        if (!isEquals(div.getChkHasShogaishaTecho().getSelectedValues(), 障がい書控除申請.is障がい者手帳有無())
                || !isEquals(div.getChkIsNinteishoHakkoTaishoGai().getSelectedValues(), 障がい書控除申請.is認定証発行対象外フラグ())) {
            return true;
        }
        if (!isEquals(div.getDdlNinchishoKoreishaJiritsudo().getSelectedKey(), 障がい書控除申請.get認知症高齢者の日常生活自立度コード())) {
            return true;
        }
        if (!isEquals(div.getDdlShogaiKoreishaJiritsudo().getSelectedKey(), 障がい書控除申請.get障がい高齢者の日常生活自立度コード())) {
            return true;
        }
        return !div.getDdlNinteiKubun().getSelectedKey().equals(障がい書控除申請.get認定区分())
                || !div.getDdlNinteiNaiyo().getSelectedKey().equals(障がい書控除申請.get認定内容());
    }

    private boolean isEquals(RString value1, Code value2) {
        if (null == value2 || value2.isEmpty()) {
            return null == value1 || value1.isEmpty();
        } else {
            return value2.getColumnValue().equals(value1);
        }
    }

    private boolean isEquals(AtenaKanaMeisho value1, AtenaKanaMeisho value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(YubinNo value1, YubinNo value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(AtenaJusho value1, AtenaJusho value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(TelNo value1, TelNo value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(AtenaMeisho value1, AtenaMeisho value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(List<RString> selectedKeys, boolean フラグ) {
        return (selectedKeys.isEmpty() && !フラグ) || (!selectedKeys.isEmpty() && フラグ);
    }

    private boolean isEquals(FlexibleDate value1, FlexibleDate value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private boolean isEquals(RString value1, RString value2) {
        if (null == value1 || value1.isEmpty()) {
            return null == value2 || value2.isEmpty();
        } else {
            return value1.equals(value2);
        }
    }

    private void 追加処理(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, ShogaishaKoujoToJotai 画面情報) {
        if (情報と状態ArrayList.isEmpty()) {
            if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
                画面情報.set新履歴番号(1);
            } else {
                画面情報.set新履歴番号(0);
            }
            情報と状態ArrayList.add(画面情報);
            return;
        }
        int size = 情報と状態ArrayList.size();
        boolean isAdded = false;
        int 履歴番号 = 情報と状態ArrayList.get(size - 1).get新履歴番号();
        for (int index = 0; index <= size; index++) {
            if (!isAdded) {
                if (index == size) {
                    画面情報.set新履歴番号(履歴番号);
                    情報と状態ArrayList.add(画面情報);
                    continue;
                }
                ShogaishaKoujoToJotai 情報 = 情報と状態ArrayList.get(index);
                if (!画面情報.get障がい書控除申請登録情報().get申請年月日().isBeforeOrEquals(情報.get障がい書控除申請登録情報().get申請年月日())) {
                    画面情報.set新履歴番号(情報.get新履歴番号() + 1);
                    情報と状態ArrayList.add(index, 画面情報);
                    isAdded = true;
                } else {
                    情報.set新履歴番号(情報.get新履歴番号() + 1);
                }
            }
        }
    }

    private ShogaishaKoujoToJotai get情報と状態From画面(Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        ShoKisaiHokenshaNo 証記載保険者番号 = get証記載保険者番号();
        ShogaishaKoujo 情報 = new ShogaishaKoujo(証記載保険者番号, 被保険者番号, 追加履歴番号);
        ShogaishaKoujoBuilder builder = 情報.createBuilderForEdit();
        builder.set申請年月日(div.getTxtShinseiYMD().getValue());
        builder.set申請事由(div.getTxtShinseiRiyu().getValue());
        builder.setGemmenGengakuShinsei(get減免減額申請From画面(証記載保険者番号, 追加履歴番号, 被保険者番号));
        if (!申請メニュー.equals(ResponseHolder.getMenuID()) && 承認する.equals(div.getRadKettaiKubun().getSelectedKey())) {
            builder.set認知症高齢者の日常生活自立度コード(rStringToCode(div.getDdlNinchishoKoreishaJiritsudo().getSelectedKey()));
            builder.set障がい高齢者の日常生活自立度コード(rStringToCode(div.getDdlShogaiKoreishaJiritsudo().getSelectedKey()));
            builder.set認定区分(get認定区分Or認定内容Key(div.getDdlNinteiKubun().getSelectedKey()));
            builder.set認定内容(get認定区分Or認定内容Key(div.getDdlNinteiNaiyo().getSelectedKey()));
        }
        if (!申請メニュー.equals(ResponseHolder.getMenuID())) {
            builder.set決定区分(div.getRadKettaiKubun().getSelectedKey());
            builder.set決定年月日(div.getTxtKettaiYMD().getValue());
            builder.set対象年度(div.getTxtTaishoNendo().getDomain());
            if (div.getTxtKijunYMD().getValue() != null) {
                builder.set基準日(div.getTxtKijunYMD().getValue());
            }
            if (div.getTxtHaakuYMD().getValue() != null) {
                builder.set把握日(div.getTxtHaakuYMD().getValue());
            }
            builder.set障がい者手帳有無(!div.getChkHasShogaishaTecho().getSelectedKeys().isEmpty());
            builder.set認定証発行対象外フラグ(!div.getChkIsNinteishoHakkoTaishoGai().getSelectedKeys().isEmpty());
            if (承認しない.equals(div.getRadKettaiKubun().getSelectedKey())) {
                builder.set非承認理由(div.getTxtHiShoninRiyu().getValue());
                builder.set認知症高齢者の日常生活自立度コード(null);
                builder.set障がい高齢者の日常生活自立度コード(null);
                builder.set認定区分(null);
                builder.set認定内容(null);
            }
        }
        return new ShogaishaKoujoToJotai(builder.build(), 状態_追加, 追加履歴番号);
    }

    private GemmenGengakuShinsei get減免減額申請From画面(ShoKisaiHokenshaNo 証記載保険者番号, Integer 追加履歴番号, HihokenshaNo 被保険者番号) {
        GemmenGengakuShinsei 減免減額申請 = new GemmenGengakuShinsei(証記載保険者番号,
                被保険者番号, GemmenGengakuShurui.障がい者控除.getコード(), 追加履歴番号);
        GemmenGengakuShinseiBuilder builder = 減免減額申請.createBuilderForEdit();
        ShinseiJoho 減免減額申請情報 = div.getCcdGemmenGengakuShinsei().get減免減額申請情報();
        if (減免減額申請情報.get申請届出代行区分() != null) {
            builder.set申請届出代行区分(減免減額申請情報.get申請届出代行区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者氏名()) {
            builder.set申請届出者氏名(AtenaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名(減免減額申請情報.get申請届出者氏名());
        }
        if (null == 減免減額申請情報.get申請届出者氏名カナ()) {
            builder.set申請届出者氏名カナ(AtenaKanaMeisho.EMPTY);
        } else {
            builder.set申請届出者氏名カナ(減免減額申請情報.get申請届出者氏名カナ());
        }
        if (null == 減免減額申請情報.get申請届出者続柄()) {
            builder.set申請届出者続柄(RString.EMPTY);
        } else {
            builder.set申請届出者続柄(減免減額申請情報.get申請届出者続柄());
        }
        if (減免減額申請情報.get申請届出代行事業者番号() != null && !減免減額申請情報.get申請届出代行事業者番号().isEmpty()) {
            builder.set申請届出代行事業者番号(減免減額申請情報.get申請届出代行事業者番号());
        }
        if (減免減額申請情報.get事業者区分() != null) {
            builder.set事業者区分(減免減額申請情報.get事業者区分().getCode());
        }
        if (null == 減免減額申請情報.get申請届出者郵便番号()) {
            builder.set申請届出者郵便番号(YubinNo.EMPTY);
        } else {
            builder.set申請届出者郵便番号(減免減額申請情報.get申請届出者郵便番号());
        }
        if (null == 減免減額申請情報.get申請届出者住所()) {
            builder.set申請届出者住所(AtenaJusho.EMPTY);
        } else {
            builder.set申請届出者住所(減免減額申請情報.get申請届出者住所());
        }
        if (null == 減免減額申請情報.get申請届出者電話番号()) {
            builder.set申請届出者電話番号(TelNo.EMPTY);
        } else {
            builder.set申請届出者電話番号(減免減額申請情報.get申請届出者電話番号());
        }
        return builder.build();
    }

    private ShoKisaiHokenshaNo get証記載保険者番号() {
        HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        HihokenshaDaichoManager 被保険者台帳manager = new HihokenshaDaichoManager();
        HihokenshaDaicho 被保険者台帳 = 被保険者台帳manager.find最新被保険者台帳(div.getTxtShinseiYMD().getValue());
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.get広住特措置元市町村コード();
        HokenshaSummary hokenshaSummary;
        if (広住特措置元市町村コード != null && !広住特措置元市町村コード.isEmpty()) {
            hokenshaSummary = hokenshaList.get(広住特措置元市町村コード);
        } else {
            hokenshaSummary = hokenshaList.get(被保険者台帳.get市町村コード());
        }
        return hokenshaSummary.get証記載保険者番号();
    }

    /**
     * 変更有無チェック処理です。
     *
     * @return is変更
     */
    public boolean 変更有無チェック() {
        List<dgShinseiList_Row> rowList = div.getDgShinseiList().getDataSource();
        for (dgShinseiList_Row row : rowList) {
            if (!isNullOrEmpty(row.getJotai())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 対象年度重複チェック処理です。
     *
     * @return 重複
     */
    public boolean 対象年度重複チェック() {
        List<dgShinseiList_Row> rowList = div.getDgShinseiList().getDataSource();
        List<RString> 対象年度List = new ArrayList<>();
        for (dgShinseiList_Row row : rowList) {
            if (!isNullOrEmpty(row.getKetteiKubun())) {
                対象年度List.add(row.getShinseiJiyu());
            }
        }
        Set<RString> 対象年度set = new HashSet<>(対象年度List);
        return 対象年度List.size() != 対象年度set.size();
    }

    /**
     * 「申請情報を保存する」（また「承認情報を保存する」）ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void onClick_btnUpdate(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(CODE_0003, 被保険者番号_Name, 被保険者番号.getColumnValue()));
        AccessLogger.log(AccessLogType.更新, personalData);
        ShogaishaKojoTaishoshaShinseiTorokuManager.createIntance().更新処理(情報と状態ArrayList, 申請メニュー.equals(ResponseHolder.getMenuID()));
        前排他解除(被保険者番号);
        div.getCcdKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
    }

    /**
     * 申請一覧の削除ボタンを押下処理です。
     *
     * @param 情報と状態ArrayList 情報と状態ArrayList
     */
    public void onSelectByDeleteButton(ArrayList<ShogaishaKoujoToJotai> 情報と状態ArrayList) {
        dgShinseiList_Row row = div.getDgShinseiList().getActiveRow();
        RString 状態 = row.getJotai();
        ShogaishaKoujoIdentifier id
                = DataPassingConverter.deserialize(row.getDadaId(), ShogaishaKoujoIdentifier.class);
        if (状態.isEmpty() || 状態_修正.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (id.equals(情報と状態ArrayList.get(index).get障がい書控除申請登録情報().identifier())) {
                    情報と状態ArrayList.get(index).set状態(状態_削除);
                }
            }
        } else if (状態_追加.equals(状態)) {
            for (int index = 0; index < 情報と状態ArrayList.size(); index++) {
                if (id.equals(情報と状態ArrayList.get(index).get障がい書控除申請登録情報().identifier())) {
                    情報と状態ArrayList.remove(index);
                }
            }
        }
        div.getDgShinseiList().setDataSource(getDataSource(情報と状態ArrayList));
    }

}
