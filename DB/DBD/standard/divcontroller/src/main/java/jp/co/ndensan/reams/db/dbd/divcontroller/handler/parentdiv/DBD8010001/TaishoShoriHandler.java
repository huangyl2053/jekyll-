/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010001;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbd.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.TaishoShoriPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.dgShoriSettei_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010001.dgTaishoShoriItchiran_Row;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanriBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 非課税年金対象者情報アップロード画面のHandlerです。
 *
 * @reamsid_L DBD-4920-010 lit
 */
public class TaishoShoriHandler {

    private final TaishoShoriPanelDiv div;
    private static final RString 処理_年次 = new RString("年次");
    private static final RString 処理_月次 = new RString("月次");
    private static final RString 処理コード_年次 = new RString("0");
    private static final RString 処理コード_月次 = new RString("1");
    private static final int 処理月数 = 12;
    private static final RString 固定文字_月 = new RString("月");
    private static final RString 対象ファイル_年次 = new RString("Z51*****.DTA");
    private static final RString 対象ファイル_月次 = new RString("Z52*****.DTA");
    private static final RString HOSHI = new RString("?");
    private static final RString 対象ファイル開始_年次 = new RString("Z5100000_");
    private static final RString 対象ファイル開始_月次 = new RString("Z5200000_");
    private static final RString 対象ファイル終了 = new RString(".DTA");
    private static final RString 横 = new RString("_");
    private static final RString 空白 = new RString(" ");

    /**
     * 画面タイトルのenum
     */
    private enum 画面タイトル {

        /**
         * 要介護認定
         */
        要介護認定(new RString("要介護認定")),
        /**
         * 要介護認定　新規認定
         */
        要介護認定新規認定(new RString("要介護認定　新規認定")),
        /**
         * 要介護認定　新規却下
         */
        要介護認定新規却下(new RString("要介護認定　新規却下")),
        /**
         * 要介護認定　更新認定
         */
        要介護認定更新認定(new RString("要介護認定　更新認定")),
        /**
         * 要介護認定　更新却下
         */
        要介護認定更新却下(new RString("要介護認定　更新却下"));

        private final RString title;

        画面タイトル(RString title) {
            this.title = title;
        }

        /**
         * タイトルを返す。
         *
         * @return タイトル
         */
        public RString getTitle() {
            return title;
        }
    }

    /**
     * 画面表示エリアのenum
     */
    private enum 画面表示エリア {

        /**
         * 調査委託先と調査員コード
         */
        調査委託先と調査員,
        /**
         * 主治医と医療機関
         */
        主治医と医療機関;
    }

    /**
     * コンストラクタです。
     *
     * @param div 非課税年金対象者情報アップロードdiv
     */
    public TaishoShoriHandler(TaishoShoriPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @return 画面更新用情報
     */
    public List<ShoriDateKanri> onLoad() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString 年度終了月 = DbBusinessConfig.get(ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月,
                RDate.getNowDate(), SubGyomuCode.DBD介護受給);

        create処理年度DDL(調定年度);
        create市町村指定DDL();
        return create対象処理一覧(年度終了月);
    }

    /**
     * 対象処理一覧を再検索
     *
     * @param dataList dataList
     * @return 対象処理一覧結果
     */
    public List<ShoriDateKanri> change対象処理一覧(List<dgTaishoShoriItchiran_Row> dataList) {

        List<ShoriDateKanri> targetList = new ShoriDateKanriManager().get処理日付管理マスタ(
                SubGyomuCode.DBD介護受給,
                ShoriName.非課税年金対象者情報アップロード.get名称(),
                new FlexibleYear(div.getHdnNendo()),
                new LasdecCode(div.getHdnShichosonCode()));

        for (ShoriDateKanri target : targetList) {
            for (dgTaishoShoriItchiran_Row row : dataList) {
                if (row.getHdnNendoNaiRenban().equals(target.get年度内連番())) {
                    if (null == target.get処理枝番() || target.get処理枝番().isEmpty()) {
                        row.setTxtShoriJotai(ShoriJotaiKubun.未処理.get名称());
                    } else {
                        row.setTxtShoriJotai(ShoriJotaiKubun.toValue(target.get処理枝番()).get名称());
                    }

                    if (!target.get処理枝番().equals(ShoriJotaiKubun.未処理.getコード())) {
                        YMDHMS 基準日時 = target.get基準日時();
                        row.setTxtShoriNichiji(null != 基準日時 && !基準日時.isEmpty()
                                ? 基準日時.getDate().wareki().eraType(EraType.KANJI)
                                .firstYear(FirstYear.GAN_NEN).fillType(FillType.ZERO).toDateString()
                                .concat(空白).concat(基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss))
                                : RString.EMPTY);
                    }
                    break;
                }
            }
        }

