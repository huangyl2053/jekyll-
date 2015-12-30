package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IsHaishi;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.Sikaku;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
     * @param list 審査会委員情報
     * @return List<dgShinsaInJohoIchiran_Row>
     */
    public List<dgShinsaInJohoIchiran_Row> setShinsaInJohoIchiranDiv(List<ShinsakaiIinJoho> list) {
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧 = new ArrayList<>();
        for (ShinsakaiIinJoho shinsakaiIinJoho : list) {
            dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
            row.setStatus(RString.EMPTY);
            row.setShinsainCode(shinsakaiIinJoho.get介護認定審査会委員コード());
            row.getShinsakaiIinKaishiYMD().setValue(new RDate(shinsakaiIinJoho.get介護認定審査会委員開始年月日().toString()));
            row.getShinsakaiIinShuryoYMD().setValue(new RDate(shinsakaiIinJoho.get介護認定審査会委員開始年月日().toString()));
            row.setShimei(shinsakaiIinJoho.get介護認定審査会委員氏名().value());
            row.setKanaShimei(shinsakaiIinJoho.get介護認定審査会委員氏名カナ().value());
            row.setSeibetsu(Seibetsu.toValue(shinsakaiIinJoho.get性別()).get名称());
            row.getBarthYMD().setValue(new RDate(shinsakaiIinJoho.get生年月日().toString()));
            row.setShikakuCode(Sikaku.toValue(shinsakaiIinJoho.get介護認定審査員資格コード().value()).get名称());
            row.setBiko(shinsakaiIinJoho.get備考());
            row.setJokyo(IsHaishi.toValue(shinsakaiIinJoho.get廃止フラグ()).get名称());
            row.setShinsakaiChikuCode(shinsakaiIinJoho.get担当地区コード().value());
            row.setYubinNo(shinsakaiIinJoho.get郵便番号().value());
            row.setYusoKubun(shinsakaiIinJoho.get審査員郵送区分());
            row.setJusho(shinsakaiIinJoho.get住所().value());
            row.getHaishiYMD().setValue(new RDate(shinsakaiIinJoho.get廃止年月日().toString()));
            row.setTelNo1(shinsakaiIinJoho.get電話番号().value());
            row.setFaxNo(shinsakaiIinJoho.getFAX番号().value());
            審査会委員一覧.add(row);
        }
        return 審査会委員一覧;
    }

    /**
     * 所属機関情報で所属機関一覧をセットする。
     *
     * @param list 所属機関一覧情報
     * @return List<dgShozokuKikanIchiran_Row>
     */
    public List<dgShozokuKikanIchiran_Row> setShozokuKikanIchiranDiv(List<ShozokuKikanIchiranFinderBusiness> list) {
        List<dgShozokuKikanIchiran_Row> 所属機関一覧 = new ArrayList<>();
        for (ShozokuKikanIchiranFinderBusiness 所属機関情報 : list) {
            dgShozokuKikanIchiran_Row row = new dgShozokuKikanIchiran_Row();
            row.setShokisaiHokenshaNo(所属機関情報.get証記載保険者番号().value());
            row.setHokenshaName(所属機関情報.get市町村名称());
            row.getNinteiItakusakiCode().setValue(所属機関情報.get認定調査委託先コード());
            row.getNinteiChosaItakusakiName().setValue(所属機関情報.get認定調査委託先名());
            row.getShujiiIryoKikanCode().setValue(所属機関情報.get主治医医療機関コード());
            row.getShujiiIryoKikanName().setValue(所属機関情報.get主治医医療機関名称());
            row.getSonotaKikanCode().setValue(所属機関情報.getその他機関コード());
            row.getSonotaKikanName().setValue(所属機関情報.getその他機関名());
            所属機関一覧.add(row);
        }
        return 所属機関一覧;
    }

    /**
     * 審査会委員一覧から、審査会委員詳細情報をセットする。
     */
    public void setDivShinsakaiIinJoho() {
        div.getTxtShinsainCode().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getShinsainCode());
        div.getTxtShinsaIinYMDFrom().setValue(
                div.getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiIinKaishiYMD().getValue());
        div.getTxtShinsaIinYMDTo().setValue(
                div.getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiIinShuryoYMD().getValue());
        div.getTxtShimei().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getShimei());
        div.getTxtKanaShimei().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getKanaShimei());
        div.getTxtBirthYMD().setValue(
                new FlexibleDate(div.getDgShinsaInJohoIchiran().getClickedItem().getBarthYMD().getValue().toDateString().toString()));
        div.getRadSeibetsu().setSelectedValue(new RString(div.getDgShinsaInJohoIchiran().getClickedItem().getSeibetsu() + "性"));
        div.getDdlShikakuCode().setSelectedValue(div.getDgShinsaInJohoIchiran().getClickedItem().getShikakuCode());
        div.getCcdshinsakaiChikuCode().load(SubGyomuCode.DBE認定支援, new CodeShubetsu("5001"), new Code(div.getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiChikuCode()));
        div.setHdnTxtSchemaName(new RString("rgdb"));
        div.setHdnTxtSubGyomuCode(new RString("DBE"));
        div.setHdnTxtCodeShubetsu(new RString("5001"));
        div.getTxtBiko().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getBiko());
    }

    /**
     * 審査会委員一覧から、連絡先/金融機関情報をセットする。
     */
    public void setDivRenrakusakiKinyuKikan() {
        div.getTxtYubinNo().setValue(new YubinNo(div.getDgShinsaInJohoIchiran().getClickedItem().getYubinNo()));
        div.getDdlYusoKubun().setSelectedKey(div.getDgShinsaInJohoIchiran().getClickedItem().getYusoKubun());
        div.getTxtJusho().setDomain(new AtenaJusho(div.getDgShinsaInJohoIchiran().getClickedItem().getJusho()));
        div.getTxtHaishiFlag().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getJokyo());
        div.getTxtHaishiYMD().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getHaishiYMD().getValue());
        div.getTxtTelNo1().setDomain(new TelNo(div.getDgShinsaInJohoIchiran().getClickedItem().getTelNo1()));
        div.getTxtFaxNo().setDomain(new TelNo(div.getDgShinsaInJohoIchiran().getClickedItem().getFaxNo()));
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態_修正ボタン() {
        div.getBtnShinsakaiIinAdd().setDisabled(false);
        div.getTxtShinsaIinYMDFrom().setDisabled(false);
        div.getTxtShinsaIinYMDTo().setDisabled(false);
        div.getTxtShimei().setDisabled(false);
        div.getTxtKanaShimei().setDisabled(false);
        div.getTxtBirthYMD().setDisabled(false);
        div.getRadSeibetsu().setDisabled(false);
        div.getDdlShikakuCode().setDisabled(false);
        div.getCcdshinsakaiChikuCode().setDisabled(false);
        div.getTxtBiko().setDisabled(false);
        div.getBtnShozokuKikanAdd().setDisabled(false);
        div.getDgShozokuKikanIchiran().setDisabled(false);
        div.getTxtYubinNo().setDisabled(false);
        div.getDdlYusoKubun().setDisabled(false);
        div.getTxtJusho().setDisabled(false);
        div.getTxtHaishiFlag().setDisabled(false);
        div.getTxtHaishiYMD().setDisabled(false);
        div.getTxtTelNo1().setDisabled(false);
        div.getTxtFaxNo().setDisabled(false);
        div.getBtnToroku().setDisabled(false);
        div.getBtnDelete().setDisabled(false);
    }

    /**
     * 「審査会委員を追加する」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態_追加ボタン() {
        div.getTxtShinsainCode().setDisabled(false);
        div.getTxtShinsaIinYMDFrom().setDisabled(false);
        div.getTxtShinsaIinYMDTo().setDisabled(false);
        div.getTxtShimei().setDisabled(false);
        div.getTxtKanaShimei().setDisabled(false);
        div.getTxtBirthYMD().setDisabled(false);
        div.getRadSeibetsu().setDisabled(false);
        div.getDdlShikakuCode().setDisabled(false);
        div.getCcdshinsakaiChikuCode().setDisabled(false);
        div.getTxtBiko().setDisabled(false);
        div.getBtnShozokuKikanAdd().setDisabled(false);
        div.getDgShozokuKikanIchiran().setDisabled(false);
        div.getTxtYubinNo().setDisabled(false);
        div.getDdlYusoKubun().setDisabled(false);
        div.getTxtJusho().setDisabled(false);
        div.getTxtHaishiFlag().setDisabled(false);
        div.getTxtHaishiYMD().setDisabled(false);
        div.getTxtTelNo1().setDisabled(false);
        div.getTxtFaxNo().setDisabled(false);
        div.getBtnToroku().setDisabled(false);
        div.getBtnShinsakaiIinAdd().setDisabled(true);
    }

    /**
     * 審査会委員情報詳細エリアをクリアする
     */
    public void clear審査会委員詳細情報() {
        div.getTxtShinsainCode().clearValue();
        div.getTxtShinsaIinYMDFrom().clearValue();
        div.getTxtShinsaIinYMDTo().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtBirthYMD().clearValue();
        div.getRadSeibetsu().setSelectedKey(new RString("1"));
        div.getDdlShikakuCode().setSelectedIndex(0);
        div.getCcdshinsakaiChikuCode().clearDisplayedValues();
        div.getTxtBiko().clearValue();
    }

    /**
     * 連絡先/金融機関エリアをクリアする
     */
    public void clear連絡先金融機関() {
        div.getTxtYubinNo().clearValue();
        div.getDdlYusoKubun().setSelectedIndex(0);
        div.getTxtJusho().clearDomain();
        div.getTxtHaishiFlag().clearValue();
        div.getTxtHaishiYMD().clearValue();
        div.getTxtTelNo1().clearDomain();
        div.getTxtFaxNo().clearDomain();
    }

    /**
     * 審査会委員詳細情報入力されだ審査会委員コードが重複コードを判断する。
     *
     * @return is重複コード
     */
    public boolean is重複コード() {
        for (dgShinsaInJohoIchiran_Row row : div.getDgShinsaInJohoIchiran().getDataSource()) {
            if (div.getTxtShinsainCode().getValue().equals(row.getShinsainCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 審査会委員詳細情報変更を判断します。
     *
     * @return hasChanged合議体詳細情報
     */
    public boolean hasChanged合議体詳細情報() {
        dgShinsaInJohoIchiran_Row row = div.getDgShinsaInJohoIchiran().getClickedItem();
        if (!row.getShinsainCode().equals(div.getTxtShinsainCode().getValue())) {
            return true;
        }
        if (!row.getShinsakaiIinKaishiYMD().getValue().equals(div.getTxtShinsaIinYMDFrom().getValue())) {
            return true;
        }
        if (!row.getShinsakaiIinShuryoYMD().getValue().equals(div.getTxtShinsaIinYMDTo().getValue())) {
            return true;
        }
        if (!row.getShimei().equals(div.getTxtShimei().getValue())) {
            return true;
        }
        if (!row.getKanaShimei().equals(div.getTxtKanaShimei().getValue())) {
            return true;
        }
        if (!row.getBarthYMD().getValue().wareki().toDateString().equals(div.getTxtBirthYMD().getValue().wareki().toDateString())) {
            return true;
        }
        if (!new RString(row.getSeibetsu() + "性").equals(div.getRadSeibetsu().getSelectedValue())) {
            return true;
        }
        if (!row.getShikakuCode().equals(div.getDdlShikakuCode().getSelectedValue())) {
            return true;
        }
        return !row.getBiko().equals(div.getTxtBiko().getValue());
    }

    /**
     * 表示条件をselectedKeyでセットする。
     *
     * @param selectedKey RString
     */
    public void kensakuJokenDiv_init(RString selectedKey) {
        div.getRadHyojiJoken().setSelectedKey(selectedKey);
    }

    /**
     * 審査会委員一覧情報は初期状態にセットする。
     */
    private void shinsakaiIinJohoIchiranDiv_init() {
        div.getDgShinsaInJohoIchiran().getDataSource().clear();
    }

    /**
     * 審査会委員詳細情報は初期状態にセットする。
     */
    public void shinsakaiIinJohoDiv_init() {
        clear審査会委員詳細情報();
        div.getTxtShinsainCode().setDisabled(true);
        div.getTxtShinsaIinYMDFrom().setDisabled(true);
        div.getTxtShinsaIinYMDTo().setDisabled(true);
        div.getTxtShimei().setDisabled(true);
        div.getTxtKanaShimei().setDisabled(true);
        div.getTxtBirthYMD().setDisabled(true);
        div.getRadSeibetsu().setDisabled(true);
        div.getDdlShikakuCode().setDisabled(true);
        div.getCcdshinsakaiChikuCode().setDisabled(true);
        div.getTxtBiko().setDisabled(true);
    }

    /**
     * 所属機関一覧情報は初期状態にセットする。
     */
    public void shozokuKikanIchiranDiv_init() {
        div.getBtnShozokuKikanAdd().setDisabled(true);
        div.getDgShozokuKikanIchiran().getDataSource().clear();
    }

    /**
     * 連絡先/金融機関情報は初期状態にセットする。
     */
    public void renrakusakiKinyuKikanDiv_init() {
        div.getTxtYubinNo().clearValue();
        div.getTxtYubinNo().setDisabled(true);
        div.getDdlYusoKubun().setSelectedIndex(0);
        div.getDdlYusoKubun().setDisabled(true);
        div.getTxtJusho().clearDomain();
        div.getTxtJusho().setDisabled(true);
        div.getTxtHaishiFlag().setValue(new RString("有効"));
        div.getTxtHaishiFlag().setDisabled(true);
        div.getTxtHaishiYMD().clearValue();
        div.getTxtHaishiYMD().setDisabled(true);
        div.getTxtTelNo1().clearDomain();
        div.getTxtTelNo1().setDisabled(true);
        div.getTxtFaxNo().clearDomain();
        div.getTxtFaxNo().setDisabled(true);
    }
}
