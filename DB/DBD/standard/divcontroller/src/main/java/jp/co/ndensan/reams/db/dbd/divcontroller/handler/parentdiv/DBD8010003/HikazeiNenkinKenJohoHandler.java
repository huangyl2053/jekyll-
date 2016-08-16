/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.houshold.HousholdBusiness;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.KakushuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003.HikazeiNenkinKenJohoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.houshold.HousholdFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 非課税年金対象者情報登録画面のHandlerクラスです。
 *
 * @reamsid_L DBD-4930-010 wangjie2
 */
public class HikazeiNenkinKenJohoHandler {

    private final HikazeiNenkinKenJohoDiv div;
    private final FlexibleYear 調定年度_2015 = new FlexibleYear("2015");
    private final FlexibleYear 平成28年度 = new FlexibleYear("2016");
    private static final int 月DDL件数 = 14;
    private static final int 月_12 = 12;
    private static final int INT_3 = 3;
    private final RString 年次_当年 = new RString("00");
    private final RString 月次_当年 = new RString("10");
    private final RString 月次_翌年 = new RString("11");
    private final RString 年次 = new RString("月（年次）");
    private final RString 月次 = new RString("月（月次）");
    private final RString 新規モード = new RString("新規");
    private final RString 修正モード = new RString("修正モ");
    private final RString 性別_女 = new RString("2");
    private final RString 性別_男 = new RString("1");
    private final RString 女 = new RString("女");
    private final RString 男 = new RString("男");