        return targetList;
    }

    /**
     * 市町村指定を選択処理です。
     *
     * @return 画面更新用情報
     */
    public List<ShoriDateKanri> changeShichosonshitei() {
        RString 年度終了月 = DbBusinessConfig.get(ConfigNameDBD.非課税年金対象者情報_月次処理年度終了月,
                RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        return create対象処理一覧(年度終了月);
    }

    /**
     * 画面初期化処理です。
     */
    public void moveShoriSettei() {
        div.getTxtShoriSetteiNendo().setValue(div.getDdlShoriNendo().getSelectedValue());
        div.getTxtShichosonshitei().setValue(div.getDdlShichosonshitei().getSelectedValue());

        create処理設定一覧();
    }

    /**
     * 画面保存処理です。
     *
     * @param 画面更新用情報 List<ShoriDateKanri>
     *
     * @return 更新結果
     */
    public boolean save(List<ShoriDateKanri> 画面更新用情報) {

        if (!isChange()) {
            return true;
        }

        List<ShoriDateKanri> 編集後用登録情報 = new ArrayList<>();
        List<ShoriDateKanri> 編集後用削除情報 = new ArrayList<>();
        for (dgShoriSettei_Row 処理設定 : div.getDgShoriSettei().getDataSource()) {
            if (処理設定.getTxtShoriJotai().getSelectedIndex() != 0) {
                ShoriDateKanri 更新対象 = get更新対象(画面更新用情報, 処理設定.getHdnNendoNaiRenban());
                if (null != 更新対象) {
                    編集後用削除情報.add(更新対象);
                }
                編集後用登録情報.add(edit更新対象(更新対象, 処理設定, null));
            }
        }

        if (!編集後用登録情報.isEmpty()) {
            ShoriDateKanriManager manager = ShoriDateKanriManager.createInstance();
            manager.save処理日付管理リスト(編集後用登録情報, 編集後用削除情報);
        }
        return true;
    }

    /**
     * ファイルの読込処理
     *
     */
    public void readFile() {
        RString line = RString.EMPTY;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(div.getHdnFilePath().toString()), "SJIS"));
            line = new RString(in.readLine());
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TaishoShoriHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TaishoShoriHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        div.setHdnLine(line);

    }

    /**
     * ファイルupload処理
     *
     * @param 画面更新用情報 List<ShoriDateKanri>
     */
    public void upload(List<ShoriDateKanri> 画面更新用情報) {
        SharedFileDescriptor sharedFileDescriptor
                = new SharedFileDescriptor(GyomuCode.DB介護保険, new FilesystemName(getFileName()));

        SharedFile.deleteOldestEntry(sharedFileDescriptor);
        SharedFile.defineSharedFile(sharedFileDescriptor, 1, Arrays.asList(HOSHI), null, true, null);
        SharedFile.copyToSharedFile(sharedFileDescriptor, new FilesystemPath(div.getHdnFilePath()), new CopyToSharedFileOpts());

        List<ShoriDateKanri> 編集後用登録情報 = new ArrayList<>();
        List<ShoriDateKanri> 編集後用削除情報 = new ArrayList<>();
        dgTaishoShoriItchiran_Row row = div.getDgTaishoShoriItchiran().getSelectedItems().get(0);
        ShoriDateKanri 更新対象 = get更新対象(画面更新用情報, row.getHdnNendoNaiRenban());
        if (null != 更新対象) {
            編集後用削除情報.add(更新対象);
        }
        編集後用登録情報.add(edit更新対象(更新対象, null, row));

        ShoriDateKanriManager manager = ShoriDateKanriManager.createInstance();
        manager.save処理日付管理リスト(編集後用登録情報, 編集後用削除情報);
    }

    private RString getFileName() {
        dgTaishoShoriItchiran_Row 一覧対象 = div.getDgTaishoShoriItchiran().getSelectedItems().get(0);
        RStringBuilder build = new RStringBuilder();
        build.append(一覧対象.getHdnShoriCode().equals(処理コード_年次) ? 対象ファイル開始_年次 : 対象ファイル開始_月次)
                .append(div.getDdlShoriNendo().getSelectedKey())
                .append(一覧対象.getHdnShoriCode())
                .append(一覧対象.getHdnTukiCode())
                .append(横)
                .append(div.getDdlShichosonshitei().getSelectedKey())
                .append(対象ファイル終了);
        return build.toRString();
    }

    private ShoriDateKanri get更新対象(List<ShoriDateKanri> 画面更新用情報, RString 年度内連番) {
        for (ShoriDateKanri 画面情報 : 画面更新用情報) {
            if (年度内連番.equals(画面情報.get年度内連番())) {
                return 画面情報;
            }
        }
        return null;
    }

    private ShoriDateKanri edit更新対象(ShoriDateKanri 更新対象, dgShoriSettei_Row 処理設定,
            dgTaishoShoriItchiran_Row 一覧対象) {

        ShoriDateKanriBuilder build = null;
        if (null == 更新対象) {
            if (null != 処理設定) {
                更新対象 = new ShoriDateKanri(
                        SubGyomuCode.DBD介護受給,
                        new LasdecCode(div.getHdnShichosonCode()),
                        ShoriName.非課税年金対象者情報アップロード.get名称(),
                        処理設定.getTxtShoriJotai().getSelectedKey(),
                        new FlexibleYear(div.getHdnNendo()),
                        処理設定.getHdnNendoNaiRenban());

                build = 更新対象.createBuilderForEdit();
            } else if (null != 一覧対象) {
                更新対象 = new ShoriDateKanri(
                        SubGyomuCode.DBD介護受給,
                        new LasdecCode(div.getHdnShichosonCode()),
                        ShoriName.非課税年金対象者情報アップロード.get名称(),
                        ShoriJotaiKubun.処理済.getコード(),
                        new FlexibleYear(div.getHdnNendo()),
                        一覧対象.getHdnNendoNaiRenban());

                build = 更新対象.createBuilderForEdit();
                build.set基準年月日(FlexibleDate.getNowDate());
                build.set基準日時(YMDHMS.now());
            }
        } else {

            build = 更新対象.createBuilderForEdit();
            if (null != 処理設定) {
                build.set処理枝番(処理設定.getTxtShoriJotai().getSelectedKey());
            } else {
                build.set処理枝番(ShoriJotaiKubun.処理済.getコード());
                build.set基準年月日(FlexibleDate.getNowDate());
                build.set基準日時(YMDHMS.now());
            }
        }
        return null == build ? null : build.build();
    }

    private boolean isChange() {
        for (dgShoriSettei_Row 処理設定 : div.getDgShoriSettei().getDataSource()) {
            if (処理設定.getTxtShoriJotai().getSelectedIndex() != 0) {
                return true;
            }
        }
        return false;
    }

    private void create処理設定一覧() {
        List<dgTaishoShoriItchiran_Row> 対象処理リスト = div.getDgTaishoShoriItchiran().getDataSource();
        List<dgShoriSettei_Row> dataList = new ArrayList<>();
        for (dgTaishoShoriItchiran_Row 対象処理 : 対象処理リスト) {
            dgShoriSettei_Row row = new dgShoriSettei_Row();
            row.setTxtTuki(対象処理.getTxtTuki());
            row.setTxtShori(対象処理.getTxtShori());
            row.getTxtShoriJotai().setDataSource(create処理状態DDL(対象処理.getTxtShoriJotai()));
            row.getTxtShoriJotai().setSelectedIndex(0);
            row.setTxtShoriNitchiji(対象処理.getTxtShoriNichiji());
            row.setHdnTukiCode(対象処理.getHdnTukiCode());
            row.setHdnShoriCode(対象処理.getHdnShoriCode());
            row.setHdnNendoNaiRenban(対象処理.getHdnNendoNaiRenban());
            dataList.add(row);
        }
        div.getDgShoriSettei().setDataSource(dataList);
    }

    private List<KeyValueDataSource> create処理状態DDL(RString 処理状態) {
        List<KeyValueDataSource> dataList = new ArrayList();
        if (ShoriJotaiKubun.未処理.get名称().equals(処理状態)) {
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.未処理.getコード(), ShoriJotaiKubun.未処理.get名称()));
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
        } else if (ShoriJotaiKubun.処理済.get名称().equals(処理状態)) {
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.処理済.getコード(), ShoriJotaiKubun.処理済.get名称()));
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.再処理前.getコード(), ShoriJotaiKubun.再処理前.get名称()));
        } else if (ShoriJotaiKubun.再処理前.get名称().equals(処理状態)) {
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.再処理前.getコード(), ShoriJotaiKubun.再処理前.get名称()));
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.処理済.getコード(), ShoriJotaiKubun.処理済.get名称()));
        } else if (ShoriJotaiKubun.処理なし.get名称().equals(処理状態)) {
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.処理なし.getコード(), ShoriJotaiKubun.処理なし.get名称()));
            dataList.add(new KeyValueDataSource(ShoriJotaiKubun.未処理.getコード(), ShoriJotaiKubun.未処理.get名称()));
        }
        return dataList;
    }

    private void create処理年度DDL(RString 調定年度) {
        List<KeyValueDataSource> dataList = new ArrayList();
        FlexibleYear year = new FlexibleYear(調定年度);
        while (new FlexibleYear(new RString("2016")).isBeforeOrEquals(year)) {
            dataList.add(new KeyValueDataSource(year.toDateString(),
                    year.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString().concat(new RString("年度"))));
            year = year.minusYear(1);
        }
        div.getDdlShoriNendo().setDataSource(dataList);
        if (!dataList.isEmpty()) {
            div.getDdlShoriNendo().setSelectedIndex(0);
        }

        div.setHdnNendo(div.getDdlShoriNendo().getSelectedKey());
    }

    private void create市町村指定DDL() {
        List<KeyValueDataSource> dataList = new ArrayList();
        ShichosonSecurityJohoFinder finder = ShichosonSecurityJohoFinder.createInstance();
        jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho shichosonJoho = finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonJoho == null || KaigoDonyuKubun.未導入.code().equals(shichosonJoho.get介護導入区分().code())) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("市町村セキュリティ情報"));
        }
        if (!shichosonJoho.get導入形態コード().equals(DonyuKeitaiCode.事務広域)) {
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            dataList.add(new KeyValueDataSource(association.getLasdecCode_().value(),
                    get市町村値(association.getLasdecCode_(), association.get市町村名())));
        } else {
            RString ログインユーザID = ControlDataHolder.getUserId();
            RString 市町村識別ID = RString.EMPTY;
            List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
            if (null != authorityItemList && !authorityItemList.isEmpty()) {
                市町村識別ID = authorityItemList.get(0).getItemId();
            }
            if (市町村識別ID.equals(new RString("00"))) {
                List<KoseiShichosonMaster> 現市町村情報 = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
                for (KoseiShichosonMaster target : 現市町村情報) {
                    dataList.add(new KeyValueDataSource(target.get市町村コード().value(),
                            get市町村値(target.get市町村コード(), target.get市町村名称())));
                }
            } else {
                KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
                dataList.add(new KeyValueDataSource(構成市町村情報.get市町村コード().value(),
                        get市町村値(構成市町村情報.get市町村コード(), 構成市町村情報.get市町村名称())));
            }
        }

        div.getDdlShichosonshitei().setDataSource(dataList);
        div.getDdlShichosonshitei().setSelectedIndex(0);

        div.setHdnShichosonCode(div.getDdlShichosonshitei().getSelectedKey());
    }

    private List<ShoriDateKanri> create対象処理一覧(RString 年度終了月) {
        List<dgTaishoShoriItchiran_Row> dataList = get対象処理一覧初期値(年度終了月);
        List<ShoriDateKanri> targetList = change対象処理一覧(dataList);
        div.getDgTaishoShoriItchiran().setDataSource(dataList);

        return targetList;
    }

    private List<dgTaishoShoriItchiran_Row> get対象処理一覧初期値(RString 年度終了月) {
        dgTaishoShoriItchiran_Row row = new dgTaishoShoriItchiran_Row();
        List<dgTaishoShoriItchiran_Row> dataList = new ArrayList<>();
        int 月コード = Integer.parseInt(年度終了月.toString());

        row.setHdnTukiCode(new RString(String.format("%03d", 月コード - 1)));
        row.setHdnShoriCode(処理コード_年次);
        row.setHdnNendoNaiRenban(row.getHdnShoriCode().concat(row.getHdnTukiCode()));
        row.setTxtShori(処理_年次);
        row.setTxtTuki(new RString(月コード - 1).concat(固定文字_月));
        row.setTxtTaishoFuairu(対象ファイル_年次);
        row.setTxtShoriJotai(ShoriJotaiKubun.未処理.get名称());
        dataList.add(row);

        RString header = new RString("0");
        for (int i = 0; i < 処理月数; i++) {
            月コード = 月コード + 1;
            月コード = 月コード > 処理月数 ? 1 : 月コード;
            header = 月コード > 処理月数 ? new RString("1") : header;
            row = new dgTaishoShoriItchiran_Row();
            row.setHdnTukiCode(header.concat(new RString(String.format("%02d", 月コード))));
            row.setHdnShoriCode(処理コード_月次);
            row.setHdnNendoNaiRenban(row.getHdnShoriCode().concat(row.getHdnTukiCode()));
            row.setTxtShori(処理_月次);
            row.setTxtTuki(new RString(月コード).concat(固定文字_月));
            row.setTxtTaishoFuairu(対象ファイル_月次);
            row.setTxtShoriJotai(ShoriJotaiKubun.未処理.get名称());
            dataList.add(row);
        }
        return dataList;
    }

    private RString get市町村値(LasdecCode 市町村コード, RString 市町村名) {
        if (null == 市町村コード || 市町村コード.isEmpty()) {
            return RString.EMPTY;
        }
        if (null == 市町村名 || 市町村名.isEmpty()) {
            return 市町村コード.value();
        }
        return 市町村コード.value().concat(RString.HALF_SPACE).concat(市町村名);
    }
}
