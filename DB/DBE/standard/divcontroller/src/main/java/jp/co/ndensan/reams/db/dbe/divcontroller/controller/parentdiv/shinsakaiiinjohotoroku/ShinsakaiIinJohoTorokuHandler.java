package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.shinsakaiiinjohotoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranEntity;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShinsakaiIinJohoToroku のクラスファイル 介護認定審査会委員情報を登録・修正・削除する機能、 削除の場合は論理削除を行う。
 */
public class ShinsakaiIinJohoTorokuHandler {

    private final ShinsakaiIinJohoTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public ShinsakaiIinJohoTorokuHandler(ShinsakaiIinJohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化、画面項目に設定されている値をクリアする
     */
    public void load() {
        kensakuJokenDiv_init(new RString("key1"));
        shinsakaiIinJohoIchiranDiv_init();
        shinsakaiIinJohoDiv_init();
        shozokuKikanIchiranDiv_init();
        renrakusakiKinyuKikanDiv_init();
        div.getBtnToroku().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
    }

    /**
     * 審査会委員情報で審査会委員一覧情報をセットする。
     *
     * @param list List<ShinsakaiIinJoho>
     * @return リストdgShinsaInJohoIchiran_Row
     */
    public List<dgShinsaInJohoIchiran_Row> setShinsaInJohoIchiranDiv(List<ShinsakaiIinJoho> list) {
        List<dgShinsaInJohoIchiran_Row> dgShinsaInJohoIchiran_Row = new ArrayList<>();
        for (ShinsakaiIinJoho shinsakaiIinJoho : list) {
            dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
            row.setStatus(RString.EMPTY);
            row.setShinsainCode(shinsakaiIinJoho.get介護認定審査会委員コード());
            row.getShinsakaiIinKaishiYMD().setValue(shinsakaiIinJoho.get介護認定審査会委員開始年月日().toRDate());
            row.getShinsakaiIinShuryoYMD().setValue(shinsakaiIinJoho.get介護認定審査会委員開始年月日().toRDate());
            row.setShimei(shinsakaiIinJoho.get介護認定審査会委員氏名().value());
            row.setKanaShimei(shinsakaiIinJoho.get介護認定審査会委員氏名カナ().value());
            row.setSeibetsu(shinsakaiIinJoho.get性別());
            row.getBarthYMD().setValue(shinsakaiIinJoho.get生年月日().toRDate());
            row.setShikakuCode(shinsakaiIinJoho.get介護認定審査員資格コード().value());
            row.setBiko(shinsakaiIinJoho.get備考());
            row.setJokyo(shinsakaiIinJoho.get住所().value());
            dgShinsaInJohoIchiran_Row.add(row);
        }
        return dgShinsaInJohoIchiran_Row;
    }

    /**
     * 所属機関情報で所属機関一覧をセットする。
     *
     * @param list
     * @return dgShozokuKikanIchiran_Row
     */
    public List<dgShozokuKikanIchiran_Row> setShozokuKikanIchiranDiv(List<ShozokuKikanIchiranEntity> list) {
        List<dgShozokuKikanIchiran_Row> dgShozokuKikanIchiran_Row = new ArrayList<>();
        for (ShozokuKikanIchiranEntity entity : list) {
            dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
            row.getNinteiItakusakiCode().setValue(entity.getNinteichosaItakusakiCode());
            row.getNinteiChosaItakusakiName().setValue(entity.getNinteichosaItakusakiMeisho());
            row.getShujiiIryoKikanCode().setValue(entity.getShujiiIryokikanCode());
            row.getShujiiIryoKikanName().setValue(entity.getShujiiIryokikanMeisho());
            row.getSonotaKikanCode().setValue(entity.getSonotaKikanCode());
            row.getSonotaKikanName().setValue(entity.getSonotaKikanMeisho());
            dgShozokuKikanIchiran_Row.add(row);
        }
        return dgShozokuKikanIchiran_Row;
    }

    /**
     * 審査会委員一覧から、審査会委員詳細情報をセットする。
     */
    public void setDivShinsakaiIinJoho() {
        div.getShinsakaiIinJoho().getTxtShinsainCode().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode());
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiIinKaishiYMD().getValue());
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiIinShuryoYMD().getValue());
        div.getShinsakaiIinJoho().getTxtShimei().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShimei());
        div.getShinsakaiIinJoho().getTxtKanaShimei().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getKanaShimei());
        div.getShinsakaiIinJoho().getTxtBirthYMD().setValue(
                new FlexibleDate(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getBarthYMD().toString()));
        div.getShinsakaiIinJoho().getRadSeibetsu().setSelectedKey(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getSeibetsu());
        div.getShinsakaiIinJoho().getDdlShikakuCode().setSelectedKey(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getShikakuCode());
        // TODO 地区コード
        div.getShinsakaiIinJoho().getTxtBiko().setValue(
                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getBiko());
    }

    /**
     * 審査会委員一覧から、連絡先/金融機関情報をセットする。
     */
    public void setDivRenrakusakiKinyuKikan() {
//        div.getRenrakusakiKinyuKikan().getTxtYubinNo().setValue(
//                new YubinNo(div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getYubinNo()));
//        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setSelectedKey(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getYusoKubun());
//        div.getRenrakusakiKinyuKikan().getTxtJusho().setDomain(new AtenaJusho(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getJusho()));
//        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().setValue(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getJokyo());
//        div.getRenrakusakiKinyuKikan().setTxtHaishiYMD(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getHaishiYMD());
//        div.getRenrakusakiKinyuKikan().getTxtTelNo1().setDomain(new TelNo(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getTelNo()));
//        div.getRenrakusakiKinyuKikan().getTxtFaxNo().setDomain(new TelNo(
//                div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getClickedItem().getFaxNo()));

    }

    /**
     * 審査会委員一覧Gridの「修正」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態変化_修正ボタン() {
        div.getShinsakaiIinJohoIchiran().getBtnShinsakaiIinAdd().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShimei().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtKanaShimei().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtBirthYMD().setDisabled(false);
        div.getShinsakaiIinJoho().getRadSeibetsu().setDisabled(false);
        div.getShinsakaiIinJoho().getDdlShikakuCode().setDisabled(false);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtBiko().setDisabled(false);
        div.getShozokuKikanIchiran().getBtnShozokuKikanAdd().setDisabled(false);
        div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtYubinNo().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtJusho().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtTelNo1().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtFaxNo().setDisabled(false);
        div.getBtnToroku().setDisabled(false);
        div.getBtnDelete().setDisabled(false);
    }

    /**
     * 「審査会委員を追加する」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態変化_追加ボタン() {
        div.getShinsakaiIinJoho().getTxtShinsainCode().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtShimei().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtKanaShimei().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtBirthYMD().setDisabled(false);
        div.getShinsakaiIinJoho().getRadSeibetsu().setDisabled(false);
        div.getShinsakaiIinJoho().getDdlShikakuCode().setDisabled(false);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().setDisabled(false);
        div.getShinsakaiIinJoho().getTxtBiko().setDisabled(false);
        div.getShozokuKikanIchiran().getBtnShozokuKikanAdd().setDisabled(false);
        div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtYubinNo().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtJusho().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtTelNo1().setDisabled(false);
        div.getRenrakusakiKinyuKikan().getTxtFaxNo().setDisabled(false);
        div.getBtnToroku().setDisabled(false);
        div.getShinsakaiIinJohoIchiran().getBtnShinsakaiIinAdd().setDisabled(true);
    }

    /**
     * 審査会委員情報詳細エリアをクリアする
     */
    public void clear審査会委員詳細情報() {
        div.getShinsakaiIinJoho().getTxtShinsainCode().clearValue();
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().clearValue();
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().clearValue();
        div.getShinsakaiIinJoho().getTxtShimei().clearValue();
        div.getShinsakaiIinJoho().getTxtKanaShimei().clearValue();
        div.getShinsakaiIinJoho().getTxtBirthYMD().clearValue();
        div.getShinsakaiIinJoho().getRadSeibetsu().setSelectedKey(new RString("0"));
        div.getShinsakaiIinJoho().getDdlShikakuCode().setSelectedIndex(0);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().clear();
        div.getShinsakaiIinJoho().getTxtBiko().clearValue();
    }

    /**
     * 連絡先/金融機関エリアをクリアする
     */
    public void clear連絡先金融機関() {
        div.getRenrakusakiKinyuKikan().getTxtYubinNo().clearValue();
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setSelectedIndex(0);
        div.getRenrakusakiKinyuKikan().getTxtJusho().clearDomain();
        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().clearValue();
        div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().clearValue();
        div.getRenrakusakiKinyuKikan().getTxtTelNo1().clearDomain();
        div.getRenrakusakiKinyuKikan().getTxtFaxNo().clearDomain();
    }

    /**
     * 審査会委員詳細情報入力されだ審査会委員コードが重複コードを判断する。
     *
     * @return　boolean
     */
    public boolean is重複コード() {
        for (dgShinsaInJohoIchiran_Row row : div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource()) {
            if (div.getShinsakaiIinJoho().getTxtShinsainCode().getValue().equals(row.getShinsainCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 審査会委員詳細情報変更を判断します。
     *
     * 。
     *
     * @return　boolean
     */
    public boolean hasChanged合議体詳細情報() {
        for (dgShinsaInJohoIchiran_Row row : div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource()) {
            if (div.getShinsakaiIinJoho().getTxtShinsainCode().getValue().equals(row.getShinsainCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 「入力内容を更新する」ボタン押下、入力明細エリアの入力内容を審査会委員一覧に反映させる。
     *
     * @return リスト
     */
    public List<dgShinsaInJohoIchiran_Row> set審査会委員詳細To委員一覧() {
        List<dgShinsaInJohoIchiran_Row> list = div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource();
        int count = div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getGridSetting().selectedRowCount();
        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        row.setShinsainCode(div.getShinsakaiIinJoho().getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getShinsakaiIinJoho().getTxtShimei().getValue());
        row.setKanaShimei(div.getShinsakaiIinJoho().getTxtKanaShimei().getValue());
        row.setSeibetsu(div.getShinsakaiIinJoho().getRadSeibetsu().getSelectedValue());
        row.getBarthYMD().setValue(div.getShinsakaiIinJoho().getTxtBirthYMD().getValue().toRDate());
        row.setShikakuCode(div.getShinsakaiIinJoho().getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getShinsakaiIinJoho().getTxtBiko().getValue());
        row.setJokyo(div.getTxtHaishiFlag().getValue());
//        row.setYubinNo(div.getRenrakusakiKinyuKikan().getTxtYubinNo().getValue().value());
//        row.setYusoKubun(div.getRenrakusakiKinyuKikan().getDdlYusoKubun().getSelectedValue());
//        row.setJusho(div.getRenrakusakiKinyuKikan().getTxtJusho().getDomain().value());
//        row.getHaishiYMD().setValue(div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().getValue());
//        row.setTelNo(div.getRenrakusakiKinyuKikan().getTxtTelNo1().getDomain().value());
//        row.setFaxNo(div.getRenrakusakiKinyuKikan().getTxtFaxNo().getDomain().value());
        // TODO 新規モード
        if (new RString("新規").equals(new RString("新規"))) {
            row.setStatus(new RString("追加"));
            list.add(row);
            // TODO 更新モード
        } else if (new RString("更新").equals(new RString("更新"))) {
            row.setStatus(new RString("修正"));
            list.set(count, row);
        }
        return list;
    }

    /**
     * 画面で格納される審査会委員情報はＤＢ格納用型に転換します。
     *
     * @return リスト
     */
    public List<dgShinsaInJohoIchiran_Row> set審査会委員一覧情報ToService() {
        for (dgShinsaInJohoIchiran_Row row : div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().getDataSource()) {
            ShinsakaiIinJohoBuilder builder = new ShinsakaiIinJoho(row.getShinsainCode()).createBuilderForEdit();

//            builder.setKaigoNinteiShinsakaiIinShozokuKikanJoho(new());
            row.getStatus();
        };
        return null;
    }

    /**
     * 表示条件をselectedKeyでセットする。
     *
     * @param selectedKey
     */
    public void kensakuJokenDiv_init(RString selectedKey) {
        div.getKensakuJoken().getRadHyojiJoken().setSelectedKey(selectedKey);
    }

    /**
     * 審査会委員一覧情報は初期状態にセットする。
     */
    private void shinsakaiIinJohoIchiranDiv_init() {
        List<dgShinsaInJohoIchiran_Row> list = new ArrayList<>();
        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        row.setStatus(RString.EMPTY);
        row.setShinsainCode(RString.EMPTY);
        row.getShinsakaiIinKaishiYMD().clearValue();
        row.getShinsakaiIinShuryoYMD().clearValue();
        row.setShimei(RString.EMPTY);
        row.setKanaShimei(RString.EMPTY);
        row.setSeibetsu(RString.EMPTY);
        row.getBarthYMD().clearValue();
        row.setShikakuCode(RString.EMPTY);
        row.setBiko(RString.EMPTY);
        row.setJokyo(RString.EMPTY);
        list.add(row);
        div.getShinsakaiIinJohoIchiran().getDgShinsaInJohoIchiran().setDataSource(list);
    }

    /**
     * 審査会委員詳細情報は初期状態にセットする。
     */
    public void shinsakaiIinJohoDiv_init() {
        div.getShinsakaiIinJoho().getTxtShinsainCode().setValue(RString.EMPTY);
        div.getShinsakaiIinJoho().getTxtShinsainCode().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().clearValue();
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDFrom().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().clearValue();
        div.getShinsakaiIinJoho().getTxtShinsaIinYMDTo().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtShimei().setValue(RString.EMPTY);
        div.getShinsakaiIinJoho().getTxtShimei().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtKanaShimei().setValue(RString.EMPTY);
        div.getShinsakaiIinJoho().getTxtKanaShimei().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtBirthYMD().clearValue();
        div.getShinsakaiIinJoho().getTxtBirthYMD().setDisabled(true);
        div.getShinsakaiIinJoho().getRadSeibetsu().setSelectedKey(new RString("0"));
        div.getShinsakaiIinJoho().getRadSeibetsu().setDisabled(true);
        div.getShinsakaiIinJoho().getDdlShikakuCode().setSelectedIndex(0);
        div.getShinsakaiIinJoho().getDdlShikakuCode().setDisabled(true);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().setCodeWidth(CodeInputDiv.CodeWidth.XS);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().setCodeMeishoWidth(CodeInputDiv.CodeMeishoWidth.XS);
        div.getShinsakaiIinJoho().getCcdshinsakaiChikuCode().setDisabled(true);
        div.getShinsakaiIinJoho().getTxtBiko().setValue(RString.EMPTY);
        div.getShinsakaiIinJoho().getTxtBiko().setDisabled(true);
    }

    /**
     * 所属機関一覧情報は初期状態にセットする。
     */
    public void shozokuKikanIchiranDiv_init() {
        div.getShozokuKikanIchiran().getBtnShozokuKikanAdd().setDisabled(true);
        List<dgShozokuKikanIchiran_Row> list = new ArrayList<>();
        dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
        row.getDeleteButton().setDisabled(true);
        row.getNinteiItakusakiCode().setValue(RString.EMPTY);
        row.getNinteiItakusakiCode().setDisabled(true);
        row.getNiteiChosaItakusakiGuide().setDisabled(true);
        row.getNinteiChosaItakusakiName().setValue(RString.EMPTY);
        row.getNinteiChosaItakusakiName().setDisabled(true);
        row.getShujiiIryoKikanCode().setValue(RString.EMPTY);
        row.getShujiiIryoKikanCode().setDisabled(true);
        row.getShujiiIryoKikanGuide().setDisabled(true);
        row.getShujiiIryoKikanName().setValue(RString.EMPTY);
        row.getShujiiIryoKikanName().setDisabled(true);
        row.getSonotaKikanCode().setValue(RString.EMPTY);
        row.getShujiiIryoKikanCode().setDisabled(true);
        row.getSonotaKikanGuide().setDisabled(true);
        row.getSonotaKikanName().setValue(RString.EMPTY);
        row.getSonotaKikanName().setDisabled(true);
        list.add(row);
        div.getShozokuKikanIchiran().getDgShozokuKikanIchiran().setDataSource(list);
    }

    /**
     * 連絡先/金融機関情報は初期状態にセットする。
     */
    public void renrakusakiKinyuKikanDiv_init() {
        div.getRenrakusakiKinyuKikan().getTxtYubinNo().setValue(YubinNo.EMPTY);
        div.getRenrakusakiKinyuKikan().getTxtYubinNo().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setSelectedIndex(0);
        div.getRenrakusakiKinyuKikan().getDdlYusoKubun().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getTxtJusho().clearDomain();
        div.getRenrakusakiKinyuKikan().getTxtJusho().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().setValue(new RString("有効"));
        div.getRenrakusakiKinyuKikan().getTxtHaishiFlag().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().clearValue();
        div.getRenrakusakiKinyuKikan().getTxtHaishiYMD().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getTxtTelNo1().clearDomain();
        div.getRenrakusakiKinyuKikan().getTxtTelNo1().setDisabled(true);
        div.getRenrakusakiKinyuKikan().getTxtFaxNo().clearDomain();
        div.getRenrakusakiKinyuKikan().getTxtFaxNo().setDisabled(true);
    }

}