    /**
     * コンストラクタです。
     *
     * @param div 非課税年金対象者情報登録のコントロールdiv
     */
    public HikazeiNenkinKenJohoHandler(HikazeiNenkinKenJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return isメッセージ
     */
    public boolean onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        div.getCcdKaigoAtena().initialize(識別コード);
        if (null == 被保険者番号 || 被保険者番号.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().replace("被保険者番号なし"));
        }
        div.getCcdKaigoShikaku().initialize(被保険者番号);
        前排他の設定(被保険者番号);
        if (年度DDL設定()) {
            return true;
        }
        月DDL設定();
        div.getBtnDisplay().setDisabled(true);
        div.getBtnDelete().setDisabled(true);
        div.getTbBirthday().setDisabled(true);
        div.getDdlSex().setDisabled(true);
        return false;
    }

    private void 月DDL設定() {
        RString 年度終了月
                = DbBusinessConfig.get(ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (年度終了月.isEmpty()) {
            return;
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        int 年度終了月Int = Integer.parseInt(年度終了月.substring(年度終了月.length() - 2).toString());
        int 番目月 = 年度終了月Int > 1 ? 年度終了月Int - 1 : 月_12;
        boolean is当年 = true;
        for (int index = 1; index <= 月DDL件数; index++) {
            RString key;
            RString value;
            if (index == 1) {
                key = 年次_当年.concat(new RString(番目月).padLeft("0", 2));
                value = new RString(番目月).concat(年次);
            } else if (index == 2) {
                if (番目月 >= 月_12) {
                    番目月 = 0;
                }
                番目月++;
                continue;
            } else if (is当年) {
                key = 月次_当年.concat(new RString(番目月).padLeft("0", 2));
                value = new RString(番目月).concat(月次);
                if (番目月 >= 月_12) {
                    is当年 = false;
                }
            } else {
                key = 月次_翌年.concat(new RString(番目月).padLeft("0", 2));
                value = new RString(番目月).concat(月次);
            }
            if (番目月 >= 月_12) {
                番目月 = 0;
            }
            番目月++;
            dataSource.add(new KeyValueDataSource(key, value));
        }
        div.getDdlTsuki().setDataSource(dataSource);
    }

    private boolean 年度DDL設定() {
        FlexibleYear 調定年度 = new FlexibleYear(get日付関連_調定年度());
        if (!調定年度.isWareki()) {
            return false;
        }
        if (調定年度.isBefore(調定年度_2015)) {
            return true;
        }
        FlexibleYear 平成年度 = 平成28年度;
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        while (調定年度.isBeforeOrEquals(平成年度)) {
            dataSource.add(new KeyValueDataSource(new RString(平成年度.getYearValue()), 平成年度.wareki().eraType(EraType.KANJI).toDateString()));
            平成年度 = 平成年度.minusYear(1);
        }
        div.getDdlYear().setDataSource(dataSource);
        return false;
    }

    private RString get日付関連_調定年度() {
        return DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }

    private void 前排他の設定(HihokenshaNo 被保険者番号) {
        RealInitialLocker.lock(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue()).concat("HikazeiNenkin")));
    }

    /**
     * 前排他の解除処理です。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void 前排他の解除(HihokenshaNo 被保険者番号) {
        RealInitialLocker.release(new LockingKey(new RString("DB").concat(被保険者番号.getColumnValue()).concat("HikazeiNenkin")));
    }

    /**
     * 非課税年金対象情報取得処理です。
     *
     * @return 非課税年金対象情報List
     */
    public List<HousholdBusiness> get非課税年金対象情報() {
        対象年金保険者And象年金表示();
        RString 対象年 = new FlexibleYear(div.getDdlYear().getSelectedKey()).minusYear(1).toDateString();
        return HousholdFinder.createIntance().getLastInputHousehold(null, null,
                対象年, div.getTbNenkinHokenshaCode().getValue(), div.getTbKisoNenkinNo().getValue(), div.getTbNenkinCode().getValue());
    }

    private void 対象年金保険者And象年金表示() {
        RString 対象年金保険者 = CodeMaster.getCodeMeisho(
                DBZCodeShubetsu.介護従業者の欠員による減算の状況の有無.getコード(), new Code(div.getTbNenkinHokenshaCode().getValue()));
        if (対象年金保険者.isNullOrEmpty()) {
            throw new ApplicationException(DbdErrorMessages.年金保険者入力不正.getMessage());
        }
        RString 年金コード = div.getTbNenkinCode().getValue();
        RString 年金コード先頭３桁 = 年金コード.isNullOrEmpty() ? RString.EMPTY : 年金コード.substring(0, INT_3);
        RString 対象年金 = CodeMaster.getCodeMeisho(
                DBZCodeShubetsu.介護支援専門員の欠員による減算の状況の有無.getコード(), new Code(年金コード先頭３桁));
        if (対象年金.isNullOrEmpty()) {
            throw new ApplicationException(DbdErrorMessages.年金入力不正.getMessage());
        }
        div.getTbNenKinHokenshaName().setValue(対象年金保険者);
        div.getTbTaishoNenKin().setValue(対象年金);
    }

    /**
     * 新規編集画面制御処理です。
     *
     */
    public void 新規編集画面制御処理() {
        年度DDL設定();
        div.getTbGenkisoNenkinNo().setValue(div.getTbKisoNenkinNo().getValue());
        月DDL設定();
        div.getTbNameKana().setValue(div.getCcdKaigoAtena().get氏名カナ());
        div.getTbNameKanji().setValue(div.getCcdKaigoAtena().get氏名漢字());
        // 画面.介護宛名基本情報.性別コード 生年月日
        div.getTbAddressKana().setValue(RString.EMPTY);
        div.getTbAddressKanji().setValue(div.getCcdKaigoAtena().get住所().getColumnValue());
        対象年金保険者And象年金表示();
        div.getDdlTsuki().setSelectedKey(HousholdFinder.createIntance()
                .get月DDLKey(div.getDdlYear().getSelectedKey(), div.getDdlYear().getDataSource().get(0).getKey()));
        div.getTbKingaku().clearValue();
        if (div.getDdlYear().getSelectedKey().equals(get日付関連_調定年度())) {
            div.getTbCreateDate().setValue(RDate.getNowDate());
        } else {
            div.getTbCreateDate().clearValue();
        }
        div.getTbTaishoNen()
                .setValue(new FlexibleYear(div.getDdlYear().getSelectedKey()).minusYear(1).wareki().eraType(EraType.KANJI).toDateString());
        div.getTbLoadCata().setValue(TorokuKubun.画面登録.get名称());
        div.setHiddenModel(新規モード);
        新規モード_表示();
    }

    private void 新規モード_表示() {
        div.getBtnDelete().setDisabled(false);
        div.getTbGenkisoNenkinNo().setDisabled(false);
        div.getDdlTsuki().setDisabled(false);
        div.getTbKingaku().setDisabled(false);
        div.getTbCreateDate().setDisabled(false);
        div.getTbTaishoNen().setDisabled(false);
        div.getTbNameKana().setDisabled(false);
        div.getDdlSex().setDisabled(false);
        div.getTbBirthday().setDisabled(false);
        div.getTbNameKanji().setDisabled(false);
        div.getTbAddressKana().setDisabled(false);
        div.getTbAddressKanji().setDisabled(false);
    }

    /**
     * 画面全項目活性制御初期化処理です。
     *
     */
    public void 画面全項目活性制御初期化() {
        div.getTbNenkinHokenshaCode().setReadOnly(false);
        div.getTbKisoNenkinNo().setReadOnly(false);
        div.getTbNenkinCode().setReadOnly(false);
        div.getTbGenkisoNenkinNo().setReadOnly(false);
        div.getDdlTsuki().setReadOnly(false);
        div.getTbKingaku().setReadOnly(false);
        div.getTbCreateDate().setReadOnly(false);
        div.getTbTaishoNen().setReadOnly(false);
        div.getTbLoadCata().setReadOnly(false);
        div.getTbNameKana().setReadOnly(false);
        div.getTbNameKanji().setReadOnly(false);
        div.getTbAddressKana().setReadOnly(false);
        div.getTbAddressKanji().setReadOnly(false);
        div.getDdlSex().setReadOnly(false);
        div.getTbBirthday().setReadOnly(false);
        div.getShoSaiPanel().setDisabled(false);
    }

    /**
     * 画面編集制御処理です。
     *
     * @param 非課税年金対象情報 非課税年金対象情報
     */
    public void 画面編集制御処理(HousholdBusiness 非課税年金対象情報) {
        div.getTbYear().setValue(div.getDdlYear().getSelectedValue());
        div.getTbNameKana().setValue(非課税年金対象情報.getカナ氏名());
        div.getTbNameKanji().setValue(非課税年金対象情報.get漢字氏名());
        if (!非課税年金対象情報.get生年月日().isNullOrEmpty()) {
            div.getTbBirthday().setValue(new RDate(非課税年金対象情報.get生年月日().toString()));
        }
        if (性別_女.equals(非課税年金対象情報.get性別())) {
            div.getDdlSex().setSelectedValue(女);
        } else {
            div.getDdlSex().setSelectedValue(男);
        }
        div.getTbNenkinHokenshaCode().setValue(非課税年金対象情報.get年金保険者());
        div.getTbKisoNenkinNo().setValue(非課税年金対象情報.get基礎年金番号());
        div.getTbGenkisoNenkinNo().setValue(非課税年金対象情報.get現基礎年金番号());
        div.getTbNenkinCode().setValue(非課税年金対象情報.get年金コード());
        div.getTbTaishoNen().setValue(非課税年金対象情報.get対象年());
        if (!非課税年金対象情報.get作成年月日().isNullOrEmpty()) {
            div.getTbCreateDate().setValue(new RDate(非課税年金対象情報.get作成年月日().toString()));
        }
        if (!非課税年金対象情報.get登録区分().isNullOrEmpty()) {
            div.getTbLoadCata().setValue(TorokuKubun.toValue(非課税年金対象情報.get登録区分()).get名称());
        }
        div.getTbAddressKana().setValue(非課税年金対象情報.get住所カナ());
        div.getTbAddressKanji().setValue(非課税年金対象情報.get住所漢字());
        if (!非課税年金対象情報.get金額().isNullOrEmpty()) {
            div.getTbKingaku().setValue(new Decimal(非課税年金対象情報.get金額().toString()));
        }
        RString 対象年金保険者 = RString.EMPTY;
        if (!非課税年金対象情報.get年金保険者().isNullOrEmpty()) {
            対象年金保険者 = CodeMaster.getCodeMeisho(
                    DBZCodeShubetsu.介護従業者の欠員による減算の状況の有無.getコード(), new Code(非課税年金対象情報.get年金保険者()));
        }
        if (!対象年金保険者.isEmpty()) {
            div.getTbNenKinHokenshaName().setValue(対象年金保険者);
        }
        RString 対象年金 = RString.EMPTY;
        if (!非課税年金対象情報.get年金コード().isNullOrEmpty()) {
            対象年金 = CodeMaster.getCodeMeisho(
                    DBZCodeShubetsu.介護支援専門員の欠員による減算の状況の有無.getコード(),
                    new Code(非課税年金対象情報.get年金コード().substring(0, INT_3).toString()));
        }
        div.getTbTaishoNenKin().setValue(対象年金);
        div.setHiddenModel(修正モード);
        div.getBtnDelete().setDisabled(非課税年金対象情報.get被保険者番号().isNullOrEmpty());
        div.getTbGenkisoNenkinNo().setDisabled(false);
        if (TorokuKubun.画面登録.getコード().equals(非課税年金対象情報.get登録区分())) {
            div.getDdlTsuki().setDisabled(false);
            div.getTbKingaku().setDisabled(false);
            div.getTbCreateDate().setDisabled(false);
            div.getTbTaishoNen().setDisabled(false);
            div.getTbNameKana().setDisabled(false);
            div.getDdlSex().setDisabled(false);
            div.getTbBirthday().setDisabled(false);
            div.getTbNameKanji().setDisabled(false);
            div.getTbAddressKana().setDisabled(false);
            div.getTbAddressKanji().setDisabled(false);
        }
    }

    /**
     * 非課税年金対象者一時テーブルを取得し、画面項目と比較する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     * @return is変更
     */
    public boolean 画面項目と比較(HousholdBusiness 非課税年金対象者一時) {
        return pk変更チェック(非課税年金対象者一時)
                || !div.getTbKisoNenkinNo().getValue().equals(非課税年金対象者一時.get基礎年金番号())
                || !div.getTbNameKana().getValue().equals(非課税年金対象者一時.getカナ氏名())
                || !div.getTbNameKanji().getValue().equals(非課税年金対象者一時.get漢字氏名())
                || !div.getTbAddressKana().getValue().equals(非課税年金対象者一時.get住所カナ())
                || !div.getTbAddressKanji().getValue().equals(非課税年金対象者一時.get住所漢字())
                || is生年月日変更(非課税年金対象者一時.get生年月日())
                || is性別変更(非課税年金対象者一時.get性別())
                || is登録区分変更(非課税年金対象者一時.get登録区分())
                || is金額変更(非課税年金対象者一時.get金額());
    }

    private boolean is金額変更(RString 金額) {
        if (金額.isNullOrEmpty()) {
            return div.getTbKingaku().getValue() != null;
        }
        if (null == div.getTbKingaku().getValue()) {
            return true;
        }
        return div.getTbKingaku().getValue().compareTo(new Decimal(金額.toString())) != 0;
    }

    private boolean is登録区分変更(RString 登録区分) {
        if (登録区分.isNullOrEmpty()) {
            return !div.getTbLoadCata().getValue().isNullOrEmpty();
        }
        return !TorokuKubun.toValue(登録区分).get名称().equals(div.getTbLoadCata().getValue());
    }

    private boolean is生年月日変更(RString 生年月日) {
        return !div.getTbBirthday().getValue().toDateString().equals(生年月日);
    }

    private boolean is性別変更(RString 性別) {
        if (女.equals(div.getDdlSex().getSelectedValue())) {
            return !性別_女.equals(性別);
        }
        return !性別_男.equals(性別);
    }

    /**
     * 非課税年金対象者一時テーブルを取得し、画面項目と比較する。
     *
     * @return 重複チェックデータ
     */
    public int 重複チェック() {
        return HousholdFinder.createIntance().重複チェック(div.getCcdKaigoShikaku().get被保険者番号(),
                div.getTbNenkinHokenshaCode().getValue(), div.getTbNenkinCode().getValue().substring(0, INT_3),
                div.getTbGenkisoNenkinNo().getValue(), div.getTbTaishoNen().getValue(), div.getTbCreateDate().getValue().toDateString());
    }

    /**
     * 非課税年金対象者一時テーブルを取得し、画面項目と比較する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     * @return isPK変更
     */
    public boolean pk変更チェック(HousholdBusiness 非課税年金対象者一時) {
        return !div.getCcdKaigoShikaku().get被保険者番号().equals(非課税年金対象者一時.get被保険者番号())
                || !div.getTbNenkinHokenshaCode().getValue().equals(非課税年金対象者一時.get年金保険者())
                || !div.getTbNenkinCode().getValue().substring(0, INT_3).equals(非課税年金対象者一時.get年金コード().substring(0, INT_3))
                || !div.getTbGenkisoNenkinNo().getValue().equals(非課税年金対象者一時.get現基礎年金番号())
                || !div.getTbTaishoNen().getValue().equals(非課税年金対象者一時.get対象年())
                || !div.getTbCreateDate().getValue().toDateString().equals(非課税年金対象者一時.get作成年月日());
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「解除キー」と「解除」を参照し、DBに更新する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     */
    public void 削除解除_登録区分_取込_保存処理(HousholdBusiness 非課税年金対象者一時) {
        HousholdFinder.createIntance().取込_保存処理(非課税年金対象者一時, null, null);
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「解除キー」を参照し、当該データを削除する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     */
    public void 削除解除_登録区分_画面登録_保存処理(HousholdBusiness 非課税年金対象者一時) {
        HousholdFinder.createIntance().削除解除_登録区分_画面登録_保存処理(非課税年金対象者一時);
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「更新条件検索キー」と「更新_取込」を参照し、DBに更新する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     */
    public void 修正_登録区分_取込_保存処理(HousholdBusiness 非課税年金対象者一時) {
        HousholdFinder.createIntance()
                .取込_保存処理(非課税年金対象者一時, div.getTbGenkisoNenkinNo().getValue(), div.getCcdKaigoShikaku().get被保険者番号());
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(UPDATE)」の「更新条件検索キー」と「更新_画面登録」を参照し、DBに更新する。
     *
     * @param 非課税年金対象者一時 非課税年金対象者一時
     */
    public void 修正_登録区分_画面登録_保存処理(HousholdBusiness 非課税年金対象者一時) {
        RString 月 = div.getDdlTsuki().getSelectedKey();
        RString 現基礎年金番号 = div.getTbGenkisoNenkinNo().getValue();
        RString 被保番号 = div.getCcdKaigoShikaku().get被保険者番号();
        RDate 作成年月日 = div.getTbCreateDate().getValue();
        RDate 生年月日 = div.getTbBirthday().getValue();
        RString 基礎年金番号 = div.getTbKisoNenkinNo().getValue();
        RString 氏名カナ = div.getTbNameKana().getValue();
        RString 氏名漢字 = div.getTbNameKanji().getValue();
        RString 住所カナ = div.getTbAddressKana().getValue();
        RString 住所漢字 = div.getTbAddressKanji().getValue();
        RString 対象年 = div.getTbTaishoNen().getValue();
        RString 金額 = new RString(div.getTbKingaku().getValue().toString());
        HousholdFinder.createIntance()
                .修正_登録区分_画面登録_保存処理(非課税年金対象者一時, 月, 現基礎年金番号, 被保番号,
                        作成年月日, 生年月日, 基礎年金番号, 氏名カナ, 氏名漢字, 住所カナ, 住所漢字, 対象年, 金額);
    }

    /**
     * 「DB出力(非課税年金対象者)」の「編集仕様(INSERT))」の「新規登録」を参照し、DBに追加する。
     *
     */
    public void 新規_保存処理() {
        RString 年度 = div.getTbYear().getValue();
        RString 月 = div.getDdlTsuki().getSelectedKey();
        RString 基礎年金番号 = div.getTbKisoNenkinNo().getValue();
        RString 現基礎年金番号 = div.getTbGenkisoNenkinNo().getValue();
        RString 年金コード = div.getTbNenkinCode().getValue();
        RString 被保番号 = div.getCcdKaigoShikaku().get被保険者番号();
        RString 年金保険者コード = div.getTbNenkinHokenshaCode().getValue();
        RDate 作成年月日 = div.getTbCreateDate().getValue();
        RDate 生年月日 = div.getTbBirthday().getValue();
        RString 性別 = 性別_男;
        if (女.equals(div.getDdlSex().getSelectedValue())) {
            性別 = 性別_女;
        }
        RString 氏名カナ = div.getTbNameKana().getValue();
        RString 氏名漢字 = div.getTbNameKanji().getValue();
        RString 住所カナ = div.getTbAddressKana().getValue();
        RString 住所漢字 = div.getTbAddressKanji().getValue();
        RString 対象年 = div.getTbTaishoNen().getValue();
        RString 訂正区分 = get訂正区分();
        RString 各種区分 = get各種区分().getコード();
        RString 金額 = new RString(div.getTbKingaku().getValue().toString());
        HousholdFinder.createIntance().新規_保存処理(年度, 月, 基礎年金番号, 現基礎年金番号, 年金コード,
                被保番号, 年金保険者コード, 作成年月日, 生年月日, 性別, 氏名カナ, 氏名漢字, 住所カナ, 住所漢字, 対象年, 訂正区分, 各種区分, 金額);
    }

    private RString get訂正区分() {
        return new RString(select訂正区分また各種区分(true));
    }

    private KakushuKubun get各種区分() {
        return KakushuKubun.toValue(new RString(select訂正区分また各種区分(false)));
    }

    private int select訂正区分また各種区分(boolean is訂正区分) {
        HousholdFinder finder = HousholdFinder.createIntance();
        RString 対象年 = div.getTbTaishoNen().getValue();
        if (!is訂正区分) {
            対象年 = new FlexibleYear(対象年).minusYear(1).toDateString();
        }
        return finder.select訂正区分また各種区分(div.getCcdKaigoShikaku().get被保険者番号(), div.getTbNenkinHokenshaCode().getValue(),
                div.getTbNenkinCode().getValue(), div.getTbKisoNenkinNo().getValue(), 対象年);
    }

    /**
     * 「新規」ボタンの処理です。。
     *
     */
    public void 新規ボタンの処理() {
        //TODO 画面全項目を初期化し、画面.年度＝画面.年度DDL
        新規編集画面制御処理();
        div.getTbYear().setValue(div.getDdlYear().getSelectedValue());
        div.getTbNenkinHokenshaCode().setReadOnly(false);
        div.getTbKisoNenkinNo().setReadOnly(false);
        div.getTbNenkinCode().setReadOnly(false);
        div.getBtnDisplay().setDisabled(false);
    }

}
