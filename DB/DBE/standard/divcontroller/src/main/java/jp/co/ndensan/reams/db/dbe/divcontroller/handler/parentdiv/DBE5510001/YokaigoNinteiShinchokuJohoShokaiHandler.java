/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5510001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.YokaigoNinteiShinchokuJohoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5510001.dgShinseiJoho_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 要介護認定進捗状況照会のハンドラークラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
public class YokaigoNinteiShinchokuJohoShokaiHandler {

    private static final List<RString> CHK_BOX_NASI = Collections.emptyList();
    private static final RString DATE_SOURCE_KEY0 = new RString("key0");
    private static final RString DATE_SOURCE_KEY1 = new RString("key1");

    private enum KensakuHoho {

        被保険者から検索する場合(DATE_SOURCE_KEY0, "330px"),
        進捗状況から検索する場合(DATE_SOURCE_KEY1, "330px");

        private final RString key;
        private final RString dgShinseiJohoHeigh;

        private KensakuHoho(RString key, String dgShinseiJohoHeight) {
            this.key = key;
            this.dgShinseiJohoHeigh = new RString(dgShinseiJohoHeight);
        }
    }
    private final YokaigoNinteiShinchokuJohoShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public YokaigoNinteiShinchokuJohoShokaiHandler(YokaigoNinteiShinchokuJohoShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onload() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getRadKensakuHoho().setSelectedKey(KensakuHoho.被保険者から検索する場合.key);
        div.getShinseiJohoIchiran().setIsOpen(false);
        div.getDgShinseiJoho().setHeight(KensakuHoho.被保険者から検索する場合.dgShinseiJohoHeigh);
        div.getDdlNameMatchType().setSelectedKey(DATE_SOURCE_KEY0);
        div.getRadHizukeHani().setSelectedKey(DATE_SOURCE_KEY0);
        div.getTxtShiteiHizukeRange().setDisabled(true);
        div.getSerchFromHohokensha().setDisplayNone(false);
        div.getSerchFromShinchokuJokyo().setDisplayNone(true);
        init最大表示件数();
        setDisable();
    }

    /**
     * 最大表示件数を初期化します。業務コンフィグからデフォルト値を取得して設定します。
     */
    public void init最大表示件数() {
        div.getTxtMaximumDisplayNumber().setValue(DbBusinessConfig.get(ConfigNameDBE.データ出力件数閾値, new RDate("20000401"),
                SubGyomuCode.DBE認定支援, new LasdecCode("000000"), new RString("データ出力件数閾値")));
    }

    /**
     * 検索する場合、選択変更します。
     */
    public void radKensakuHohoChange() {
        switch (get検索方法()) {
            case 進捗状況から検索する場合:
                div.getSerchFromHohokensha().setDisplayNone(true);
                div.getSerchFromShinchokuJokyo().setDisplayNone(false);
                div.getSerchFromShinchokuJokyo().setIsOpen(true);
                div.getDgShinseiJoho().setHeight(KensakuHoho.進捗状況から検索する場合.dgShinseiJohoHeigh);
                return;
            case 被保険者から検索する場合:
                div.getSerchFromHohokensha().setDisplayNone(false);
                div.getSerchFromHohokensha().setIsOpen(true);
                div.getSerchFromShinchokuJokyo().setDisplayNone(true);
                div.getDgShinseiJoho().setHeight(KensakuHoho.被保険者から検索する場合.dgShinseiJohoHeigh);
        }
    }

    public KensakuHoho get検索方法() {
        if (KensakuHoho.進捗状況から検索する場合.key.equals(div.getRadKensakuHoho().getSelectedKey())) {
            return KensakuHoho.進捗状況から検索する場合;
        }
        return KensakuHoho.被保険者から検索する場合;
    }

    /**
     * 日付範囲、選択変更します。
     */
    public void radHizukeHaniChange() {
        if (DATE_SOURCE_KEY0.equals(div.getRadHizukeHani().getSelectedKey())) {
            div.getTxtShiteiHizukeRange().setDisabled(true);
            div.getTxtShiteiHizukeRange().clearFromValue();
            div.getTxtShiteiHizukeRange().clearToValue();
        } else {
            div.getTxtShiteiHizukeRange().setDisabled(false);
        }
    }

