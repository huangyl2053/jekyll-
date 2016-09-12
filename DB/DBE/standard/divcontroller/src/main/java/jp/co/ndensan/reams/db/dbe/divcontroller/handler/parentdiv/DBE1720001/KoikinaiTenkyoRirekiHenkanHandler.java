/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1720001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkan;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.KoikinaiTenkyoRirekiHenkanDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001.dgShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBE1720001_広域内転居Handlerクラスです
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
public class KoikinaiTenkyoRirekiHenkanHandler {

    private final KoikinaiTenkyoRirekiHenkanDiv div;
    private static final int DROPDOWNLIST_BLANK = 0;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KoikinaiTenkyoRirekiHenkanHandler(KoikinaiTenkyoRirekiHenkanDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化セートセットです
     *
     */
    public void setOnLoad() {
        List<KeyValueDataSource> kunbunCode = new ArrayList<>();
        kunbunCode.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        kunbunCode.addAll(createListFromNinteiShinseiShinseijiKubunCode());
        div.getDdlShinseijiShinseiKubun().getDataSource().clear();
        div.getDdlShinseijiShinseiKubun().getDataSource().addAll(kunbunCode);
        RString 検索制御_最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTextBoxNum().setMaxValue(new Decimal(検索制御_最大取得件数上限.toString()));
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTextBoxNum().setValue(new Decimal(検索制御_最大取得件数.toString()));
    }

    /**
     * 条件をクリアするボタン処理です。
     *
     */
    public void onClick_JoukenClear() {
        List<RString> isselect = new ArrayList<>();
        isselect.clear();
        div.getTxtHihokenshaNumber().clearValue();
        div.getTxtHihokenshaNameJyouken().clearValue();
        div.getChkMinashiFlag().setSelectedItemsByKey(isselect);
        div.getTxtNinteiShinseiDateFrom().clearValue();
        div.getTxtNinteiShinseiDateTo().clearValue();
        div.getTxtBirthDateFrom().clearValue();
        div.getTxtBirthDateTo().clearValue();
        div.getDdlHihokenshaNameMatchType().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getDdlShinseijiShinseiKubun().setSelectedIndex(DROPDOWNLIST_BLANK);
        div.getChkSeibetsu().setSelectedItemsByKey(isselect);
        div.getTextBoxNum().clearValue();
        RString 検索制御_最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTextBoxNum().setValue(new Decimal(検索制御_最大取得件数.toString()));
    }

    /**
     * 申請者一覧へのデータを設定します。
     *
     * @param shinseisyaList 申請者一覧情報List
     */
    public void setShinseisyaitiran(List<KoikinaiTenkyoRirekiHenkan> shinseisyaList) {
        List<dgShinseishaIchiran_Row> dataGridList = new ArrayList<>();
        for (KoikinaiTenkyoRirekiHenkan shinseisya : shinseisyaList) {
            dataGridList.add(creatDgShinseishaIchiranRow(
                    RString.EMPTY,
                    null == shinseisya.get申請書管理番号() ? RString.EMPTY : shinseisya.get申請書管理番号().getColumnValue(),
                    shinseisya.get証記載保険者番号(),
                    shinseisya.get市町村名称(),
                    shinseisya.get被保険者番号(),
                    null == shinseisya.get被保険者氏名() ? RString.EMPTY : shinseisya.get被保険者氏名().getColumnValue(),
                    null == setSeibetsu(shinseisya.get性別()) ? RString.EMPTY : setSeibetsu(shinseisya.get性別()),
                    null == shinseisya.get生年月日() ? RString.EMPTY : new RString(shinseisya.get生年月日().toString()),
                    new RString(String.valueOf(shinseisya.get年齢())),
                    null == shinseisya.get住所() ? RString.EMPTY : new RString(shinseisya.get住所().toString()),
                    null == shinseisya.get郵便番号() ? RString.EMPTY : shinseisya.get郵便番号().getColumnValue(),
                    null == shinseisya.get電話番号() ? RString.EMPTY : shinseisya.get電話番号().getColumnValue(),
                    null == shinseisya.get認定申請年月日() ? RString.EMPTY : new RString(shinseisya.get認定申請年月日().toString()),
                    null == setNijiHanteiYokaigoJotaiKubunCode(shinseisya.get二次判定要介護状態区分コード())
                    ? RString.EMPTY : setNijiHanteiYokaigoJotaiKubunCode(shinseisya.get二次判定要介護状態区分コード()),
                    null == shinseisya.get二次判定年月日() ? RString.EMPTY : new RString(shinseisya.get二次判定年月日().toString()),
                    new RString(String.valueOf(shinseisya.get二次判定認定有効期間())),
                    null == shinseisya.get二次判定認定有効開始年月日() ? RString.EMPTY : new RString(shinseisya.get二次判定認定有効開始年月日().toString()),
                    null == shinseisya.get二次判定認定有効終了年月日() ? RString.EMPTY : new RString(shinseisya.get二次判定認定有効終了年月日().toString()),
                    null == shinseisya.get認定審査会完了年月日() ? RString.EMPTY : new RString(shinseisya.get認定審査会完了年月日().toString()),
                    shinseisya.get事業者名称(),
                    shinseisya.get調査員氏名(),
                    null == shinseisya.get認定調査依頼年月日() ? RString.EMPTY : new RString(shinseisya.get認定調査依頼年月日().toString()),
                    null == shinseisya.get認定調査実施日() ? RString.EMPTY : new RString(shinseisya.get認定調査実施日().toString()),
                    null == shinseisya.get認定調査完了年月日() ? RString.EMPTY : new RString(shinseisya.get認定調査完了年月日().toString()),
                    shinseisya.get医療機関名称(),
                    shinseisya.get主治医氏名(),
                    creatDgIchiranRow(shinseisya)));
        }
        div.getShinseishaIchiran().getDgShinseishaIchiran().getDataSource().clear();
        div.getShinseishaIchiran().getDgShinseishaIchiran().setDataSource(dataGridList);
    }

    /**
     * 「選択」ボタン処理です
     *
     * @param list List<KeyValueDataSource>
     */
    public void onClick_btnSentaku(List<KeyValueDataSource> list) {
        div.getDdlShokisaiHokenshaNoSaki().getDataSource().clear();
        dgShinseishaIchiran_Row row = div.getDgShinseishaIchiran().getActiveRow();
        div.getKoikinaiTenkyoTenkyomae().getTxtShokisaiHokenshaNo().setValue(row.getShoKisaiHokenshaNo());
        div.getTxtShokisaiHokensha().setValue(row.getShokisaiHokensha());
        div.getTxtHihokenshaNo().setValue(row.getHihokenshaNo());
        div.getTxtHihokenshaName().setValue(row.getHihokenshaName());
        div.getTxtJusho().setValue(row.getJusho());
        div.getTxtSex().setValue(row.getSex());
        if (row.getBirthYMD() != null && !row.getBirthYMD().isEmpty()) {
            div.getTxtBirthYMD().setValue(new RDate(row.getBirthYMD().toString()));
        }
        div.getTxtAge().setValue(row.getAge());
        div.getTxtTelNo().setValue(row.getTelNo());
        div.getTxtYubinNo().setValue(row.getYubinNo());
        setSentaku(row);
        List<KeyValueDataSource> shokisaihokensha = new ArrayList<>();
        shokisaihokensha.add(new KeyValueDataSource(RString.EMPTY, row.getShoKisaiHokenshaNo()));
        shokisaihokensha.addAll(list);
        div.getDdlShokisaiHokenshaNoSaki().getDataSource().clear();
        div.getDdlShokisaiHokenshaNoSaki().getDataSource().addAll(shokisaihokensha);
        div.getTxtShokisaiHokenshaSaki().setValue(row.getShokisaiHokensha());
    }

    private void setSentaku(dgShinseishaIchiran_Row row) {
        div.getTxtNijiHanteiKekka().setValue(row.getNijiHanteiKekka());
        if (row.getNijiHanteibi() != null && !row.getNijiHanteibi().isEmpty()) {
            div.getTxtNijiHanteibi().setValue(new RDate(row.getNijiHanteibi().toString()));
        }
        div.getTxtNinteiYukoKikan().setValue(row.getNijiHanteiNinteiYukoKikan());
        if (row.getNijiHanteiNinteiYukoKaishiYMD() != null && !row.getNijiHanteiNinteiYukoKaishiYMD().isEmpty()) {
            div.getTxtNinteiYukoKikanKaishiShuryo().setFromValue(new RDate(row.getNijiHanteiNinteiYukoKaishiYMD().toString()));
        }
        if (row.getNijiHanteiNinteiYukoShuryoYMD() != null && !row.getNijiHanteiNinteiYukoShuryoYMD().isEmpty()) {
            div.getTxtNinteiYukoKikanKaishiShuryo().setToValue(new RDate(row.getNijiHanteiNinteiYukoShuryoYMD().toString()));
        }
        div.getTxtNinteiChosaItakusakiMeisho().setValue(row.getChosaItakusakiMeisho());
        div.getTxtNinteiChosainName().setValue(row.getChosainName());
        div.getTxtShujiiIryoKikanMeisho().setValue(row.getShujiiIryoKikanMeisho());
        div.getTxtShujiiName().setValue(row.getShujiiName());
        div.getTxtKaigoNinteiShinsakaiNo().setValue(row.getShinsakaiNo());
        if (row.getShinsakaiKaisaibi() != null && !row.getShinsakaiKaisaibi().isEmpty()) {
            div.getTxtKaigoNinteiShinsakaiKaisabi().setValue(new RDate(row.getShinsakaiKaisaibi().toString()));
        }
    }

    /**
     * 「登録する」ボタン処理です。
     */
    public void onClick_btnTouroku() {
        dgShinseishaIchiran_Row row = div.getDgShinseishaIchiran().getActiveRow();
        if (!div.getTxtShokisaiHokenshaNo().getValue().equals(div.getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki().getSelectedValue())) {
            row.setColumnState(new RString("更新"));
            List<KeyValueDataSource> datasource = div.getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki().getDataSource();
            int index = div.getKoikinaiTenkyoTenkyosaki().getDdlShokisaiHokenshaNoSaki().getSelectedIndex();
            int position = datasource.get(index).getValue().indexOf(RString.HALF_SPACE);
            row.setShoKisaiHokenshaNo(datasource.get(index).getKey());
            row.setShokisaiHokensha(datasource.get(index).getValue().substring(position + 1));
        }
    }

    private RString setSeibetsu(Code code) {
        RString seibetsu = RString.EMPTY;
        if (null != code) {
            seibetsu = Seibetsu.toValue(code.value()).get名称();
        }
        return seibetsu;
    }

    private RString setNijiHanteiYokaigoJotaiKubunCode(Code code) {
        RString kunbuncode = RString.EMPTY;
        if (null != code) {
            kunbuncode = YokaigoJotaiKubun09.toValue(code.value()).get略称();
        }
        return kunbuncode;
    }

    private dgShinseishaIchiran_Row creatDgIchiranRow(KoikinaiTenkyoRirekiHenkan shinseisya) {
        dgShinseishaIchiran_Row row = new dgShinseishaIchiran_Row();
        if (shinseisya.get主治医意見書作成依頼年月日() == null) {
            row.setIkenshoSakuseiIraibi(RString.EMPTY);
        } else {
            row.setIkenshoSakuseiIraibi(dateFormat(shinseisya.get主治医意見書作成依頼年月日()));
        }
        if (null == shinseisya.get主治医意見書受領年月日()) {
            row.setIkenshoJuryobi(RString.EMPTY);
        } else {
            row.setIkenshoJuryobi(dateFormat(shinseisya.get主治医意見書受領年月日()));
        }
        if (null == shinseisya.get主治医意見書登録完了年月日()) {
            row.setIkenshoTorokuKanryobi(RString.EMPTY);
        } else {
            row.setIkenshoTorokuKanryobi(dateFormat(shinseisya.get主治医意見書登録完了年月日()));
        }
        row.setShinsakaiNo(shinseisya.get介護認定審査会開催番号());
        if (null == shinseisya.get介護認定審査会開催予定年月日()) {
            row.setShinsakaiKaisaiYoteibi(RString.EMPTY);
        } else {
            row.setShinsakaiKaisaiYoteibi(dateFormat(shinseisya.get介護認定審査会開催予定年月日()));
        }
        if (null == shinseisya.get介護認定審査会開催年月日()) {
            row.setShinsakaiKaisaibi(RString.EMPTY);
        } else {
            row.setShinsakaiKaisaibi(dateFormat(shinseisya.get介護認定審査会開催年月日()));
        }
        return row;
    }

    private dgShinseishaIchiran_Row creatDgShinseishaIchiranRow(
            RString columnState,
            RString shinseishoKanriNo,
            RString shoKisaiHokenshaNo,
            RString shokisaiHokensha,
            RString hihokenshaNo,
            RString hihokenshaName,
            RString sex,
            RString birthYMD,
            RString age,
            RString jusho,
            RString yubinNo,
            RString telNo,
            RString ninteiShinseiYMD,
            RString nijiHanteiKekka,
            RString nijiHanteibi,
            RString nijiHanteiNinteiYukoKikan,
            RString nijiHanteiNinteiYukoKaishiYMD,
            RString nijiHanteiNinteiYukoShuryoYMD,
            RString shinsakaiKanryobi,
            RString chosaItakusakiMeisho,
            RString chosainName,
            RString chosaIraibi,
            RString chosaJisshibi,
            RString chosaKanryobi,
            RString shujiiIryoKikanMeisho,
            RString shujiiName,
            dgShinseishaIchiran_Row row) {
        row.setColumnState(columnState);
        row.setShinseishoKanriNo(shinseishoKanriNo);
        row.setShoKisaiHokenshaNo(shoKisaiHokenshaNo);
        row.setShokisaiHokensha(shokisaiHokensha);
        row.setHihokenshaNo(hihokenshaNo);
        row.setHihokenshaName(hihokenshaName);
        row.setSex(sex);
        row.setBirthYMD(dateFormat(new FlexibleDate(birthYMD)));
        row.setAge(age);
        row.setJusho(jusho);
        row.setYubinNo(yubinNo);
        row.setTelNo(telNo);
        row.setNinteiShinseiYMD(dateFormat(new FlexibleDate(ninteiShinseiYMD)));
        row.setNijiHanteiKekka(nijiHanteiKekka);
        row.setNijiHanteibi(dateFormat(new FlexibleDate(nijiHanteibi)));
        row.setNijiHanteiNinteiYukoKikan(nijiHanteiNinteiYukoKikan);
        row.setNijiHanteiNinteiYukoKaishiYMD(dateFormat(new FlexibleDate(nijiHanteiNinteiYukoKaishiYMD)));
        row.setNijiHanteiNinteiYukoShuryoYMD(dateFormat(new FlexibleDate(nijiHanteiNinteiYukoShuryoYMD)));
        row.setShinsakaiKanryobi(dateFormat(new FlexibleDate(shinsakaiKanryobi)));
        row.setChosaItakusakiMeisho(chosaItakusakiMeisho);
        row.setChosainName(chosainName);
        row.setChosaIraibi(dateFormat(new FlexibleDate(chosaIraibi)));
        row.setChosaJisshibi(dateFormat(new FlexibleDate(chosaJisshibi)));
        row.setChosaKanryobi(dateFormat(new FlexibleDate(chosaKanryobi)));
        row.setShujiiIryoKikanMeisho(shujiiIryoKikanMeisho);
        row.setShujiiName(shujiiName);
        return row;
    }

    private List<KeyValueDataSource> createListFromNinteiShinseiShinseijiKubunCode() {
        List<KeyValueDataSource> list = new ArrayList<>();
        for (NinteiShinseiShinseijiKubunCode code : NinteiShinseiShinseijiKubunCode.values()) {
            NinteiShinseiShinseijiKubunCode kubuncode = NinteiShinseiShinseijiKubunCode.toValue(code.getコード());
            KeyValueDataSource dataSource = new KeyValueDataSource(kubuncode.getコード(), kubuncode.get名称());
            list.add(dataSource);
        }
        return list;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
