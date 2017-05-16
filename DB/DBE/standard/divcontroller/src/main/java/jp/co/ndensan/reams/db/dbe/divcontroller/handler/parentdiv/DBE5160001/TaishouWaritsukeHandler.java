/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5160001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2Builder;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.KohoshaIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.TaishouWaritsukeHead;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.Taishouichiran;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShinsakaiJidoWaritsuke;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiwariatejoho.ShinsakaiWariateJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke.CountShinsakaiIinJogaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke.CountShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke.KohoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke.TaishouIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.TaishouWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.dgWaritsukeKohoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.taishouwaritsuke.ParamEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.konicho.taishouwaritsuke.TaishouWaritsukeFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinsakaiWariateJohoKenshu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinsakaiWariateJohoKenshuBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.config.DbeConfigKey;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinsakaiWariateJohoKenshuManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Icon;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護認定審査会対象者割付クラスです。
 *
 * @reamsid_L DBE-0140-010 liangbc
 */
public class TaishouWaritsukeHandler {

    private final TaishouWaritsukeDiv div;
    private static final RString 審査会順番を振りなおす = new RString("btnResetShinsaOrder");
    private static final RString 審査会順番を確定する = new RString("btnDetermineToShinsakaiOrder");
    private static final RString 登録する = new RString("btnRegister");
    private static final RString 審査会割付を完了する = new RString("btnComplete");
    private static final RString 対象者一覧状態フラグ = new RString("1");
    private static final RString 候補者一覧状態フラグ = new RString("2");
    private static final RString 審査順確定フラグ_確定 = new RString("1");
    private static final RString 審査順確定フラグ_確定しない = new RString("0");
    private static final RString 一次判定後 = new RString("1");
    private static final RString 機関まで = new RString("1");
    private static final RString 厚労省IF識別コード_09 = new RString("09");
    private static final RString 厚労省IF識別コード_06 = new RString("06");
    private static final RString 厚労省IF識別コード_02 = new RString("02");
    private static final RString 厚労省IF識別コード_99 = new RString("99");
    private static final RString ZERO = new RString("0");
    private static final RString 合議体精神科医存在フラグ_KEY = new RString("key0");
    private static final RString 研修模擬_KEY = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会対象者割付。
     */
    public TaishouWaritsukeHandler(TaishouWaritsukeDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化表示、画面項目に設定されている値をクリアする。
     *
     * @param 介護認定審査会番号 介護認定審査会番号
     */
    public void initializtion(RString 介護認定審査会番号) {
        div.getShinsakaiTaishoshaWaritsuke().setKaigoNinteiShinsakaiKaisaiNo(介護認定審査会番号);
        ヘッドエリア検索();
        対象者一覧ソートラベル();
        対象者一覧検索();
        候補者一覧検索();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
    }

    /**
     * フッターエリアを設定。
     */
    public void setCommonButtonDisabled() {
        RString 進捗状況 = div.getTxtStatus().getValue();
        if (ShinsakaiShinchokuJokyo.中止.get画面表示名称().equals(進捗状況) || ShinsakaiShinchokuJokyo.完了.get画面表示名称().equals(進捗状況)) {
            div.getBtnJidoWaritsuke().setDisabled(true);
            div.getBtnWaritsuke().setDisabled(true);
            div.getBtnWaritsukeKaijo().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(登録する, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, false);
        }
        if (!ShinsakaiShinchokuJokyo.未開催.get画面表示名称().equals(進捗状況)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
        }
    }

    /**
     * 対象者一覧を検索する。
     */
    public void 対象者一覧検索() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        boolean isダミー = div.getChkKenshuMogi().getSelectedKeys().contains(研修模擬_KEY);
        TaishouIchiranMapperParameter parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), isダミー);
        List<Taishouichiran> ichiranList = finder.get対象者一覧(parameter);
        set対象者一覧(ichiranList);
    }

    /**
     * 候補者一覧を検索する。
     */
    public void 候補者一覧検索() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        RString マスキングチェックタイミング = DbBusinessConfig.get(ConfigNameDBE.マスキングチェックタイミング, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        boolean is一次判定後 = 一次判定後.equals(マスキングチェックタイミング);
        boolean isダミー = div.getChkKenshuMogi().getSelectedKeys().contains(研修模擬_KEY);
        KohoshaIchiranMapperParameter parameter = KohoshaIchiranMapperParameter.createKohoshaIchiranMapperParameter(
                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), is一次判定後, isダミー);
        List<KohoshaIchiran> ichiranList = finder.get候補者一覧(parameter);
        set候補者一覧(ichiranList);
    }

    /**
     * 簡易割付処理。
     */
    public void 簡易割付処理() {
        List<dgWaritsukeKohoshaIchiran_Row> rows = new ArrayList();
        rows.addAll(div.getDgWaritsukeKohoshaIchiran().getDataSource());
        for (dgWaritsukeKohoshaIchiran_Row row : rows) {
            if (div.getTxtWaritsukeNinzu().getValue().intValue() < div.getTxtYoteiTeiin().getValue().intValue()) {
                if (!isオブザーバーチェックOK(row)) {
                    continue;
                }
                候補者移転処理(row);
                div.getTxtWaritsukeNinzu().setValue(div.getTxtWaritsukeNinzu().getValue().add(1));
                if (div.getTxtWaritsukeNinzu().getValue().equals(div.getTxtYoteiTeiin().getValue())) {
                    break;
                }
            }
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
    }

    /**
     * 割付処理。
     */
    public void 割付処理() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
        for (dgWaritsukeKohoshaIchiran_Row row : div.getDgWaritsukeKohoshaIchiran().getSelectedItems()) {
            候補者移転処理(row);
        }
        div.getTxtWaritsukeNinzu().setValue(new Decimal(div.getDgTaishoshaIchiran().getDataSource().size()));
    }

    /**
     * 対象者移動。
     */
    public void 対象者移動() {
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getSelectedItems()) {
            対象者移転処理(row);
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
        div.getTxtWaritsukeNinzu().setValue(new Decimal(div.getDgTaishoshaIchiran().getDataSource().size()));
    }

    /**
     * 審査会順序を振りなおす。
     */
    public void 審査会順序を振りなおす() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        RString カスタムコンフィグの審査会順序 = BusinessConfig.get(DbeConfigKey.審査会順序, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        boolean 審査会資料作成済込み有無 = div.getChkShiryosakuseizumiKomi().getSelectedKeys().contains(new RString("key0"));
        List<dgTaishoshaIchiran_Row> 対象者リスト = div.getDgTaishoshaIchiran().getDataSource();
        List<dgTaishoshaIchiran_Row> 固定対象者リスト = new ArrayList<>();
        List<dgTaishoshaIchiran_Row> ソート対象者リスト = new ArrayList<>();
        List<Taishouichiran> ichiranList;
        TaishouIchiranMapperParameter parameter;
        boolean isダミー = div.getChkKenshuMogi().getSelectedKeys().contains(研修模擬_KEY);
        if (審査会資料作成済込み有無) {
            if (RString.isNullOrEmpty(カスタムコンフィグの審査会順序)) {
                parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), true, 審査会資料作成済込み有無, isダミー);
            } else {
                parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), カスタムコンフィグの審査会順序, true, 審査会資料作成済込み有無, isダミー);
            }
            ichiranList = finder.get対象者一覧(parameter);
            for (Taishouichiran taishoshaichiran : ichiranList) {
                if (is対象者Gridに存在する(taishoshaichiran)) {
                    dgTaishoshaIchiran_Row currentRow = set対象者一覧Row(taishoshaichiran);
                    ソート対象者リスト.add(currentRow);
                    対象者リスト.remove(currentRow);
                }
            }
        } else {
            for (int count = 0; count < 対象者リスト.size(); count++) {
                dgTaishoshaIchiran_Row currentRow = 対象者リスト.get(count);
                if (currentRow.getShinsakaiShiryoSakuseiYMD() != null
                        && currentRow.getShinsakaiShiryoSakuseiYMD().getText() != null
                        && !RString.isNullOrEmpty(currentRow.getShinsakaiShiryoSakuseiYMD().getText())) {
                    固定対象者リスト.add(currentRow);
                    対象者リスト.remove(currentRow);
                    count--;
                }
            }
            if (RString.isNullOrEmpty(カスタムコンフィグの審査会順序)) {
                parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), true, 審査会資料作成済込み有無, isダミー);
            } else {
                parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), カスタムコンフィグの審査会順序, true, 審査会資料作成済込み有無, isダミー);
            }
            ichiranList = finder.get対象者一覧(parameter);
            for (Taishouichiran taishoshaichiran : ichiranList) {
                if (is対象者Gridに存在する(taishoshaichiran)) {
                    dgTaishoshaIchiran_Row currentRow = set対象者一覧Row(taishoshaichiran);
                    ソート対象者リスト.add(currentRow);
                    対象者リスト.remove(currentRow);
                }
            }
        }
        setソート対象者一覧(固定対象者リスト, ソート対象者リスト);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(登録する, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
        div.getBtnJidoWaritsuke().setDisabled(true);
        div.getBtnWaritsuke().setDisabled(true);
        div.getBtnWaritsukeKaijo().setDisabled(true);
    }

    private void setソート対象者一覧(List<dgTaishoshaIchiran_Row> 固定対象者リスト,
            List<dgTaishoshaIchiran_Row> ソート対象者リスト) {
        List<dgTaishoshaIchiran_Row> ソート後リスト = 固定対象者リスト;
        boolean 審査会資料作成済込み有無 = div.getChkShiryosakuseizumiKomi().getSelectedKeys().contains(new RString("key0"));
        int 最大確定No = 0;
        if (!ソート後リスト.isEmpty()) {
            最大確定No = ソート後リスト.get(ソート後リスト.size() - 1).getNo().toInt();
        }
        if (審査会資料作成済込み有無) {
            for (dgTaishoshaIchiran_Row row : ソート対象者リスト) {
                最大確定No++;
                row.setNo(new RString(最大確定No));
                ソート後リスト.add(row);
            }
        } else {
            for (dgTaishoshaIchiran_Row row : ソート対象者リスト) {
                最大確定No++;
                row.setNo(new RString(最大確定No));
                ソート後リスト.add(row);
            }
        }
        div.getDgTaishoshaIchiran().setDataSource(ソート後リスト);
        ViewStateHolder.put(ViewStateKeys.番号, new RString(最大確定No));
    }

    /**
     * 審査会順序確定。
     */
    public void 審査会順序確定() {
        int max確定No = 0;
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            row.setShinsajunKakuteiFlag(審査順確定フラグ_確定);
            row.setTorokuZumiNo(row.getNo());
            if (row.getNo().toInt() > max確定No) {
                max確定No = row.getNo().toInt();
            }
        }
        ViewStateHolder.put(ViewStateKeys.番号, new RString(max確定No));
        CommonButtonHolder.setDisabledByCommonButtonFieldName(登録する, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
        if (ShinsakaiShinchokuJokyo.未開催.get画面表示名称().equals(div.getTxtStatus().getValue())) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, false);
        }
        div.getBtnJidoWaritsuke().setDisabled(false);
        div.getBtnWaritsuke().setDisabled(false);
        div.getBtnWaritsukeKaijo().setDisabled(false);
    }

    /**
     * 介護認定審査会割付情報更新。
     */
    public void 介護認定審査会割付情報更新() {
        対象者一覧更新();
        候補者一覧更新();
        介護認定審査会開催予定情報更新(true);
    }

    /**
     * 介護認定審査会開催予定情報更新。
     *
     * @param is登録ボタン押下 is登録ボタン押下
     */
    public void 介護認定審査会開催予定情報更新(boolean is登録ボタン押下) {
        ShinsakaiKaisaiYoteiJohoManager johoManager = ShinsakaiKaisaiYoteiJohoManager.createInstance();
        ShinsakaiKaisaiYoteiJohoMapperParameter mapperParameter
                = ShinsakaiKaisaiYoteiJohoMapperParameter.createSelectByKeyParam(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        ShinsakaiKaisaiYoteiJoho2 joho = johoManager.get介護認定審査会開催予定情報(mapperParameter);
        if (joho != null) {
            ShinsakaiKaisaiYoteiJoho2Builder builder = joho.createBuilderForEdit();
            if (is登録ボタン押下) {
                builder.set介護認定審査会割当済み人数(div.getTxtWaritsukeNinzu().getValue().intValue());
            } else {
                builder.set介護認定審査会進捗状況(new Code(ShinsakaiShinchokuJokyo.未開催_割付完了.getコード()));
            }
            List<dgTaishoshaIchiran_Row> taishoshaIchiranList = div.getDgTaishoshaIchiran().getDataSource();
            if (taishoshaIchiranList == null || taishoshaIchiranList.isEmpty()) {
                builder.set介護認定審査会進捗状況(new Code(ShinsakaiShinchokuJokyo.未開催.getコード()));
            }
            johoManager.save(builder.build().modifiedModel());
        }
    }

    /**
     * isオブザーバーチェックOK。
     *
     * @param row 候補者一覧gridエリアの該当行
     * @return isオブザーバーチェックOK
     */
    public boolean isオブザーバーチェックOK(dgWaritsukeKohoshaIchiran_Row row) {
        return !row.getObserverCheckShujii().getIcon().equals(IconType.Warning)
                && !row.getObserverCheckChosain().getIcon().equals(IconType.Warning)
                && !row.getObserverCheckNyushoShisetsu().getIcon().equals(IconType.Warning)
                && !row.getObserverCheckSonota().getIcon().equals(IconType.Warning);
    }

    /**
     * is割付チェックOK。
     *
     * @param div 介護認定審査会対象者割付
     * @return true:予定定員内 false:予定定員外
     */
    public boolean is割付チェックOK(TaishouWaritsukeDiv div) {
        return div.getTxtWaritsukeNinzu().getValue().intValue() + div.getDgWaritsukeKohoshaIchiran().getSelectedItems().size()
                <= div.getTxtYoteiTeiin().getValue().intValue();
    }

    private boolean isオブザーバーチェックOK(ShinseishoKanriNo shinseishoKanriNo, boolean is主治医, boolean is調査員, boolean is入所施設) {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        ParamEntity entity = finder.getParamData(shinseishoKanriNo);
        boolean is機関まで = DbBusinessConfig.get(ConfigNameDBE.オブザーバーチェック, RDate.getNowDate(), SubGyomuCode.DBE認定支援).equals(機関まで);
        if (entity != null) {
            if (is入所施設 && (entity.get入所施設コード() == null || entity.get入所施設コード().isEmpty())) {
                return true;
            }
            CountShinsakaiWariateIinJohoMapperParameter param = CountShinsakaiWariateIinJohoMapperParameter.createCountKohoshaIchiranMapperParameter(
                    is機関まで,
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                    entity.get主治医医療機関コード() == null ? RString.EMPTY : entity.get主治医医療機関コード().getColumnValue(),
                    entity.get調査委託先コード() == null ? RString.EMPTY : entity.get調査委託先コード().getColumnValue(),
                    entity.get入所施設コード() == null ? RString.EMPTY : entity.get入所施設コード().getColumnValue(),
                    entity.get主治医コード() == null ? RString.EMPTY : entity.get主治医コード().getColumnValue(),
                    entity.get調査員コード() == null ? RString.EMPTY : entity.get調査員コード().getColumnValue(),
                    is主治医,
                    is調査員,
                    is入所施設,
                    entity.get市町村コード());
            if (!finder.is申請者オブザーバーチェックOK(param)) {
                return false;
            }
        }
        return true;
    }

    private boolean isオブザーバーチェックその他OK(ShinseishoKanriNo shinseishoKanriNo) {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        CountShinsakaiIinJogaiJohoMapperParameter csijjmp
                = CountShinsakaiIinJogaiJohoMapperParameter.createCountShinsakaiIinJogaiJohoMapperParameter(
                        shinseishoKanriNo.getColumnValue(),
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        return finder.is審査会委員除外存在チェックOK(csijjmp);
    }

    private void 対象者一覧ソートラベル() {
        RStringBuilder sortBuilder = new RStringBuilder();
        RString sort = new RString("ソート順：");
        RString 審査会順序_表示用 = DbBusinessConfig.get(ConfigNameDBE.審査会順序_表示用, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        sortBuilder.append(sort).append(審査会順序_表示用);
        div.getLblTaishoshaSort().setText(sortBuilder.toRString());
    }

    private void ヘッドエリア検索() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        TaishouWaritsukeHead waritsukeHead = finder.getヘッドエリア(div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        if (waritsukeHead != null) {
            div.getTxtShinsakaiName().setValue(waritsukeHead.get審査会名称());
            div.getTxtGogitaiNumber().setValue(waritsukeHead.get合議体名称());
            div.getTxtYoteiTeiin().setValue(new Decimal(waritsukeHead.get予定定員()));
            div.getTxtWaritsukeNinzu().setValue(new Decimal(waritsukeHead.get割付人数()));
            RString 進捗状況;
            try {
                進捗状況 = ShinsakaiShinchokuJokyo.toValue(waritsukeHead.get進捗状況().getColumnValue()).get画面表示名称();
            } catch (IllegalArgumentException e) {
                進捗状況 = RString.EMPTY;
            }
            div.getTxtStatus().setValue(進捗状況);
            div.getTxtShinsakaiKaijo().setValue(waritsukeHead.get介護認定審査会開催場所名称());
            div.getTxtShinsakaiChiku().setValue(waritsukeHead.get地区コード().getColumnValue());
            div.getTxtShinsakauChikuName().setValue(
                    CodeMaster.getCodeMeisho(
                            SubGyomuCode.DBE認定支援, new CodeShubetsu("5001"), waritsukeHead.get地区コード(), FlexibleDate.getNowDate()));
            div.getTxtKaisaiDate().setValue(waritsukeHead.get開催予定日());
            div.getTxtYoteiKaishiTime().setValue(new RTime(waritsukeHead.get予定開始時間()));
            div.getTxtYoteiShuryoTime().setValue(new RTime(waritsukeHead.get予定終了時間()));
            set審査会種類_精神科医所属(waritsukeHead.is合議体精神科医存在フラグ());
            set研修模擬(waritsukeHead.is合議体ダミーフラグ());
        }
    }

    private void set審査会種類_精神科医所属(boolean 合議体精神科医存在フラグ) {
        List<RString> list = new ArrayList<>();
        if (合議体精神科医存在フラグ) {
            list.add(合議体精神科医存在フラグ_KEY);
        }
        div.getChkNinchishoOnly().setSelectedItemsByKey(list);
    }

    private void set研修模擬(boolean 合議体ダミーフラグ) {
        List<RString> list = new ArrayList<>();
        if (合議体ダミーフラグ) {
            list.add(研修模擬_KEY);
        }
        div.getChkKenshuMogi().setSelectedItemsByKey(list);
    }

    private void set対象者一覧(List<Taishouichiran> ichiranList) {
        List<dgTaishoshaIchiran_Row> rows = new ArrayList<>();
        dgTaishoshaIchiran_Row row;
        RString 最大登録済No = ZERO;
        for (Taishouichiran taishouichiran : ichiranList) {
            row = set対象者一覧Row(taishouichiran);
            RString no = new RString(Integer.toString(taishouichiran.get介護認定審査会審査順()));
            RString 登録済No = no;
            rows.add(row);
            if (登録済No.toInt() > 最大登録済No.toInt()) {
                最大登録済No = 登録済No;
            }
        }
        div.getDgTaishoshaIchiran().setDataSource(rows);
        ViewStateHolder.put(ViewStateKeys.番号, 最大登録済No);
    }

    private dgTaishoshaIchiran_Row set対象者一覧Row(Taishouichiran taishouichiran) {
        RString 優先;
        RString 性別;
        RString 被保区分;
        RString 申請区分_申請時;
        TextBoxFlexibleDate 認定申請日;
        TextBoxFlexibleDate 前回有効期間開始日;
        TextBoxFlexibleDate 前回有効期間終了日;
        TextBoxFlexibleDate 審査会資料作成日;
        RString 調査票_寝たきり度;
        RString 調査票_認知度;
        RString 意見書_寝たきり度;
        RString 意見書_認知度;
        RString 再調査;
        RString 今回一次判定 = RString.EMPTY;
        RString 前回一次判定 = RString.EMPTY;
        RString 前回二次判定 = RString.EMPTY;
        dgTaishoshaIchiran_Row row;
        RString 認定審査会割付完了日 = RString.EMPTY;
        Icon オブザーバーチェック_主治医;
        Icon オブザーバーチェック_調査員;
        Icon オブザーバーチェック_入所施設;
        Icon オブザーバーチェック_その他;
        TextBoxFlexibleDate 審査会資料送付日;
        認定申請日 = new TextBoxFlexibleDate();
        前回有効期間開始日 = new TextBoxFlexibleDate();
        前回有効期間終了日 = new TextBoxFlexibleDate();
        審査会資料作成日 = new TextBoxFlexibleDate();
        RString no = new RString(Integer.toString(taishouichiran.get介護認定審査会審査順()));
        RString 登録済No = no;
        Boolean 登録済フラグ = true;
        審査会資料送付日 = new TextBoxFlexibleDate();
        オブザーバーチェック_主治医 = new Icon();
        オブザーバーチェック_調査員 = new Icon();
        オブザーバーチェック_入所施設 = new Icon();
        オブザーバーチェック_その他 = new Icon();
        try {
            優先 = taishouichiran.get介護認定審査会優先振分区分コード().getColumnValue().equals(new RString("1"))
                    ? ShinsakaiYusenWaritsukeKubunCode.toValue(taishouichiran.get介護認定審査会優先振分区分コード().getColumnValue()).get名称()
                    : RString.EMPTY;
        } catch (IllegalArgumentException e) {
            優先 = RString.EMPTY;
        }
        try {
            性別 = Seibetsu.toValue(taishouichiran.get性別().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            性別 = RString.EMPTY;
        }
        try {
            被保区分 = HihokenshaKubunCode.toValue(taishouichiran.get被保険者区分コード()).get名称();
        } catch (IllegalArgumentException e) {
            被保区分 = RString.EMPTY;
        }
        try {
            申請区分_申請時 = NinteiShinseiShinseijiKubunCode.toValue(taishouichiran.get認定申請区分_申請時コード().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            申請区分_申請時 = RString.EMPTY;
        }
        認定申請日.setValue(taishouichiran.get認定申請年月日());
        前回有効期間開始日.setValue(taishouichiran.get前回認定有効期間_開始());
        前回有効期間終了日.setValue(taishouichiran.get前回認定有効期間_終了());
        審査会資料作成日.setValue(taishouichiran.get審査会資料作成年月日());
        try {
            調査票_寝たきり度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                    taishouichiran.get調査票_障害高齢者の日常生活自立度コード().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            調査票_寝たきり度 = RString.EMPTY;
        }
        try {
            調査票_認知度 = NinchishoNichijoSeikatsuJiritsudoCode.toValue(
                    taishouichiran.get調査票_認知症高齢者の日常生活自立度コード().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            調査票_認知度 = RString.EMPTY;
        }
        try {
            意見書_寝たきり度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                    taishouichiran.get意見書_障害高齢者の日常生活自立度コード().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            意見書_寝たきり度 = RString.EMPTY;
        }
        try {
            意見書_認知度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                    taishouichiran.get意見書_認知症高齢者の日常生活自立度コード().getColumnValue()).get名称();
        } catch (IllegalArgumentException e) {
            意見書_認知度 = RString.EMPTY;
        }
        再調査 = new RString(Integer.toString(taishouichiran.get再調査依頼回数()));
        if (taishouichiran.get厚労省IF識別コード() != null || !taishouichiran.get厚労省IF識別コード().isEmpty()) {
            RString 厚労省IF識別コード = taishouichiran.get厚労省IF識別コード().value().substringEmptyOnError(0, 2);
            今回一次判定 = set今回一次判定区分(taishouichiran.get要介護認定一次判定結果コード(), 厚労省IF識別コード, 今回一次判定);
            RString 前回厚労省IF識別コード = taishouichiran.get前回厚労省IF識別コード().value().substringEmptyOnError(0, 2);
            前回一次判定 = set前回一次判定区分(taishouichiran.get要介護認定前回一次判定結果コード(), 前回厚労省IF識別コード, 前回一次判定);
            前回二次判定 = set前回二次判定区分(taishouichiran.get二次判定要介護状態区分コード(), 前回厚労省IF識別コード, 前回二次判定);
        }
        if (taishouichiran.get認定審査会割付完了年月日() != null && !taishouichiran.get認定審査会割付完了年月日().isEmpty()) {
            認定審査会割付完了日 = new RString(taishouichiran.get認定審査会割付完了年月日().toString());
        }
        審査会資料送付日.setValue(taishouichiran.get審査会資料送付年月日());
        if (!isオブザーバーチェックOK(taishouichiran.get申請書管理番号(), true, false, false)) {
            オブザーバーチェック_主治医.setIcon(IconType.Warning);
        }
        if (!isオブザーバーチェックOK(taishouichiran.get申請書管理番号(), false, true, false)) {
            オブザーバーチェック_調査員.setIcon(IconType.Warning);
        }
        if (!isオブザーバーチェックOK(taishouichiran.get申請書管理番号(), false, false, true)) {
            オブザーバーチェック_入所施設.setIcon(IconType.Warning);
        }
        if (!isオブザーバーチェックその他OK(taishouichiran.get申請書管理番号())) {
            オブザーバーチェック_その他.setIcon(IconType.Warning);
        }
        row = new dgTaishoshaIchiran_Row(
                対象者一覧状態フラグ,
                taishouichiran.get介護認定審査会審査順確定フラグ() ? 審査順確定フラグ_確定 : 審査順確定フラグ_確定しない,
                taishouichiran.get申請書管理番号().getColumnValue(),
                no,
                優先,
                taishouichiran.get被保険者番号(),
                taishouichiran.get被保険者氏名().getColumnValue(),
                性別,
                被保区分,
                申請区分_申請時,
                認定申請日,
                前回有効期間開始日,
                前回有効期間終了日,
                審査会資料作成日,
                今回一次判定,
                taishouichiran.getマスキング完了年月日().wareki().toDateString(),
                taishouichiran.get証記載保険者番号().getColumnValue(),
                taishouichiran.get市町村名称(),
                前回一次判定,
                前回二次判定,
                調査票_寝たきり度,
                調査票_認知度,
                意見書_寝たきり度,
                意見書_認知度,
                taishouichiran.get入所施設(),
                taishouichiran.get事業者名称(),
                taishouichiran.get調査員氏名(),
                再調査,
                taishouichiran.get医療機関名称(),
                taishouichiran.get主治医氏名().getColumnValue(),
                オブザーバーチェック_主治医,
                オブザーバーチェック_調査員,
                オブザーバーチェック_入所施設,
                オブザーバーチェック_その他,
                登録済フラグ,
                登録済No,
                認定審査会割付完了日,
                審査会資料送付日
        );
        return row;
    }

    private RString set前回二次判定区分(Code code, RString 厚労省IF識別コード, RString 前回二次判定) {
        if (!code.isEmpty()) {
            if (厚労省IF識別コード.equals(厚労省IF識別コード_09)) {
                前回二次判定 = YokaigoJotaiKubun09.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_06)) {
                前回二次判定 = YokaigoJotaiKubun06.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_02)) {
                前回二次判定 = YokaigoJotaiKubun02.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_99)) {
                前回二次判定 = YokaigoJotaiKubun99.toValue(code.value()).get名称();
            }
        } else {
            前回二次判定 = RString.EMPTY;
        }
        return 前回二次判定;
    }

    private RString set前回一次判定区分(Code code, RString 厚労省IF識別コード, RString 前回一次判定) {
        if (!code.isEmpty()) {
            if (厚労省IF識別コード.equals(厚労省IF識別コード_09)) {
                前回一次判定 = IchijiHanteiKekkaCode09.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_06)) {
                前回一次判定 = IchijiHanteiKekkaCode06.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_02)) {
                前回一次判定 = IchijiHanteiKekkaCode02.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_99)) {
                前回一次判定 = IchijiHanteiKekkaCode99.toValue(code.value()).get名称();
            }
        } else {
            前回一次判定 = RString.EMPTY;
        }
        return 前回一次判定;
    }

    private RString set今回一次判定区分(Code code, RString 厚労省IF識別コード, RString 今回一次判定) {
        if (!code.isEmpty()) {
            if (厚労省IF識別コード.equals(厚労省IF識別コード_09)) {
                今回一次判定 = IchijiHanteiKekkaCode09.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_06)) {
                今回一次判定 = IchijiHanteiKekkaCode06.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_02)) {
                今回一次判定 = IchijiHanteiKekkaCode02.toValue(code.value()).get名称();
            } else if (厚労省IF識別コード.equals(厚労省IF識別コード_99)) {
                今回一次判定 = IchijiHanteiKekkaCode99.toValue(code.value()).get名称();
            }
        } else {
            今回一次判定 = RString.EMPTY;
        }
        return 今回一次判定;
    }

    private void set候補者一覧(List<KohoshaIchiran> ichiranList) {
        int no = 1;
        List<dgWaritsukeKohoshaIchiran_Row> rows = new ArrayList<>();
        RString 優先;
        RString 性別;
        RString 被保区分;
        RString 申請区分_申請時;
        TextBoxFlexibleDate 認定申請日;
        TextBoxFlexibleDate 前回有効期間開始日;
        TextBoxFlexibleDate 前回有効期間終了日;
        RString 調査票_寝たきり度;
        RString 調査票_認知度;
        RString 意見書_寝たきり度;
        RString 意見書_認知度;
        RString 再調査;
        RString 今回一次判定;
        RString 前回一次判定;
        RString 前回二次判定;
        Icon オブザーバーチェック_主治医;
        Icon オブザーバーチェック_調査員;
        Icon オブザーバーチェック_入所施設;
        Icon オブザーバーチェック_その他;
        dgWaritsukeKohoshaIchiran_Row row;
        for (KohoshaIchiran kohoshaIchiran : ichiranList) {
            認定申請日 = new TextBoxFlexibleDate();
            前回有効期間開始日 = new TextBoxFlexibleDate();
            前回有効期間終了日 = new TextBoxFlexibleDate();
            RString 登録済No = ZERO;
            Boolean 登録済フラグ = false;
            オブザーバーチェック_主治医 = new Icon();
            オブザーバーチェック_調査員 = new Icon();
            オブザーバーチェック_入所施設 = new Icon();
            オブザーバーチェック_その他 = new Icon();
            今回一次判定 = RString.EMPTY;
            前回一次判定 = RString.EMPTY;
            前回二次判定 = RString.EMPTY;
            try {
                優先 = kohoshaIchiran.get介護認定審査会優先振分区分コード().getColumnValue().equals(new RString("1"))
                        ? ShinsakaiYusenWaritsukeKubunCode.toValue(kohoshaIchiran.get介護認定審査会優先振分区分コード().getColumnValue()).get名称()
                        : RString.EMPTY;
            } catch (IllegalArgumentException e) {
                優先 = RString.EMPTY;
            }
            try {
                性別 = Seibetsu.toValue(kohoshaIchiran.get性別().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                性別 = RString.EMPTY;
            }
            try {
                被保区分 = HihokenshaKubunCode.toValue(kohoshaIchiran.get被保険者区分コード()).get名称();
            } catch (IllegalArgumentException e) {
                被保区分 = RString.EMPTY;
            }
            try {
                申請区分_申請時 = NinteiShinseiShinseijiKubunCode.toValue(kohoshaIchiran.get認定申請区分_申請時コード().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                申請区分_申請時 = RString.EMPTY;
            }
            認定申請日.setValue(kohoshaIchiran.get認定申請年月日());
            前回有効期間開始日.setValue(kohoshaIchiran.get前回認定有効期間_開始());
            前回有効期間終了日.setValue(kohoshaIchiran.get前回認定有効期間_終了());
            try {
                調査票_寝たきり度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                        kohoshaIchiran.get調査票_障害高齢者の日常生活自立度コード().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                調査票_寝たきり度 = RString.EMPTY;
            }
            try {
                調査票_認知度 = NinchishoNichijoSeikatsuJiritsudoCode.toValue(
                        kohoshaIchiran.get調査票_認知症高齢者の日常生活自立度コード().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                調査票_認知度 = RString.EMPTY;
            }
            try {
                意見書_寝たきり度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                        kohoshaIchiran.get意見書_障害高齢者の日常生活自立度コード().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                意見書_寝たきり度 = RString.EMPTY;
            }
            try {
                意見書_認知度 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(
                        kohoshaIchiran.get意見書_認知症高齢者の日常生活自立度コード().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                意見書_認知度 = RString.EMPTY;
            }
            再調査 = new RString(Integer.toString(kohoshaIchiran.get再調査依頼回数()));
            if (kohoshaIchiran.get厚労省IF識別コード() != null || !kohoshaIchiran.get厚労省IF識別コード().isEmpty()) {
                RString 厚労省IF識別コード = kohoshaIchiran.get厚労省IF識別コード().value().substringEmptyOnError(0, 2);
                今回一次判定 = set今回一次判定区分(kohoshaIchiran.get要介護認定一次判定結果コード(), 厚労省IF識別コード, 今回一次判定);
                RString 前回厚労省IF識別コード = kohoshaIchiran.get前回厚労省IF識別コード().value().substringEmptyOnError(0, 2);
                前回一次判定 = set前回一次判定区分(kohoshaIchiran.get要介護認定前回一次判定結果コード(), 前回厚労省IF識別コード, 前回一次判定);
                前回二次判定 = set前回二次判定区分(kohoshaIchiran.get二次判定要介護状態区分コード(), 前回厚労省IF識別コード, 前回二次判定);
            }
            if (!isオブザーバーチェックOK(kohoshaIchiran.get申請書管理番号(), true, false, false)) {
                オブザーバーチェック_主治医.setIcon(IconType.Warning);
            }
            if (!isオブザーバーチェックOK(kohoshaIchiran.get申請書管理番号(), false, true, false)) {
                オブザーバーチェック_調査員.setIcon(IconType.Warning);
            }
            if (!isオブザーバーチェックOK(kohoshaIchiran.get申請書管理番号(), false, false, true)) {
                オブザーバーチェック_入所施設.setIcon(IconType.Warning);
            }
            if (!isオブザーバーチェックその他OK(kohoshaIchiran.get申請書管理番号())) {
                オブザーバーチェック_その他.setIcon(IconType.Warning);
            }
            row = new dgWaritsukeKohoshaIchiran_Row(
                    候補者一覧状態フラグ,
                    審査順確定フラグ_確定しない,
                    kohoshaIchiran.get申請書管理番号().getColumnValue(),
                    new RString(String.valueOf(no++)),
                    優先,
                    kohoshaIchiran.get被保険者番号(),
                    kohoshaIchiran.get被保険者氏名().getColumnValue(),
                    性別,
                    被保区分,
                    申請区分_申請時,
                    認定申請日,
                    前回有効期間開始日,
                    前回有効期間終了日,
                    new TextBoxFlexibleDate(),
                    今回一次判定,
                    kohoshaIchiran.getマスキング完了年月日().wareki().toDateString(),
                    kohoshaIchiran.get証記載保険者番号().getColumnValue(),
                    kohoshaIchiran.get市町村名称(),
                    前回一次判定,
                    前回二次判定,
                    調査票_寝たきり度,
                    調査票_認知度,
                    意見書_寝たきり度,
                    意見書_認知度,
                    kohoshaIchiran.get入所施設(),
                    kohoshaIchiran.get事業者名称(),
                    kohoshaIchiran.get調査員氏名(),
                    再調査,
                    kohoshaIchiran.get医療機関名称(),
                    kohoshaIchiran.get主治医氏名().getColumnValue(),
                    オブザーバーチェック_主治医,
                    オブザーバーチェック_調査員,
                    オブザーバーチェック_入所施設,
                    オブザーバーチェック_その他,
                    登録済フラグ,
                    登録済No,
                    new TextBoxFlexibleDate()
            );
            rows.add(row);
        }
        div.getDgWaritsukeKohoshaIchiran().setDataSource(rows);
    }

    private void 候補者移転処理(dgWaritsukeKohoshaIchiran_Row kohoshaIchiran_Row) {
        int 対象者一覧GridMaxNo = ViewStateHolder.get(ViewStateKeys.番号, RString.class).toInt();
        for (dgTaishoshaIchiran_Row currentRow : div.getDgTaishoshaIchiran().getDataSource()) {
            if (currentRow.getNo().toInt() > 対象者一覧GridMaxNo) {
                対象者一覧GridMaxNo = currentRow.getNo().toInt();
            }
        }

        RString no;
        if (kohoshaIchiran_Row.getTorokuZumiFlag()) {
            no = kohoshaIchiran_Row.getTorokuZumiNo();
        } else {
            no = new RString(対象者一覧GridMaxNo + 1);
        }

        dgTaishoshaIchiran_Row taishoshaIchiran_Row = new dgTaishoshaIchiran_Row(
                kohoshaIchiran_Row.getJotaiFlag(),
                審査順確定フラグ_確定,
                kohoshaIchiran_Row.getShinseishoKanriNo(),
                no,
                kohoshaIchiran_Row.getPriority(),
                kohoshaIchiran_Row.getHihokenshaNumber(),
                kohoshaIchiran_Row.getShimei(),
                kohoshaIchiran_Row.getSeibetsu(),
                kohoshaIchiran_Row.getHihokenshaKubun(),
                kohoshaIchiran_Row.getSihinseiKubunShinseiji(),
                kohoshaIchiran_Row.getShinseiDay(),
                kohoshaIchiran_Row.getZenkaiYukoKikanKaishiDay(),
                kohoshaIchiran_Row.getZenkaiYukoKikanShuryoDay(),
                kohoshaIchiran_Row.getShinsakaiShiryoSakuseiYMD(),
                kohoshaIchiran_Row.getKonkaiIchijiHantei(),
                kohoshaIchiran_Row.getMasking(),
                kohoshaIchiran_Row.getHokenshaNo(),
                kohoshaIchiran_Row.getHokenshaName(),
                kohoshaIchiran_Row.getZenkaiIchijiHantei(),
                kohoshaIchiran_Row.getZenkaiNijiHantei(),
                kohoshaIchiran_Row.getChosahyoNetakirido(),
                kohoshaIchiran_Row.getChosahyoNinchido(),
                kohoshaIchiran_Row.getIkenshoNetakirido(),
                kohoshaIchiran_Row.getIkenshoNinchido(),
                kohoshaIchiran_Row.getNyushiShisetsu(),
                kohoshaIchiran_Row.getChosaKikan(),
                kohoshaIchiran_Row.getChosain(),
                kohoshaIchiran_Row.getSaiChosa(),
                kohoshaIchiran_Row.getIryoKikan(),
                kohoshaIchiran_Row.getShujii(),
                kohoshaIchiran_Row.getObserverCheckShujii(),
                kohoshaIchiran_Row.getObserverCheckChosain(),
                kohoshaIchiran_Row.getObserverCheckNyushoShisetsu(),
                kohoshaIchiran_Row.getObserverCheckSonota(),
                kohoshaIchiran_Row.getTorokuZumiFlag(),
                kohoshaIchiran_Row.getTorokuZumiNo(),
                RString.EMPTY,
                kohoshaIchiran_Row.getShinsakaiShiryoSofuYMD()
        );
        div.getDgTaishoshaIchiran().getDataSource().add(taishoshaIchiran_Row);
        div.getDgWaritsukeKohoshaIchiran().getDataSource().remove(kohoshaIchiran_Row);
        候補者一覧GridNo再割振(kohoshaIchiran_Row);
    }

    private void 対象者移転処理(dgTaishoshaIchiran_Row taishoshaIchiran_Row) {
        int 候補者一覧GridMaxNo = 0;
        for (dgWaritsukeKohoshaIchiran_Row currentRow : div.getDgWaritsukeKohoshaIchiran().getDataSource()) {
            if (currentRow.getNo().toInt() > 候補者一覧GridMaxNo) {
                候補者一覧GridMaxNo = currentRow.getNo().toInt();
            }
        }

        dgWaritsukeKohoshaIchiran_Row kohoshaIchiran_Row = new dgWaritsukeKohoshaIchiran_Row(
                taishoshaIchiran_Row.getJotaiFlag(),
                審査順確定フラグ_確定しない,
                taishoshaIchiran_Row.getShinseishoKanriNo(),
                new RString(候補者一覧GridMaxNo + 1),
                taishoshaIchiran_Row.getPriority(),
                taishoshaIchiran_Row.getHihokenshaNumber(),
                taishoshaIchiran_Row.getShimei(),
                taishoshaIchiran_Row.getSeibetsu(),
                taishoshaIchiran_Row.getHihokenshaKubun(),
                taishoshaIchiran_Row.getSihinseiKubunShinseiji(),
                taishoshaIchiran_Row.getShinseiDay(),
                taishoshaIchiran_Row.getZenkaiYukoKikanKaishiDay(),
                taishoshaIchiran_Row.getZenkaiYukoKikanShuryoDay(),
                taishoshaIchiran_Row.getShinsakaiShiryoSakuseiYMD(),
                taishoshaIchiran_Row.getKonkaiIchijiHantei(),
                taishoshaIchiran_Row.getMasking(),
                taishoshaIchiran_Row.getHokenshaNo(),
                taishoshaIchiran_Row.getHokenshaName(),
                taishoshaIchiran_Row.getZenkaiIchijiHantei(),
                taishoshaIchiran_Row.getZenkaiNijiHantei(),
                taishoshaIchiran_Row.getChosahyoNetakirido(),
                taishoshaIchiran_Row.getChosahyoNinchido(),
                taishoshaIchiran_Row.getIkenshoNetakirido(),
                taishoshaIchiran_Row.getIkenshoNinchido(),
                taishoshaIchiran_Row.getNyushiShisetsu(),
                taishoshaIchiran_Row.getChosaKikan(),
                taishoshaIchiran_Row.getChosain(),
                taishoshaIchiran_Row.getSaiChosa(),
                taishoshaIchiran_Row.getIryoKikan(),
                taishoshaIchiran_Row.getShujii(),
                taishoshaIchiran_Row.getObserverCheckShujii(),
                taishoshaIchiran_Row.getObserverCheckChosain(),
                taishoshaIchiran_Row.getObserverCheckNyushoShisetsu(),
                taishoshaIchiran_Row.getObserverCheckSonota(),
                taishoshaIchiran_Row.getTorokuZumiFlag(),
                taishoshaIchiran_Row.getTorokuZumiNo(),
                taishoshaIchiran_Row.getShinsakaiShiryoSofuYMD()
        );
        div.getDgTaishoshaIchiran().getDataSource().remove(taishoshaIchiran_Row);
        div.getDgWaritsukeKohoshaIchiran().getDataSource().add(kohoshaIchiran_Row);
        対象者一覧GridNo再割振();
    }

    private void 対象者一覧更新() {
        boolean isダミー = div.getChkKenshuMogi().getSelectedKeys().contains(研修模擬_KEY);
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            if (isダミー) {
                対象者一覧更新_研修(row);
            } else {
                対象者一覧更新_通常(row);
            }
        }
    }

    private void 対象者一覧更新_通常(dgTaishoshaIchiran_Row row) {
        ShinsakaiWariateJohoManager johoManager = ShinsakaiWariateJohoManager.createInstance();
        if (row.getJotaiFlag().equals(new RString("1"))) {
            ShinsakaiWariateJohoMapperParameter mapperParameter
                    = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(
                            div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            ShinsakaiWariateJoho2 shinsakaiWariateJoho = johoManager.get介護認定審査会割当情報(mapperParameter);
            if (shinsakaiWariateJoho != null && row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定)) {
                ShinsakaiWariateJoho2Builder johoBuilder = shinsakaiWariateJoho.createBuilderForEdit();
                johoBuilder.set介護認定審査会審査順(row.getNo().toInt());
                johoBuilder.set介護認定審査会審査順確定フラグ(shinsakaiWariateJoho.is介護認定審査会審査順確定フラグ());
                johoManager.save介護認定審査会割当情報(johoBuilder.build().modifiedModel());
            }
        }
        if (row.getJotaiFlag().equals(new RString("2"))) {
            ShinsakaiWariateJoho2 shinsakaiWariateJoho = new ShinsakaiWariateJoho2(
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            ShinsakaiWariateJoho2Builder builder = shinsakaiWariateJoho.createBuilderForEdit();
            builder.set介護認定審査会開催年月日(div.getTxtKaisaiDate().getValue());
            builder.set介護認定審査会割当年月日(new FlexibleDate(RDate.getNowDate().toString()));
            builder.set介護認定審査会審査順(row.getNo().toInt());
            builder.set介護認定審査会審査順確定フラグ(row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定));
            builder.set審査会自動割付フラグ(IsShinsakaiJidoWaritsuke.手動.is審査会自動割付());
            johoManager.save介護認定審査会割当情報(builder.build().modifiedModel());
        }
    }

    private void 対象者一覧更新_研修(dgTaishoshaIchiran_Row row) {
        ShinsakaiWariateJohoKenshuManager johoManager = ShinsakaiWariateJohoKenshuManager.createInstance();
        if (row.getJotaiFlag().equals(new RString("1"))) {
            RString shinsakaiKaisaiNo = div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo();
            ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());
            ShinsakaiWariateJohoKenshu shinsakaiWariateJohoKenshu = johoManager.get審査会割当情報研修(shinsakaiKaisaiNo, shinseishoKanriNo);
            if (shinsakaiWariateJohoKenshu != null && row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定)) {
                ShinsakaiWariateJohoKenshuBuilder johoBuilder = shinsakaiWariateJohoKenshu.createBuilderForEdit();
                johoBuilder.set介護認定審査会審査順(row.getNo().toInt());
                johoBuilder.set介護認定審査会審査順確定フラグ(shinsakaiWariateJohoKenshu.is介護認定審査会審査順確定フラグ());
                johoManager.save介護認定審査会割当情報研修(johoBuilder.build().modifiedModel());
            }
        }
        if (row.getJotaiFlag().equals(new RString("2"))) {
            ShinsakaiWariateJohoKenshu shinsakaiWariateJohoKenshu = new ShinsakaiWariateJohoKenshu(
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                    new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            ShinsakaiWariateJohoKenshuBuilder builder = shinsakaiWariateJohoKenshu.createBuilderForEdit();
            builder.set介護認定審査会開催年月日(div.getTxtKaisaiDate().getValue());
            builder.set介護認定審査会割当年月日(new FlexibleDate(RDate.getNowDate().toString()));
            builder.set介護認定審査会審査順(row.getNo().toInt());
            builder.set介護認定審査会審査順確定フラグ(row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定));
            builder.set審査会自動割付フラグ(IsShinsakaiJidoWaritsuke.手動.is審査会自動割付());
            johoManager.save介護認定審査会割当情報研修(builder.build().modifiedModel());
        }
    }

    private void 候補者一覧更新() {
        boolean isダミー = div.getChkKenshuMogi().getSelectedKeys().contains(研修模擬_KEY);
        for (dgWaritsukeKohoshaIchiran_Row row : div.getDgWaritsukeKohoshaIchiran().getDataSource()) {
            if (isダミー) {
                候補者一覧更新_研修(row);
            } else {
                候補者一覧更新_通常(row);
            }
        }
    }

    private void 候補者一覧更新_通常(dgWaritsukeKohoshaIchiran_Row row) {
        ShinsakaiWariateJohoManager johoManager = ShinsakaiWariateJohoManager.createInstance();
        if (row.getJotaiFlag().equals(new RString("1"))) {
            ShinsakaiWariateJohoMapperParameter parameter
                    = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(
                            div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            ShinsakaiWariateJoho2 shinsakaiWariateJoho = johoManager.get介護認定審査会割当情報(parameter);
            if (shinsakaiWariateJoho != null) {
                johoManager.saveOrDeletePhysicalBy介護認定審査会割当情報(shinsakaiWariateJoho.deleted());
            }
            NinteiKanryoJohoManager manager = new NinteiKanryoJohoManager();
            NinteiKanryoJoho ninteiKanryoJoho = manager.get要介護認定完了情報(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (ninteiKanryoJoho != null) {
                ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit()
                        .set認定審査会割当完了年月日(null)
                        .build();
                manager.save要介護認定完了情報(ninteiKanryoJoho);
            }
        }
    }

    private void 候補者一覧更新_研修(dgWaritsukeKohoshaIchiran_Row row) {
        ShinsakaiWariateJohoKenshuManager shinsakaiWariateJohoKenshuManager = ShinsakaiWariateJohoKenshuManager.createInstance();
        if (row.getJotaiFlag().equals(new RString("1"))) {
            RString shinsakaiKaisaiNo = div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo();
            ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo(row.getShinseishoKanriNo());
            ShinsakaiWariateJohoKenshu shinsakaiWariateJohoKenshu = shinsakaiWariateJohoKenshuManager.get審査会割当情報研修(shinsakaiKaisaiNo, shinseishoKanriNo);
            if (shinsakaiWariateJohoKenshu != null) {
                shinsakaiWariateJohoKenshuManager.saveOrDeletePhysicalBy介護認定審査会割当情報研修(shinsakaiWariateJohoKenshu.deleted());
            }
            NinteiKanryoJohoManager manager = new NinteiKanryoJohoManager();
            NinteiKanryoJoho ninteiKanryoJoho = manager.get要介護認定完了情報(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
            if (ninteiKanryoJoho != null) {
                ninteiKanryoJoho = ninteiKanryoJoho.createBuilderForEdit()
                        .set認定審査会割当完了年月日(null)
                        .build();
                manager.save要介護認定完了情報(ninteiKanryoJoho);
            }
        }
    }

    private void 候補者一覧GridNo再割振(dgWaritsukeKohoshaIchiran_Row 割付対象候補者一覧GridData) {
        int 割付対象GridNo = 割付対象候補者一覧GridData.getNo().toInt();
        for (dgWaritsukeKohoshaIchiran_Row currentRow : div.getDgWaritsukeKohoshaIchiran().getDataSource()) {
            if (currentRow.getNo().toInt() > 割付対象GridNo) {
                currentRow.setNo(new RString(currentRow.getNo().toInt() - 1));
            }
        }

    }

    private void 対象者一覧No振り直し() {
        int 対象者割当No = 1;
        for (dgTaishoshaIchiran_Row currentRow : div.getDgTaishoshaIchiran().getDataSource()) {
            currentRow.setNo(new RString(対象者割当No));
            対象者割当No += 1;
        }
    }

    private boolean is対象者Gridに存在する(Taishouichiran 検索該当者) {
        for (dgTaishoshaIchiran_Row currentRow : div.getDgTaishoshaIchiran().getDataSource()) {
            if (currentRow.getHihokenshaNumber().equals(検索該当者.get被保険者番号())) {
                return true;
            }
        }
        return false;
    }

    private void 対象者一覧GridNo再割振() {
        boolean has確定フラグ = false;
        int max確定No = 0;
        for (dgTaishoshaIchiran_Row currentRow : div.getDgTaishoshaIchiran().getDataSource()) {
            if (currentRow.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定)) {
                has確定フラグ = true;
                max確定No = currentRow.getNo().toInt() > max確定No ? currentRow.getNo().toInt() : max確定No;
            }
        }

        boolean フラグ = true;
        int 未登録MaxNo = 0;
        for (dgTaishoshaIchiran_Row currentRow : div.getDgTaishoshaIchiran().getDataSource()) {
            if (has確定フラグ) {
                if (currentRow.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定しない)) {
                    if (!currentRow.getTorokuZumiFlag()) {
                        if (フラグ) {
                            RString no = new RString(max確定No + 1);
                            currentRow.setNo(no);
                            フラグ = false;
                            未登録MaxNo = no.toInt();
                        } else {
                            currentRow.setNo(new RString(未登録MaxNo + 1));
                        }
                    }
                }
            } else {
                if (currentRow.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定しない)) {
                    if (!currentRow.getTorokuZumiFlag()) {
                        if (フラグ) {
                            RString no = new RString(ViewStateHolder.get(ViewStateKeys.番号, RString.class).toInt() + 1);
                            currentRow.setNo(no);
                            フラグ = false;
                            未登録MaxNo = no.toInt();
                        } else {
                            currentRow.setNo(new RString(未登録MaxNo + 1));
                        }
                    }
                }
            }
        }
    }
}
