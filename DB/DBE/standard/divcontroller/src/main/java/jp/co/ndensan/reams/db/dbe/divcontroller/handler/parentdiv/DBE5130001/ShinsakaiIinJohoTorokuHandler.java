package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会委員情報のハンドラークラスです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
public class ShinsakaiIinJohoTorokuHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 廃止 = new RString("廃止");
    private static final RString KEY_廃止 = new RString("key0");
    private static final RString KEY_有効 = new RString("key1");
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
        div.getTxtDispMax().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtDispMax().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
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
            if (!(shinsakaiIinJoho.get介護認定審査会委員終了年月日() == null || shinsakaiIinJoho.get介護認定審査会委員終了年月日().isEmpty())) {
                if (!shinsakaiIinJoho.get介護認定審査会委員終了年月日().toString().equals("99999999")) {
                    row.getShinsakaiIinShuryoYMD().setValue(new RDate(shinsakaiIinJoho.get介護認定審査会委員終了年月日().toString()));
                }
            }
            row.setShimei(shinsakaiIinJoho.get介護認定審査会委員氏名().value());
            row.setKanaShimei(shinsakaiIinJoho.get介護認定審査会委員氏名カナ().value());
            row.setSeibetsu(Seibetsu.toValue(shinsakaiIinJoho.get性別()).get名称());
            if (shinsakaiIinJoho.get生年月日() != null && !shinsakaiIinJoho.get生年月日().isEmpty()) {
                row.getBarthYMD().setValue(new RDate(shinsakaiIinJoho.get生年月日().toString()));
            }
            RString shikakuCode;
            try {
                shikakuCode = Sikaku.toValue(shinsakaiIinJoho.get介護認定審査員資格コード().value()).get名称();
            } catch (IllegalArgumentException e) {
                shikakuCode = RString.EMPTY;
            }
            row.setShikakuCode(shikakuCode);

            if (shinsakaiIinJoho.get備考() == null) {
                row.setBiko(RString.EMPTY);
            } else {
                row.setBiko(shinsakaiIinJoho.get備考());
            }
            if (IsHaishi.廃止.equals(IsHaishi.toValue(shinsakaiIinJoho.is廃止フラグ()))) {
                row.setJokyo(廃止);
            } else {
                row.setJokyo(RString.EMPTY);
            }
            if (shinsakaiIinJoho.get担当地区コード() != null) {
                row.setShinsakaiChikuCode(shinsakaiIinJoho.get担当地区コード().value());
            } else {
                row.setShinsakaiChikuCode(RString.EMPTY);
            }
            row.setYubinNo(shinsakaiIinJoho.get郵便番号().value());
            row.setYusoKubun(shinsakaiIinJoho.get審査員郵送区分());
            row.setJusho(shinsakaiIinJoho.get住所().value());
            if (!(shinsakaiIinJoho.get廃止年月日() == null || shinsakaiIinJoho.get廃止年月日().isEmpty())) {
                row.getHaishiYMD().setValue(new RDate(shinsakaiIinJoho.get廃止年月日().toString()));
            }
            row.setTelNo1(shinsakaiIinJoho.get電話番号().value());
            if (shinsakaiIinJoho.getFAX番号() != null) {
                row.setFaxNo(shinsakaiIinJoho.getFAX番号().value());
            }
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
            row.setShokisaiHokenshaNo(所属機関情報.get証記載保険者番号() == null ? RString.EMPTY : 所属機関情報.get証記載保険者番号().value());
            row.setHokenshaName(所属機関情報.get市町村名称() == null ? RString.EMPTY : 所属機関情報.get市町村名称());
            row.getNinteiItakusakiCode().setValue(所属機関情報.get認定調査委託先コード() == null ? RString.EMPTY : 所属機関情報.get認定調査委託先コード());
            row.setNinteiChosainCode(所属機関情報.get認定調査員コード() == null ? RString.EMPTY : 所属機関情報.get認定調査員コード());
            row.getNinteiChosaItakusakiName().setValue(所属機関情報.get認定調査委託先名() == null ? RString.EMPTY : 所属機関情報.get認定調査委託先名());
            row.getShujiiIryoKikanCode().setValue(所属機関情報.get主治医医療機関コード() == null ? RString.EMPTY : 所属機関情報.get主治医医療機関コード());
            row.setShujiiCode(所属機関情報.get主治医コード() == null ? RString.EMPTY : 所属機関情報.get主治医コード());
            row.getShujiiIryoKikanName().setValue(所属機関情報.get主治医医療機関名称() == null ? RString.EMPTY : 所属機関情報.get主治医医療機関名称());
            row.getSonotaKikanCode().setValue(所属機関情報.getその他機関コード() == null ? RString.EMPTY : 所属機関情報.getその他機関コード());
            row.getSonotaKikanName().setValue(所属機関情報.getその他機関名() == null ? RString.EMPTY : 所属機関情報.getその他機関名());
            row.setShichosonCode(所属機関情報.get市町村コード() == null ? RString.EMPTY : 所属機関情報.get市町村コード());
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
        if (div.getDgShinsaInJohoIchiran().getClickedItem().getBarthYMD().getValue() != null) {
            div.getTxtBirthYMD().setValue(
                    new FlexibleDate(div.getDgShinsaInJohoIchiran().getClickedItem().getBarthYMD().getValue().toDateString().toString()));
        }
        div.getRadSeibetsu().setSelectedValue(div.getDgShinsaInJohoIchiran().getClickedItem().getSeibetsu());
        div.getDdlShikakuCode().setSelectedValue(div.getDgShinsaInJohoIchiran().getClickedItem().getShikakuCode());
        div.getCcdshinsakaiChikuCode().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(),
                new Code(div.getDgShinsaInJohoIchiran().getClickedItem().getShinsakaiChikuCode()));
        div.getTxtBiko().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getBiko());
    }

    /**
     * 審査会委員一覧から、連絡先/金融機関情報をセットする。
     */
    public void setDivRenrakusakiKinyuKikan() {
        div.getTxtYubinNo().setValue(new YubinNo(div.getDgShinsaInJohoIchiran().getClickedItem().getYubinNo()));
        div.getDdlYusoKubun().setSelectedKey(div.getDgShinsaInJohoIchiran().getClickedItem().getYusoKubun());
        div.getTxtJusho().setDomain(new AtenaJusho(div.getDgShinsaInJohoIchiran().getClickedItem().getJusho()));
        if (廃止.equals(div.getDgShinsaInJohoIchiran().getClickedItem().getJokyo())) {
            div.getDdlHaishiFlag().setSelectedKey(KEY_廃止);
            div.getTxtHaishiYMD().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getHaishiYMD().getValue());
        } else {
            div.getDdlHaishiFlag().setSelectedKey(KEY_有効);
        }
        div.getTxtTelNo1().setDomain(new TelNo(div.getDgShinsaInJohoIchiran().getClickedItem().getTelNo1()));
        div.getTxtFaxNo().setDomain(new TelNo(div.getDgShinsaInJohoIchiran().getClickedItem().getFaxNo()));
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態_修正ボタン() {
        div.getTxtShinsainCode().setDisabled(true);
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
        set所属機関追加ボタンBy一覧();
        div.getDgShozokuKikanIchiran().setDisabled(false);
        div.getTxtYubinNo().setDisabled(false);
        div.getDdlYusoKubun().setDisabled(false);
        div.getTxtJusho().setDisabled(false);
        div.getDdlHaishiFlag().setDisabled(false);
        if (KEY_有効.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            div.getTxtHaishiYMD().setReadOnly(true);
        } else {
            div.getTxtHaishiYMD().setReadOnly(false);
        }
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
        div.getDdlHaishiFlag().setDisabled(false);
        div.getTxtTelNo1().setDisabled(false);
        div.getTxtFaxNo().setDisabled(false);
        div.getBtnDelete().setDisabled(false);
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
        div.getDdlHaishiFlag().setSelectedKey(KEY_有効);
        div.getTxtHaishiYMD().clearValue();
        div.getTxtTelNo1().clearDomain();
        div.getTxtFaxNo().clearDomain();
    }
    
    /**
     * 検索条件エリアをクリアする
     */
    public void clear検索条件() {
        kensakuJokenDiv_init(new RString("key1"));
        div.getTxtDispMax().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 更新モードで、審査会委員詳細情報エリア変更を判断します。
     *
     * @return 詳細情報を変更された場合、trueを返却します、以外場合、falseを返却します。
     */
    public boolean hasChanged合議体詳細情報() {
        RStringBuilder builder = new RStringBuilder(div.getTxtShinsainCode().getValue());
        builder.append(div.getTxtShinsaIinYMDFrom().getValue());
        builder.append(div.getTxtShinsaIinYMDTo().getValue());
        builder.append(div.getTxtShimei().getValue());
        builder.append(div.getTxtKanaShimei().getValue());
        builder.append(div.getRadSeibetsu().getSelectedValue());
        builder.append(div.getTxtBirthYMD().getValue().wareki().toDateString());
        builder.append(div.getDdlShikakuCode().getSelectedValue());
        builder.append(div.getCcdshinsakaiChikuCode().getCode().value());
        builder.append(div.getTxtBiko().getValue());

        return !div.getHdnShinsakaiIinJohoSyosai().equals(builder.toRString());
    }

    /**
     * 新規モードで、審査会委員詳細情報エリアの入力判断です。
     *
     * @return hasChanged合議体詳細情報
     */
    public boolean has審査会委員詳細情報入力() {
        return !RString.isNullOrEmpty(div.getTxtShinsainCode().getValue())
                || div.getTxtShinsaIinYMDFrom().getValue() != null
                || div.getTxtShinsaIinYMDTo().getValue() != null
                || !RString.isNullOrEmpty(div.getTxtShimei().getValue())
                || !RString.isNullOrEmpty(div.getTxtKanaShimei().getValue())
                || !(div.getTxtBirthYMD().getValue() == null || div.getTxtBirthYMD().getValue().isEmpty())
                || !(div.getCcdshinsakaiChikuCode().getCode() == null || div.getCcdshinsakaiChikuCode().getCode().isEmpty())
                || !RString.isNullOrEmpty(div.getTxtBiko().getValue());
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
        div.getCcdshinsakaiChikuCode().applyNoOptionCodeMaster().load(
                SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード());
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
        div.getDdlHaishiFlag().setSelectedKey(KEY_有効);
        div.getDdlHaishiFlag().setDisabled(true);
        div.getTxtHaishiYMD().clearValue();
        div.getTxtHaishiYMD().setReadOnly(true);
        div.getTxtTelNo1().clearDomain();
        div.getTxtTelNo1().setDisabled(true);
        div.getTxtFaxNo().clearDomain();
        div.getTxtFaxNo().setDisabled(true);
    }

    /**
     * 新規モード、審査会委員詳細情報を審査会委員一覧に設定します。
     *
     * @return List<dgShinsaInJohoIchiran_Row>
     */
    public List<dgShinsaInJohoIchiran_Row> set審査会委員一覧By新規モード() {
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧情報 = div.getDgShinsaInJohoIchiran().getDataSource();

        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        row.setStatus(状態_追加);
        row.setShinsainCode(div.getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getTxtShimei().getValue());
        row.setKanaShimei(div.getTxtKanaShimei().getValue());
        row.setSeibetsu(Seibetsu.toValue(div.getRadSeibetsu().getSelectedKey()).get名称());
        if (!div.getTxtBirthYMD().getValue().isEmpty()) {
            row.getBarthYMD().setValue(new RDate(div.getTxtBirthYMD().getValue().toString()));
        }
        row.setShikakuCode(div.getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getTxtBiko().getValue());
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            row.setJokyo(廃止);
        }
        row.setYubinNo(div.getTxtYubinNo().getValue().value());
        row.setYusoKubun(div.getDdlYusoKubun().getSelectedKey());
        row.setJusho(div.getTxtJusho().getDomain().value());
        row.getHaishiYMD().setValue(div.getTxtHaishiYMD().getValue());
        row.setTelNo1(div.getTxtTelNo1().getDomain().value());
        row.setFaxNo(div.getTxtFaxNo().getDomain().value());
        審査会委員一覧情報.add(row);
        return 審査会委員一覧情報;
    }

    /**
     * 更新モード、審査会委員詳細情報を審査会委員一覧に設定します。
     *
     * @return List<dgShinsaInJohoIchiran_Row>
     */
    public List<dgShinsaInJohoIchiran_Row> set審査会委員一覧By更新モード() {
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧情報 = div.getDgShinsaInJohoIchiran().getDataSource();
        int count = div.getDgShinsaInJohoIchiran().getClickedRowId();
        dgShinsaInJohoIchiran_Row row = div.getDgShinsaInJohoIchiran().getClickedItem();

        if (!状態_追加.equals(row.getStatus())) {
            row.setStatus(状態_修正);
        }
        row.setShinsainCode(div.getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getTxtShimei().getValue());
        row.setKanaShimei(div.getTxtKanaShimei().getValue());
        row.setSeibetsu(Seibetsu.toValue(div.getRadSeibetsu().getSelectedKey()).get名称());
        if (!div.getTxtBirthYMD().getValue().isEmpty()) {
            row.getBarthYMD().setValue(new RDate(div.getTxtBirthYMD().getValue().toString()));
        }
        row.setShikakuCode(div.getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getTxtBiko().getValue());
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            row.setJokyo(廃止);
        }
        row.setYubinNo(div.getTxtYubinNo().getValue().value());
        row.setYusoKubun(div.getDdlYusoKubun().getSelectedKey());
        row.setJusho(div.getTxtJusho().getDomain().value());
        row.getHaishiYMD().setValue(div.getTxtHaishiYMD().getValue());
        row.setTelNo1(div.getTxtTelNo1().getDomain().value());
        row.setFaxNo(div.getTxtFaxNo().getDomain().value());
        審査会委員一覧情報.set(count, row);
        return 審査会委員一覧情報;
    }

    /**
     * 認定調査委託先存在を判定します。
     *
     * @param 認定調査委託先 認定調査委託先
     * @return 認定調査委託先存在場合、trueを返却します、以外、falseを返却します
     */
    public boolean is認定調査委託先存在(KijuntsukiShichosonjohoiDataPassModel 認定調査委託先) {
        for (int i = 0; i < div.getDgShozokuKikanIchiran().getDataSource().size(); i++) {
            if (認定調査委託先.get委託先コード().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getNinteiItakusakiCode().getValue())
                    && 認定調査委託先.get調査員コード().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getNinteiChosainCode())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 主治医医療機関存在を判定します。
     *
     * @param 主治医医療機関 主治医医療機関
     * @return 主治医医療機関存在場合、trueを返却します、以外、falseを返却します
     */
    public boolean is主治医医療機関存在(ShujiiIryokikanandshujiiDataPassModel 主治医医療機関) {
        for (int i = 0; i < div.getDgShozokuKikanIchiran().getDataSource().size(); i++) {
            if (主治医医療機関.get主治医コード().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getShujiiCode())
                    && 主治医医療機関.get主治医医療機関コード().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getShujiiIryoKikanCode().getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * その他機関存在を判定します。
     *
     * @param その他機関 その他機関モード
     * @return その他機関存在場合、trueを返却します、以外、falseを返却します
     */
    public boolean isその他機関存在(SoNoTaKikanGuideModel その他機関) {
        for (int i = 0; i < div.getDgShozokuKikanIchiran().getDataSource().size(); i++) {
            if (その他機関.getその他機関コード().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getSonotaKikanCode().getValue())
                    && その他機関.getその他機関名称().equals(div.getDgShozokuKikanIchiran().getDataSource().get(i).getSonotaKikanName().getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 選択された審査会委員詳細情報をhidden項目に格納します。
     */
    public void setShinsakaiIinJohoSyosai() {
        dgShinsaInJohoIchiran_Row clickRow = div.getDgShinsaInJohoIchiran().getClickedItem();
        RStringBuilder builder = new RStringBuilder(clickRow.getShinsainCode());
        builder.append(clickRow.getShinsakaiIinKaishiYMD().getValue());
        builder.append(clickRow.getShinsakaiIinShuryoYMD().getValue());
        builder.append(clickRow.getShimei());
        builder.append(clickRow.getKanaShimei());
        builder.append(clickRow.getSeibetsu());
        if (clickRow.getBarthYMD().getValue() != null) {
            builder.append(clickRow.getBarthYMD().getValue().wareki().toDateString());
        }
        builder.append(clickRow.getShikakuCode());
        builder.append(clickRow.getShinsakaiChikuCode());
        builder.append(clickRow.getBiko());
        div.setHdnShinsakaiIinJohoSyosai(builder.toRString());
    }

    /**
     * 所属機関一覧存在する行で、「所属機関を追加する」ボタン状態をセットします。
     */
    public void set所属機関追加ボタンBy一覧() {
        if (div.getDgShozokuKikanIchiran().getDataSource().isEmpty()) {
            div.getBtnShozokuKikanAdd().setDisabled(false);
        } else {
            div.getBtnShozokuKikanAdd().setDisabled(true);
        }
    }
}