    /**
     * 条件をクリアするボタン押下します。
     */
    public void btnConditionClear() {
        clearBotton();
    }

    /**
     * 「検索する」ボタン押下します。
     *
     * @param serchResult 要介護認定進捗状況照会情報
     */
    public void btnKensaku(SearchResult<YokaigoNinteiShinchokuJoho> searchResult) {
        div.getDgShinseiJoho().getDataSource().clear();
        List<dgShinseiJoho_Row> dg_row = new ArrayList<>();
        if (searchResult.records().isEmpty()) {
            return;
        }
        for (YokaigoNinteiShinchokuJoho joho : searchResult.records()) {
            dg_row.add(setRow(joho));
        }
        div.getDgShinseiJoho().setDataSource(dg_row);
        div.getDgShinseiJoho().getGridSetting().setLimitRowCount(get最大取得件数());
        div.getDgShinseiJoho().getGridSetting().setSelectedRowCount(searchResult.totalCount());
    }

    private int get最大取得件数() {
        RString value = div.getTxtMaximumDisplayNumber().getValue();
        return value == null || value.isEmpty() ? -1 : Integer.parseInt(value.toString());
    }

    /**
     * 帳票印刷用パラメータを設定します。
     *
     * @return List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem>
     */
    public List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> createBodyItem() {
        return bodyItem();
    }

    private List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItem() {
        List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> list = new ArrayList<>();
        List<dgShinseiJoho_Row> dg_row = div.getDgShinseiJoho().getDataSource();
        for (int i = 0; i < dg_row.size(); i++) {
            dgShinseiJoho_Row row = dg_row.get(i);
            NiteiGyomuShinchokuJokyoIchiranhyoBodyItem item = new NiteiGyomuShinchokuJokyoIchiranhyoBodyItem(
                    row.getChosaIrai(),
                    row.getShujiiIkenshoIrai(),
                    row.getChosaJisshi(),
                    row.getShujiiIkenshoJuryo(),
                    row.getIchijiHantei(),
                    row.getShinsakaiWaritsuke(),
                    row.getShinsakaiJisshi(),
                    row.getHokensha(),
                    row.getShinseiDay().getValue() == null ? RString.EMPTY : row.getShinseiDay().getValue().toDateString(),
                    row.getShimei(),
                    row.getHihokenshaBirthDay().getValue() == null ? RString.EMPTY : row.getHihokenshaBirthDay().getValue().toDateString(),
                    row.getHihokenshaSeibetsu(),
                    row.getHihokenshaNo(),
                    row.getNinteiChosaItakusaki(),
                    row.getNinteiChosain(),
                    row.getKaigoNinteiShinsakaiYoteiDay().getValue() == null ? RString.EMPTY : row.getKaigoNinteiShinsakaiYoteiDay().getValue().toDateString(),
                    row.getHihokenshaJusho(),
                    row.getShujiiIryoKikan(),
                    row.getShujiiName());
            list.add(item);
        }
        return list;
    }

