/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe5160001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.KohoshaIchiran;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.TaishouWaritsukeHead;
import jp.co.ndensan.reams.db.dbe.business.core.taishouwaritsuke.Taishouichiran;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.taishouwaritsuke.TaishouWaritsukeViewStateKey;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsakai.IsShinsakaiJidoWaritsuke;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariatejoho.ShinsakaiWariateJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiIinJogaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.KohoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.TaishouIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.TaishouWaritsukeDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5160001.dgWaritsukeKohoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.konicho.taishouwaritsuke.TaishouWaritsukeFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DbeConfigKey;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護認定審査会対象者割付クラスです。
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
     */
    public void initializtion() {
        RString 介護認定審査会番号 = ViewStateHolder.get(TaishouWaritsukeViewStateKey.介護認定審査会番号, RString.class);
        div.getShinsakaiTaishoshaWaritsuke().setKaigoNinteiShinsakaiKaisaiNo(介護認定審査会番号);
        ヘッドエリア検索();
        対象者一覧検索();
        候補者一覧検索();
    }

    /**
     * フッターエリアを設定。
     */
    public void setCommonButtonDisabled() {
        RString 進捗状況 = div.getTxtStatus().getValue();
        if (ShinsakaiShinchokuJokyo.中止.get名称().equals(進捗状況) || ShinsakaiShinchokuJokyo.完了.get名称().equals(進捗状況) || 進捗状況.isEmpty()) {
            div.getBtnJidoWaritsuke().setDisabled(true);
            div.getBtnWaritsuke().setDisabled(true);
            div.getBtnWaritsukeKaijo().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を確定する, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(登録する, true);
        }
        if (!ShinsakaiShinchokuJokyo.未開催.get名称().equals(進捗状況)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会割付を完了する, true);
        }
    }

    /**
     * 対象者一覧を検索する。
     */
    public void 対象者一覧検索() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        TaishouIchiranMapperParameter parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        List<Taishouichiran> ichiranList = finder.get対象者一覧(parameter);
        set対象者一覧(ichiranList);
    }

    /**
     * 候補者一覧を検索する。
     */
    public void 候補者一覧検索() {
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        boolean is一次判定後 = 一次判定後.equals(BusinessConfig.get(DbeConfigKey.マスキングチェックタイミング, SubGyomuCode.DBE認定支援));
        KohoshaIchiranMapperParameter parameter = KohoshaIchiranMapperParameter.createKohoshaIchiranMapperParameter(
                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), is一次判定後);
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
    }

    /**
     * 割付処理。
     */
    public void 割付処理() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(審査会順番を振りなおす, true);
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
        div.getTxtWaritsukeNinzu().setValue(new Decimal(div.getDgTaishoshaIchiran().getDataSource().size()));
    }

    /**
     * 審査会順序を振りなおす。
     */
    public void 審査会順序を振りなおす() {
        div.getDgTaishoshaIchiran().init();
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        RString カスタムコンフィグの審査会順序 = BusinessConfig.get(DbeConfigKey.審査会順序, SubGyomuCode.DBE認定支援);
        TaishouIchiranMapperParameter parameter;
        if (RString.isNullOrEmpty(カスタムコンフィグの審査会順序)) {
            parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        } else {
            parameter = TaishouIchiranMapperParameter.createTaishouIchiranMapperParameter(
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(), カスタムコンフィグの審査会順序);
        }
        List<Taishouichiran> ichiranList = finder.get対象者一覧(parameter);
        set対象者一覧(ichiranList);
    }

    /**
     * 審査会順序確定。
     */
    public void 審査会順序確定() {
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            row.setShinsajunKakuteiFlag(審査順確定フラグ_確定);
        }
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
        ShinsakaiKaisaiYoteiJoho joho = johoManager.get介護認定審査会開催予定情報(mapperParameter);
        if (joho != null) {
            ShinsakaiKaisaiYoteiJohoBuilder builder = joho.createBuilderForEdit();
            if (is登録ボタン押下) {
                builder.set介護認定審査会割当済み人数(div.getTxtWaritsukeNinzu().getValue().intValue());
            } else {
                builder.set介護認定審査会進捗状況(new Code(ShinsakaiShinchokuJokyo.未開催_割付完了.getコード()));
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
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        NinteiShinseiJoho shinseiJoho = finder.get申請書情報by申請書管理番号(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        boolean is機関まで = BusinessConfig.get(DbeConfigKey.オブザーバーチェック, SubGyomuCode.DBE認定支援).equals(機関まで);
        if (shinseiJoho != null) {
            CountShinsakaiWariateIinJohoMapperParameter param = CountShinsakaiWariateIinJohoMapperParameter.createCountKohoshaIchiranMapperParameter(
                    is機関まで,
                    div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                    shinseiJoho.get主治医医療機関コード(),
                    shinseiJoho.get認定調査委託先コード() == null ? RString.EMPTY : shinseiJoho.get認定調査委託先コード().getColumnValue(),
                    shinseiJoho.get入所施設コード() == null ? RString.EMPTY : shinseiJoho.get入所施設コード().getColumnValue(),
                    shinseiJoho.get主治医コード(),
                    shinseiJoho.get認定調査員コード() == null ? RString.EMPTY : shinseiJoho.get認定調査員コード().getColumnValue());
            if (!finder.is申請者オブザーバーチェックOK(param)) {
                return false;
            }
        }
        CountShinsakaiIinJogaiJohoMapperParameter csijjmp
                = CountShinsakaiIinJogaiJohoMapperParameter.createCountShinsakaiIinJogaiJohoMapperParameter(
                        row.getShinseishoKanriNo(),
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo());
        return finder.is審査会委員除外存在チェックOK(csijjmp);
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
                進捗状況 = ShinsakaiShinchokuJokyo.toValue(waritsukeHead.get進捗状況().getColumnValue()).get名称();
            } catch (IllegalArgumentException e) {
                進捗状況 = RString.EMPTY;
            }
            div.getTxtStatus().setValue(進捗状況);
            div.getTxtShinsakaiKaijo().setValue(waritsukeHead.get介護認定審査会開催場所名称());
            div.getTxtShinsakaiChiku().setValue(waritsukeHead.get地区コード().getColumnValue());
            div.getTxtShinsakauChikuName().setValue(
                    CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, new CodeShubetsu("5001"), waritsukeHead.get地区コード()));
            div.getTxtKaisaiDate().setValue(waritsukeHead.get開催予定日());
            div.getTxtYoteiKaishiTime().setValue(new RTime(waritsukeHead.get予定開始時間()));
            div.getTxtYoteiShuryoTime().setValue(new RTime(waritsukeHead.get予定終了時間()));
            set審査会種類_精神科医所属(waritsukeHead.is合議体精神科医存在フラグ());
        }
    }

    private void set審査会種類_精神科医所属(boolean 合議体精神科医存在フラグ) {
        List<RString> list = new ArrayList<>();
        if (合議体精神科医存在フラグ) {
            list.add(new RString("key0"));
        }
        div.getChkNinchishoOnly().setSelectedItemsByKey(list);
    }

    private void set対象者一覧(List<Taishouichiran> ichiranList) {
        List<dgTaishoshaIchiran_Row> rows = new ArrayList<>();
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        RString 優先;
        RString 性別;
        RString 被保区分;
        RString 申請区分_申請時;
        TextBoxFlexibleDate 認定申請日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間開始日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間終了日 = new TextBoxFlexibleDate();
        RString 調査票_寝たきり度;
        RString 調査票_認知度;
        RString 意見書_寝たきり度;
        RString 意見書_認知度;
        RString 再調査;
        dgTaishoshaIchiran_Row row;
        for (Taishouichiran taishouichiran : ichiranList) {
            RString no = new RString(Integer.toString(taishouichiran.get介護認定審査会審査順()));
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
                    taishouichiran.get要介護認定一次判定年月日().wareki().toDateString(),
                    taishouichiran.getマスキング完了年月日().wareki().toDateString(),
                    taishouichiran.get証記載保険者番号().getColumnValue(),
                    taishouichiran.get市町村名称(),
                    taishouichiran.get要介護認定一次判定年月日().wareki().toDateString(),
                    finder.get二次判定年月日(taishouichiran.get申請書管理番号()).wareki().toDateString(),
                    調査票_寝たきり度,
                    調査票_認知度,
                    意見書_寝たきり度,
                    意見書_認知度,
                    taishouichiran.get入所施設(),
                    taishouichiran.get事業者名称(),
                    taishouichiran.get調査員氏名(),
                    再調査,
                    taishouichiran.get医療機関名称(),
                    taishouichiran.get主治医氏名().getColumnValue()
            );
            rows.add(row);
        }
        div.getDgTaishoshaIchiran().setDataSource(rows);
    }

    private void set候補者一覧(List<KohoshaIchiran> ichiranList) {
        int no = 1;
        List<dgWaritsukeKohoshaIchiran_Row> rows = new ArrayList<>();
        TaishouWaritsukeFinder finder = TaishouWaritsukeFinder.createInstance();
        RString 優先;
        RString 性別;
        RString 被保区分;
        RString 申請区分_申請時;
        TextBoxFlexibleDate 認定申請日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間開始日 = new TextBoxFlexibleDate();
        TextBoxFlexibleDate 前回有効期間終了日 = new TextBoxFlexibleDate();
        RString 調査票_寝たきり度;
        RString 調査票_認知度;
        RString 意見書_寝たきり度;
        RString 意見書_認知度;
        RString 再調査;
        dgWaritsukeKohoshaIchiran_Row row;
        for (KohoshaIchiran kohoshaIchiran : ichiranList) {
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
                    kohoshaIchiran.get要介護認定一次判定年月日().wareki().toDateString(),
                    kohoshaIchiran.getマスキング完了年月日().wareki().toDateString(),
                    kohoshaIchiran.get証記載保険者番号().getColumnValue(),
                    kohoshaIchiran.get市町村名称(),
                    kohoshaIchiran.get要介護認定一次判定年月日().wareki().toDateString(),
                    finder.get二次判定年月日(kohoshaIchiran.get申請書管理番号()).wareki().toDateString(),
                    調査票_寝たきり度,
                    調査票_認知度,
                    意見書_寝たきり度,
                    意見書_認知度,
                    kohoshaIchiran.get入所施設(),
                    kohoshaIchiran.get事業者名称(),
                    kohoshaIchiran.get調査員氏名(),
                    再調査,
                    kohoshaIchiran.get医療機関名称(),
                    kohoshaIchiran.get主治医氏名().getColumnValue());
            rows.add(row);
        }
        div.getDgWaritsukeKohoshaIchiran().setDataSource(rows);
    }

    private void 候補者移転処理(dgWaritsukeKohoshaIchiran_Row kohoshaIchiran_Row) {
        dgTaishoshaIchiran_Row taishoshaIchiran_Row = new dgTaishoshaIchiran_Row(
                kohoshaIchiran_Row.getJotaiFlag(),
                kohoshaIchiran_Row.getShinsajunKakuteiFlag(),
                kohoshaIchiran_Row.getShinseishoKanriNo(),
                kohoshaIchiran_Row.getNo(),
                kohoshaIchiran_Row.getPriority(),
                kohoshaIchiran_Row.getHihokenshaNumber(),
                kohoshaIchiran_Row.getShimei(),
                kohoshaIchiran_Row.getSeibetsu(),
                kohoshaIchiran_Row.getHihokenshaKubun(),
                kohoshaIchiran_Row.getSihinseiKubunShinseiji(),
                kohoshaIchiran_Row.getShinseiDay(),
                kohoshaIchiran_Row.getZenkaiYukoKikanKaishiDay(),
                kohoshaIchiran_Row.getZenkaiYukoKikanShuryoDay(),
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
                kohoshaIchiran_Row.getShujii()
        );
        div.getDgTaishoshaIchiran().getDataSource().add(taishoshaIchiran_Row);
        div.getDgWaritsukeKohoshaIchiran().getDataSource().remove(kohoshaIchiran_Row);
    }

    private void 対象者移転処理(dgTaishoshaIchiran_Row taishoshaIchiran_Row) {
        dgWaritsukeKohoshaIchiran_Row kohoshaIchiran_Row = new dgWaritsukeKohoshaIchiran_Row(
                taishoshaIchiran_Row.getJotaiFlag(),
                審査順確定フラグ_確定しない,
                taishoshaIchiran_Row.getShinseishoKanriNo(),
                taishoshaIchiran_Row.getNo(),
                taishoshaIchiran_Row.getPriority(),
                taishoshaIchiran_Row.getHihokenshaNumber(),
                taishoshaIchiran_Row.getShimei(),
                taishoshaIchiran_Row.getSeibetsu(),
                taishoshaIchiran_Row.getHihokenshaKubun(),
                taishoshaIchiran_Row.getSihinseiKubunShinseiji(),
                taishoshaIchiran_Row.getShinseiDay(),
                taishoshaIchiran_Row.getZenkaiYukoKikanKaishiDay(),
                taishoshaIchiran_Row.getZenkaiYukoKikanShuryoDay(),
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
                taishoshaIchiran_Row.getShujii());
        div.getDgTaishoshaIchiran().getDataSource().remove(taishoshaIchiran_Row);
        div.getDgWaritsukeKohoshaIchiran().getDataSource().add(kohoshaIchiran_Row);
    }

    private void 対象者一覧更新() {
        ShinsakaiWariateJohoManager johoManager = ShinsakaiWariateJohoManager.createInstance();
        int gridソート順 = 1;
        for (dgTaishoshaIchiran_Row row : div.getDgTaishoshaIchiran().getDataSource()) {
            if (row.getJotaiFlag().equals(new RString("1"))) {
                ShinsakaiWariateJohoMapperParameter mapperParameter
                        = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(
                                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                                new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                ShinsakaiWariateJoho shinsakaiWariateJoho = johoManager.get介護認定審査会割当情報(mapperParameter);
                if (!row.getNo().equals(new RString(String.valueOf(gridソート順))) || (shinsakaiWariateJoho != null
                        && row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定) != (shinsakaiWariateJoho.get介護認定審査会審査順確定フラグ()))) {
                    ShinsakaiWariateJohoBuilder johoBuilder = shinsakaiWariateJoho.createBuilderForEdit();
                    johoBuilder.set介護認定審査会審査順(gridソート順);
                    johoBuilder.set介護認定審査会審査順確定フラグ(shinsakaiWariateJoho.get介護認定審査会審査順確定フラグ());
                    johoManager.save介護認定審査会割当情報(johoBuilder.build().modifiedModel());
                }
            }
            if (row.getJotaiFlag().equals(new RString("2"))) {
                ShinsakaiWariateJoho shinsakaiWariateJoho = new ShinsakaiWariateJoho(
                        div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                        new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                ShinsakaiWariateJohoBuilder builder = shinsakaiWariateJoho.createBuilderForEdit();
                builder.set介護認定審査会開催年月日(div.getTxtKaisaiDate().getValue());
                builder.set介護認定審査会割当年月日(new FlexibleDate(RDate.getNowDate().toString()));
                builder.set介護認定審査会審査順(gridソート順);
                builder.set介護認定審査会審査順確定フラグ(row.getShinsajunKakuteiFlag().equals(審査順確定フラグ_確定));
                builder.set審査会自動割付フラグ(IsShinsakaiJidoWaritsuke.手動.getコード());
                johoManager.save介護認定審査会割当情報(builder.build().modifiedModel());
            }
            gridソート順++;
        }
    }

    private void 候補者一覧更新() {
        ShinsakaiWariateJohoManager johoManager = ShinsakaiWariateJohoManager.createInstance();
        for (dgWaritsukeKohoshaIchiran_Row row : div.getDgWaritsukeKohoshaIchiran().getDataSource()) {
            if (row.getJotaiFlag().equals(new RString("1"))) {
                ShinsakaiWariateJohoMapperParameter parameter
                        = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(
                                div.getShinsakaiTaishoshaWaritsuke().getKaigoNinteiShinsakaiKaisaiNo(),
                                new ShinseishoKanriNo(row.getShinseishoKanriNo()));
                ShinsakaiWariateJoho shinsakaiWariateJoho = johoManager.get介護認定審査会割当情報(parameter);
                if (shinsakaiWariateJoho != null) {
                    johoManager.saveOrDeletePhysicalBy介護認定審査会割当情報(shinsakaiWariateJoho.deleted());
                }
            }
        }
    }

}
