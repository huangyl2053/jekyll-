package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5130001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.ninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.ninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.ShinsakaiIinJohoTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShinsaInJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会委員情報のハンドラークラスです。
 *
 * @reamsid_L DBE-0110-010 wangxiaodong
 */
public class ShinsakaiIinJohoTorokuHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 廃止 = new RString("廃止");
    private static final RString 有効 = new RString("有効");
    private static final RString KEY_廃止 = new RString("key0");
    private static final RString KEY_有効 = new RString("key1");
    private static final RString ZERO = new RString("0");
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
    }

    /**
     * 審査会委員情報で審査会委員一覧情報をセットする。
     *
     * @param list 審査会委員情報
     * @return List<dgShinsaInJohoIchiran_Row>
     */
    public List<dgShinsaInJohoIchiran_Row> setShinsaInJohoIchiranDiv(List<ShinsakaiIinJoho> list) {
        shinsakaiIinJohoIchiranDiv_init();
        List<dgShinsaInJohoIchiran_Row> 審査会委員一覧 = new ArrayList<>();
        for (ShinsakaiIinJoho shinsakaiIinJoho : list) {
            dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
            row.setStatus(RString.EMPTY);
            row.setShinsainCode(shinsakaiIinJoho.get介護認定審査会委員コード());
            if (shinsakaiIinJoho.get介護認定審査会委員開始年月日() != null && !shinsakaiIinJoho.get介護認定審査会委員開始年月日().isEmpty()) {
                if (!shinsakaiIinJoho.get介護認定審査会委員開始年月日().equals(FlexibleDate.MIN)) {
                    row.getShinsakaiIinKaishiYMD().setValue(new RDate(shinsakaiIinJoho.get介護認定審査会委員開始年月日().toString()));
                }
            }

            if (!(shinsakaiIinJoho.get介護認定審査会委員終了年月日() == null || shinsakaiIinJoho.get介護認定審査会委員終了年月日().isEmpty())) {
                if (!shinsakaiIinJoho.get介護認定審査会委員終了年月日().equals(FlexibleDate.MAX)) {
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
                row.setJokyo(有効);
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
            row.setKinyuKikanCode(shinsakaiIinJoho.get金融機関コード() != null
                    ? shinsakaiIinJoho.get金融機関コード().value() : RString.EMPTY);
            row.setKinyuKikanShitenCode(shinsakaiIinJoho.get金融機関支店コード() != null
                    ? shinsakaiIinJoho.get金融機関支店コード().value() : RString.EMPTY);
            row.setYokinShubetsu(shinsakaiIinJoho.get預金種別() != null ? shinsakaiIinJoho.get預金種別() : RString.EMPTY);
            row.setKozaNo(shinsakaiIinJoho.get口座番号() != null ? shinsakaiIinJoho.get口座番号() : RString.EMPTY);
            row.setKozaMeigininKana(shinsakaiIinJoho.get口座名義人カナ() != null
                    ? shinsakaiIinJoho.get口座名義人カナ().value() : RString.EMPTY);
            row.setKozaMeiginin(shinsakaiIinJoho.get口座名義人() != null
                    ? shinsakaiIinJoho.get口座名義人().value() : RString.EMPTY);
            row.setShikakuCodeCode(shinsakaiIinJoho.get介護認定審査員資格コード().value());
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
            row.setHdnColumn(row.getShokisaiHokenshaNo()
                    .concat(row.getNinteiItakusakiCode().getValue())
                    .concat(row.getShujiiIryoKikanCode().getValue())
                    .concat(row.getSonotaKikanCode().getValue()));
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
            div.getTxtBirthYMD().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getBarthYMD().getValue());
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
        div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().search(
                new KinyuKikanCode(div.getDgShinsaInJohoIchiran().getClickedItem().getKinyuKikanCode()),
                new KinyuKikanShitenCode(div.getDgShinsaInJohoIchiran().getClickedItem().getKinyuKikanShitenCode()),
                FlexibleDate.getNowDate());
        div.getKozaJoho().getDdlYokinShubetsu().setSelectedKey(div.getDgShinsaInJohoIchiran().getClickedItem().getYokinShubetsu());
        div.getKozaJoho().getTxtGinkoKozaNo().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getKozaNo());
        div.getKozaJoho().getTxtKozaMeiginin().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getKozaMeigininKana());
        div.getKozaJoho().getTxtKanjiMeiginin().setValue(div.getDgShinsaInJohoIchiran().getClickedItem().getKozaMeiginin());
    }

    /**
     * 審査会委員一覧Gridの「修正」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態_修正ボタン() {
        div.getTxtShinsainCode().setDisabled(true);
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
        div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().setDisabled(false);
        div.getKozaJoho().getDdlYokinShubetsu().setDisabled(false);
        div.getKozaJoho().getTxtGinkoKozaNo().setDisabled(false);
        div.getKozaJoho().getTxtKozaMeiginin().setDisabled(false);
        div.getKozaJoho().getTxtKanjiMeiginin().setDisabled(false);
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
        div.getTxtHaishiYMD().setDisabled(false);
        div.getTxtHaishiYMD().setReadOnly(true);
        div.getTxtTelNo1().setDisabled(false);
        div.getTxtFaxNo().setDisabled(false);
        div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().setDisabled(false);
        div.getKozaJoho().getDdlYokinShubetsu().setDisabled(false);
        div.getKozaJoho().getTxtGinkoKozaNo().setDisabled(false);
        div.getKozaJoho().getTxtKozaMeiginin().setDisabled(false);
        div.getKozaJoho().getTxtKanjiMeiginin().setDisabled(false);
    }

    /**
     * 「削除する」ボタンを押下、部品活性状態をセットする。
     */
    public void set部品状態_削除ボタン() {
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
        div.getBtnShozokuKikanAdd().setDisabled(true);
        div.getDgShozokuKikanIchiran().setDisabled(true);
        div.getTxtYubinNo().setDisabled(true);
        div.getDdlYusoKubun().setDisabled(true);
        div.getTxtJusho().setDisabled(true);
        div.getDdlHaishiFlag().setDisabled(true);
        div.getTxtHaishiYMD().setDisabled(true);
        div.getTxtTelNo1().setDisabled(true);
        div.getTxtFaxNo().setDisabled(true);
        div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().setDisabled(true);
        div.getKozaJoho().getDdlYokinShubetsu().setDisabled(true);
        div.getKozaJoho().getTxtGinkoKozaNo().setDisabled(true);
        div.getKozaJoho().getTxtKozaMeiginin().setDisabled(true);
        div.getKozaJoho().getTxtKanjiMeiginin().setDisabled(true);
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
        div.getCcdshinsakaiChikuCode().applyNoOptionCodeMaster().load(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(),
                Code.EMPTY);
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
        div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().clear();
        div.getKozaJoho().getDdlYokinShubetsu().setSelectedValue(RString.EMPTY);
        div.getKozaJoho().getTxtGinkoKozaNo().clearValue();
        div.getKozaJoho().getTxtKozaMeiginin().clearValue();
        div.getKozaJoho().getTxtKanjiMeiginin().clearValue();
    }

    /**
     * 審査会委員詳細情報エリア変更を判断します。
     *
     * @return 詳細情報を変更された場合、trueを返却します、以外場合、falseを返却します。
     */
    public boolean hasChanged合議体詳細情報() {
        if (!(new RString(div.getDgShozokuKikanIchiran().getDataSource().size())).equals(div.getHdnShozokuKikanIchiranSize())) {
            return true;
        }
        RStringBuilder builder = new RStringBuilder(div.getTxtShinsainCode().getValue());
        builder.append(div.getTxtShinsaIinYMDFrom().getValue());
        builder.append(div.getTxtShinsaIinYMDTo().getValue());
        builder.append(div.getTxtShimei().getValue());
        builder.append(div.getTxtKanaShimei().getValue());
        builder.append(div.getRadSeibetsu().getSelectedValue());
        builder.append(nullToEmpty(div.getTxtBirthYMD().getValue()));
        builder.append(div.getDdlShikakuCode().getSelectedValue());
        builder.append(div.getCcdshinsakaiChikuCode().getCode().value());
        builder.append(div.getTxtBiko().getValue());
        builder.append(div.getTxtYubinNo().getValue());
        builder.append(div.getTxtJusho().getDomain().value());
        builder.append(div.getTxtTelNo1().getDomain().value());
        builder.append(div.getTxtFaxNo().getDomain().value());
        builder.append(div.getDdlYusoKubun().getSelectedKey());
        builder.append(div.getDdlHaishiFlag().getSelectedValue());
        builder.append(nullToEmpty(div.getTxtHaishiYMD().getValue()));
        builder.append(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().value());
        builder.append(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().value());
        builder.append(div.getKozaJoho().getDdlYokinShubetsu().getSelectedKey());
        builder.append(div.getKozaJoho().getTxtGinkoKozaNo().getValue());
        builder.append(div.getKozaJoho().getTxtKozaMeiginin().getValue());
        builder.append(div.getKozaJoho().getTxtKanjiMeiginin().getValue());
        return !div.getHdnShinsakaiIinJohoSyosai().equals(builder.toRString()) || hasChanged所属機関一覧();
    }

    private boolean hasChanged所属機関一覧() {
        if (div.getDgShozokuKikanIchiran().getDataSource().isEmpty()) {
            return true;
        }
        for (dgShozokuKikanIchiran_Row row : div.getDgShozokuKikanIchiran().getDataSource()) {
            if (!row.getHdnColumn().equals(row.getShokisaiHokenshaNo()
                    .concat(row.getNinteiItakusakiCode().getValue())
                    .concat(row.getShujiiIryoKikanCode().getValue())
                    .concat(row.getSonotaKikanCode().getValue()))) {
                return true;
            }
        }
        return false;

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
     * 審査会委員情報を設定します。
     *
     * @param shinsakaiJoho 審査会委員情報
     * @return shinsakaiJoho 審査会委員情報
     */
    public ShinsakaiIinJoho setShinsakaiJoho(ShinsakaiIinJoho shinsakaiJoho) {
        shinsakaiJoho.getKaigoNinteiShinsakaiIinShozokuKikanJohoList().clear();
        ShinsakaiIinJohoBuilder shinsakaiIinJohoBuilder = shinsakaiJoho.createBuilderForEdit();
        shinsakaiIinJohoBuilder.set介護認定審査会委員開始年月日(new FlexibleDate(div.getTxtShinsaIinYMDFrom().getValue().toDateString()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員終了年月日(new FlexibleDate(div.getTxtShinsaIinYMDTo().getValue().toDateString()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員氏名(new AtenaMeisho(div.getTxtShimei().getValue()));
        shinsakaiIinJohoBuilder.set介護認定審査会委員氏名カナ(new AtenaKanaMeisho(div.getTxtKanaShimei().getValue()));
        shinsakaiIinJohoBuilder.set生年月日(edit日付RDateToFlexibleDate(div.getTxtBirthYMD().getValue()));
        shinsakaiIinJohoBuilder.set性別(div.getRadSeibetsu().getSelectedKey());
        shinsakaiIinJohoBuilder.set介護認定審査員資格コード(new Code(div.getDdlShikakuCode().getSelectedKey()));
        shinsakaiIinJohoBuilder.set担当地区コード(new ChikuCode(div.getCcdshinsakaiChikuCode().getCode().getKey()));
        shinsakaiIinJohoBuilder.set備考(div.getTxtBiko().getValue());
        shinsakaiIinJohoBuilder.set郵便番号(div.getTxtYubinNo().getValue());
        shinsakaiIinJohoBuilder.set審査員郵送区分(div.getDdlYusoKubun().getSelectedKey());
        shinsakaiIinJohoBuilder.set住所(div.getTxtJusho().getDomain());
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            shinsakaiIinJohoBuilder.set廃止フラグ(true);
            shinsakaiIinJohoBuilder.set廃止年月日(edit日付RDateToFlexibleDate(div.getTxtHaishiYMD().getValue()));
        } else {
            shinsakaiIinJohoBuilder.set廃止フラグ(false);
        }
        shinsakaiIinJohoBuilder.set電話番号(div.getTxtTelNo1().getDomain());
        shinsakaiIinJohoBuilder.setFAX番号(div.getTxtFaxNo().getDomain());
        shinsakaiIinJohoBuilder.set金融機関コード(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode());
        shinsakaiIinJohoBuilder.set金融機関支店コード(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode());
        shinsakaiIinJohoBuilder.set預金種別(div.getKozaJoho().getDdlYokinShubetsu().getSelectedKey());
        shinsakaiIinJohoBuilder.set口座番号(div.getKozaJoho().getTxtGinkoKozaNo().getValue());
        shinsakaiIinJohoBuilder.set口座名義人カナ(new AtenaKanaMeisho(div.getKozaJoho().getTxtKozaMeiginin().getValue()));
        shinsakaiIinJohoBuilder.set漢字名義人(new AtenaMeisho(div.getKozaJoho().getTxtKanjiMeiginin().getValue()));
        return setViewStateBy所属機関一覧(div, shinsakaiIinJohoBuilder);
    }

    private ShinsakaiIinJoho setViewStateBy所属機関一覧(ShinsakaiIinJohoTorokuDiv div, ShinsakaiIinJohoBuilder shinsakaiIinJohoBuilder) {
        int i = 0;
        for (dgShozokuKikanIchiran_Row row : div.getDgShozokuKikanIchiran().getDataSource()) {
            i++;
            KaigoNinteiShinsakaiIinShozokuKikanJoho 所属機関 = new KaigoNinteiShinsakaiIinShozokuKikanJoho(
                    div.getTxtShinsainCode().getValue(), i);
            KaigoNinteiShinsakaiIinShozokuKikanJohoBuilder builder = 所属機関.createBuilderForEdit();
            builder.set証記載保険者番号(new ShoKisaiHokenshaNo(row.getShokisaiHokenshaNo()));
            builder.set主治医医療機関コード(row.getShujiiIryoKikanCode().getValue());
            builder.set主治医コード(row.getShujiiCode());
            builder.set認定調査委託先コード(row.getNinteiItakusakiCode().getValue());
            builder.set認定調査員コード(row.getNinteiChosainCode());
            builder.setその他機関コード(row.getSonotaKikanCode().getValue());
            所属機関 = builder.build();
            所属機関.toEntity().setState(EntityDataState.Added);
            shinsakaiIinJohoBuilder.setKaigoNinteiShinsakaiIinShozokuKikanJoho(所属機関);
        }
        return shinsakaiIinJohoBuilder.build();
    }

    /**
     * 審査会委員情報を設定します。
     *
     * @param eventJotai 状態
     */
    public void setShinsakiToIchiran(RString eventJotai) {
        dgShinsaInJohoIchiran_Row row = new dgShinsaInJohoIchiran_Row();
        if (!状態_追加.equals(eventJotai)) {
            row = div.getDgShinsaInJohoIchiran().getActiveRow();
        }
        row.setShinsainCode(div.getTxtShinsainCode().getValue());
        row.getShinsakaiIinKaishiYMD().setValue(div.getTxtShinsaIinYMDFrom().getValue());
        row.getShinsakaiIinShuryoYMD().setValue(div.getTxtShinsaIinYMDTo().getValue());
        row.setShimei(div.getTxtShimei().getValue());
        row.setKanaShimei(div.getTxtKanaShimei().getValue());
        row.setSeibetsu(Seibetsu.toValue(div.getRadSeibetsu().getSelectedKey()).get名称());
        if (div.getTxtBirthYMD().getValue() != null && !div.getTxtBirthYMD().getValue().toDateString().isEmpty()) {
            row.getBarthYMD().setValue(new RDate(div.getTxtBirthYMD().getValue().toString()));
        }
        row.setShikakuCode(div.getDdlShikakuCode().getSelectedValue());
        row.setBiko(div.getTxtBiko().getValue());
        if (KEY_廃止.equals(div.getDdlHaishiFlag().getSelectedKey())) {
            row.setJokyo(廃止);
        } else {
            row.setJokyo(有効);
        }
        row.setYubinNo(div.getTxtYubinNo().getValue().value());
        row.setYusoKubun(div.getDdlYusoKubun().getSelectedKey());
        row.setJusho(div.getTxtJusho().getDomain().value());
        row.getHaishiYMD().setValue(div.getTxtHaishiYMD().getValue());
        row.setTelNo1(div.getTxtTelNo1().getDomain().value());
        row.setFaxNo(div.getTxtFaxNo().getDomain().value());
        row.setKinyuKikanCode(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanCode().value());
        row.setKinyuKikanShitenCode(div.getKozaJoho().getCcdKozaJohoMeisaiKinyuKikanInput().getKinyuKikanShitenCode().value());
        row.setYokinShubetsu(div.getKozaJoho().getDdlYokinShubetsu().getSelectedKey());
        row.setKozaNo(div.getKozaJoho().getTxtGinkoKozaNo().getValue());
        row.setKozaMeigininKana(div.getKozaJoho().getTxtKozaMeiginin().getValue());
        row.setKozaMeiginin(div.getKozaJoho().getTxtKanjiMeiginin().getValue());

        int index = div.getDgShinsaInJohoIchiran().getClickedRowId();
        if (状態_追加.equals(eventJotai)) {
            row.setStatus(eventJotai);
            div.getDgShinsaInJohoIchiran().getDataSource().add(row);
        } else if (状態_削除.equals(eventJotai) && 状態_追加.equals(row.getStatus())) {
            div.getDgShinsaInJohoIchiran().getDataSource().remove(index);
        } else if (状態_修正.equals(eventJotai) && 状態_追加.equals(row.getStatus())) {
            div.getDgShinsaInJohoIchiran().getDataSource().set(index, row);
        } else {
            row.setStatus(eventJotai);
            div.getDgShinsaInJohoIchiran().getDataSource().set(index, row);
        }
    }

    /**
     * 認定調査委託先存在を判定します。
     *
     * @param 認定調査委託先 認定調査委託先
     * @return 認定調査委託先存在場合、trueを返却します、以外、falseを返却します
     */
    public boolean is認定調査委託先存在(KijuntsukiShichosonjohoiDataPassModel 認定調査委託先) {
        for (dgShozokuKikanIchiran_Row row : div.getDgShozokuKikanIchiran().getDataSource()) {
            if (認定調査委託先.get委託先コード() != null && 認定調査委託先.get委託先コード().equals(row.getNinteiItakusakiCode().getValue())
                    && 認定調査委託先.get調査員コード() != null && 認定調査委託先.get調査員コード().equals(row.getNinteiChosainCode())) {
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
        for (dgShozokuKikanIchiran_Row row : div.getDgShozokuKikanIchiran().getDataSource()) {
            if (主治医医療機関.get主治医コード() != null
                    && 主治医医療機関.get主治医コード().equals(row.getShujiiCode())
                    && 主治医医療機関.get主治医医療機関コード() != null
                    && 主治医医療機関.get主治医医療機関コード().equals(row.getShujiiIryoKikanCode().getValue())) {
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
        for (dgShozokuKikanIchiran_Row row : div.getDgShozokuKikanIchiran().getDataSource()) {
            if (その他機関.getその他機関コード() != null && その他機関.getその他機関コード().equals(row.getSonotaKikanCode().getValue())
                    && その他機関.getその他機関名称() != null && その他機関.getその他機関名称().equals(row.getSonotaKikanName().getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 追加するの場合、hidden項目に初期値を格納します。
     */
    public void setShinsakaiIinJohoSyosaiEmpty() {
        div.setHdnShinsakaiIinJohoSyosai(RString.EMPTY);
        div.setHdnShozokuKikanIchiranSize(ZERO);
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
        builder.append(clickRow.getYubinNo());
        builder.append(clickRow.getJusho());
        builder.append(clickRow.getTelNo1());
        builder.append(clickRow.getFaxNo());
        builder.append(clickRow.getYusoKubun());
        builder.append(clickRow.getJokyo());
        if (clickRow.getHaishiYMD().getValue() != null) {
            builder.append(clickRow.getHaishiYMD().getValue().wareki().toDateString());
        }
        builder.append(clickRow.getKinyuKikanCode());
        builder.append(clickRow.getKinyuKikanShitenCode());
        builder.append(clickRow.getYokinShubetsu());
        builder.append(clickRow.getKozaNo());
        builder.append(clickRow.getKozaMeigininKana());
        builder.append(clickRow.getKozaMeiginin());
        div.setHdnShinsakaiIinJohoSyosai(builder.toRString());
        div.setHdnShozokuKikanIchiranSize(new RString(div.getDgShozokuKikanIchiran().getDataSource().size()));
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

    private RString nullToEmpty(RDate 日付) {
        return 日付 != null ? 日付.wareki().toDateString() : RString.EMPTY;
    }

    private FlexibleDate edit日付RDateToFlexibleDate(RDate 日付) {
        return 日付 != null ? new FlexibleDate(日付.toDateString()) : FlexibleDate.EMPTY;
    }
}