    private dgShinseiJoho_Row setRow(YokaigoNinteiShinchokuJoho joho) {
        dgShinseiJoho_Row row = new dgShinseiJoho_Row();
        row.setHokensha(nullToEmpty(joho.get市町村名称()));
        row.setHihokenshaNo(joho.get被保険者番号() == null ? RString.EMPTY : joho.get被保険者番号().getColumnValue());
        row.setShimei(nullToEmpty(joho.get被保険者氏名()));
        row.setHihoKubun(HihokenshaKubunCode.to名称OrDefault(joho.get被保険者区分コード(), RString.EMPTY));
        if (joho.get認定申請年月日() == null || joho.get認定申請年月日().isEmpty()) {
            row.setShinseiDay(new TextBoxDate());
        } else {
            row.getShinseiDay().setValue(new RDate(joho.get認定申請年月日().toString()));
        }
        row.setShinseiKubun(NinteiShinseiShinseijiKubunCode.to名称OrDefault(joho.get認定申請区分申請時コード(), RString.EMPTY));
        row.setChosaIrai(flexibleDateToRString(joho.get認定調査依頼完了年月日()));
        row.setChosaJisshi(flexibleDateToRString(joho.get認定調査完了年月日()));
        row.setChosaTokki(nullToEmpty(joho.get認定調査特記()));
        row.setShujiiIkenshoIrai(flexibleDateToRString(joho.get主治医意見書作成依頼完了年月日()));
        row.setShujiiIkenshoJuryo(flexibleDateToRString(joho.get主治医意見書登録完了年月日()));
        row.setIchijiHantei(flexibleDateToRString(joho.get要介護認定一次判定完了年月日()));
        row.setMaskingKanryo(flexibleDateToRString(joho.getマスキング完了年月日()));
        row.setShinsakaiWaritsuke(flexibleDateToRString(joho.get認定審査会割当完了年月日()));
        row.setShinsakaiJisshi(flexibleDateToRString(joho.get認定審査会完了年月日()));
        if (joho.get認定調査依頼年月日() == null || joho.get認定調査依頼年月日().isEmpty()) {
            row.setNinteiChosaIraiDay(new TextBoxDate());
        } else {
            row.getNinteiChosaIraiDay().setValue(flexibleDateToRDate(joho.get認定調査依頼年月日()));
        }
        if (joho.get認定調査受領年月日() == null || joho.get認定調査受領年月日().isEmpty()) {
            row.setNinteiChosaJuryoDay(new TextBoxDate());
        } else {
            row.getNinteiChosaJuryoDay().setValue(flexibleDateToRDate(joho.get認定調査受領年月日()));
        }
        row.setNinteiChosaItakusaki(nullToEmpty(joho.get事業者名称()));
        row.setNinteiChosain(nullToEmpty(joho.get調査員氏名()));
        if (joho.get主治医意見書作成依頼年月日() == null || joho.get主治医意見書作成依頼年月日().isEmpty()) {
            row.setShujiiIkenshoIraiDay(new TextBoxDate());
        } else {
            row.getShujiiIkenshoIraiDay().setValue(flexibleDateToRDate(joho.get主治医意見書作成依頼年月日()));
        }
        if (joho.get主治医意見書受領年月日() == null || joho.get主治医意見書受領年月日().isEmpty()) {
            row.setShujiiJuryoDay(new TextBoxDate());
        } else {
            row.getShujiiJuryoDay().setValue(flexibleDateToRDate(joho.get主治医意見書受領年月日()));
        }
        row.setShujiiIryoKikan(nullToEmpty(joho.get医療機関名称()));
        row.setShujiiName(nullToEmpty(joho.get主治医氏名()));
        if (joho.get要介護認定一次判定年月日() == null || joho.get要介護認定一次判定年月日().isEmpty()) {
            row.setIchijiHanteiDay(new TextBoxDate());
        } else {
            row.getIchijiHanteiDay().setValue(flexibleDateToRDate(joho.get要介護認定一次判定年月日()));
        }
        if (joho.get要介護認定一次判定完了年月日() == null || joho.get要介護認定一次判定完了年月日().isEmpty()) {
            row.setIchijiHanteiKanryouDay(new TextBoxDate());
        } else {
            row.getIchijiHanteiKanryouDay().setValue(flexibleDateToRDate(joho.get要介護認定一次判定完了年月日()));
        }
        row.setIchijiHanteiKekka(joho.get要介護認定一次判定結果コード() == null ? RString.EMPTY : IchijiHanteiKekkaCode09.toValue(nullToEmpty(joho.get要介護認定一次判定結果コード())).get名称());
        if (joho.get認定審査会割当完了年月日() == null || joho.get認定審査会割当完了年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiWaritsukeDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiWaritsukeDay().setValue(flexibleDateToRDate(joho.get認定審査会割当完了年月日()));
        }
        setRow_bak(joho, row);
        row.setShinseishoKanriNo(nullToEmpty(joho.get申請書管理番号()));
        return row;
    }

    private void setRow_bak(YokaigoNinteiShinchokuJoho joho, dgShinseiJoho_Row row) {
        row.setKaigoNinteiShinsakaiShiryo(joho.get介護認定審査会資料作成年月日() == null ? RString.EMPTY : joho
                .get介護認定審査会資料作成年月日().wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString());
        if (joho.get介護認定審査会開催予定年月日() == null || joho.get介護認定審査会開催予定年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiYoteiDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiYoteiDay().setValue(flexibleDateToRDate(joho.get介護認定審査会開催予定年月日()));
        }
        if (joho.get介護認定審査会開催年月日() == null || joho.get介護認定審査会開催年月日().isEmpty()) {
            row.setKaigoNinteiShinsakaiKaisaiDay(new TextBoxDate());
        } else {
            row.getKaigoNinteiShinsakaiKaisaiDay().setValue(flexibleDateToRDate(joho.get介護認定審査会開催年月日()));
        }
        row.setKaigoNinteiShinsakaiKaisaiNo(nullToEmpty(joho.get介護認定審査会開催番号()));
        row.setKaigoNinteiShinsakaiGogitai(new RString(String.valueOf(joho.get合議体名())));
        IYokaigoJotaiKubun yokaigodo = YokaigoJotaiKubunSupport.toValueOrEmpty(joho.get二次判定要介護状態区分コード());
        row.setKaigoNinteiShinsakaiYokaigodo(yokaigodo.getCode().equals(new RString("99")) ? RString.EMPTY : yokaigodo.getName());
        row.setHihokenshaYubinNo(new YubinNo(nullToEmpty(joho.get郵便番号())).getEditedYubinNo());
        row.setHihokenshaJusho(nullToEmpty(joho.get住所()));
        row.setHihokenshaSeibetsu(Seibetsu.toValue(joho.get性別()).get名称());
        if (joho.get生年月日() == null || joho.get生年月日().isEmpty()) {
            row.setHihokenshaBirthDay(new TextBoxDate());
        } else {
            row.getHihokenshaBirthDay().setValue(flexibleDateToRDate(joho.get生年月日()));
        }
        row.setHihokenshaNenrei(joho.get年齢() == 0 ? RString.EMPTY : new RString(String.valueOf(joho.get年齢())));
    }

    private RString flexibleDateToRString(FlexibleDate date) {
        if (date != null && !date.isEmpty()) {
            return new RString("●");
        }
        return RString.EMPTY;
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        return new RDate(date.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString().toString());
    }

    private RString nullToEmpty(Object obj) {
        return obj == null ? RString.EMPTY : new RString(obj.toString());
    }

    private void setDisable() {
        div.getDgShinseiJoho().getGridSetting().getColumn("shinseiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ninteiChosaIraiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ninteiChosaJuryoDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("shujiiIkenshoIraiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("shujiiJuryoDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ichijiHanteiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("ichijiHanteiKanryouDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiWaritsukeDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiYoteiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("kaigoNinteiShinsakaiKaisaiDay").getCellDetails().setDisabled(true);
        div.getDgShinseiJoho().getGridSetting().getColumn("hihokenshaBirthDay").getCellDetails().setDisabled(true);
    }

    private void clearBotton() {
        onload();
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtShikibetsuCode().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtShiteiHizukeRange().clearFromValue();
        div.getTxtShiteiHizukeRange().clearToValue();
        div.getChkNinteiChosaIrai().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkNinteiChosaJisshi().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkNinteiChosaTokki().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShujiiIkenshoIrai().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShujiiIkenshoJuryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkIchijiHanteiKanryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkMaskingKanryo().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShinsakaiWaritsuke().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkShinsakaiJisshi().setSelectedItemsByKey(CHK_BOX_NASI);
        div.getChkKensakuOption().setSelectedItemsByKey(CHK_BOX_NASI);
        init最大表示件数();

        boolean is被保険者から検索 = (get検索方法() == KensakuHoho.被保険者から検索する場合);
        div.getSerchFromHohokensha().setDisplayNone(is被保険者から検索);
        div.getSerchFromShinchokuJokyo().setDisplayNone(!is被保険者から検索);
        div.getShinseiJohoIchiran().setIsOpen(false);
    }
}
