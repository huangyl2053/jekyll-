/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteiKanryoJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteichosaScheduleMybatisParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.MainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020003.dgResultList_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosaschedule.NinteichosaScheduleFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 認定調査スケジュール登録3のハンドラークラスです。
 */
public class MainPanelHandler {

    private final MainPanelDiv div;

    private static final RString 検索対象未定者 = new RString("1");
    private static final RString 検索対象申請者 = new RString("2");
    private static final RString 検索対象みなし2号 = new RString("3");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final RString 男 = new RString("1");
    private static final CodeShubetsu コード種別 = new CodeShubetsu("5002");

    /**
     * コンストラクタ。
     *
     * @param div MainPanelDiv
     */
    public MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     */
    public void initialize() {
        div.getDdlTaishoChiku().setDataSource(調査地区ドロップダウンリスト());
        div.getSearchConditionPanel().getDdlTaishoChiku()
                .setSelectedKey(ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, RString.class));
        div.getTxtMaxRow().setValue(new RString(BusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
        set保険者DDL();
    }

    /**
     * ボタン押下で検索条件入力項目をクリアする。
     */
    public void 検索条件クリア() {
        div.getSearchConditionPanel().getDdlTaishoChiku().setSelectedKey(RString.EMPTY);
        div.getSearchConditionPanel().getDdlHokensha().setSelectedKey(RString.EMPTY);
        div.getSearchConditionPanel().getTxtHihokenshaNo().clearValue();
        div.getSearchConditionPanel().getTxtShikibetsuCode().clearValue();
        div.getSearchConditionPanel().getTxtShimei().clearValue();
        div.getSearchConditionPanel().getTxtKanaShimei().clearValue();
        div.getSearchConditionPanel().getTxtBirthDay().clearValue();
        div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().clearValue();
        div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().clearValue();
        div.getSearchConditionPanel().getTxtMemo().clearValue();
        div.getSearchConditionPanel().getDdlNinteiChosaItakusaki().setSelectedKey(RString.EMPTY);
        div.getSearchConditionPanel().getDdlNinteiChosain().setSelectedKey(RString.EMPTY);
        div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().clearValue();
        div.getTxtNinteiChosaYMDTo().clearValue();
        div.getSearchConditionPanel().getTxtMaxRow().clearValue();
        div.getRadScheduleEdit().setSelectedIndex(0);
        div.getRadScheduleShokai().setSelectedIndex(0);
        div.getRadMiteishaKanri().setSelectedIndex(0);
    }

    /**
     * 画面の検索条件より、認定調査スケジュール情報を検索する。
     */
    public void 該当者一覧照会リスト() {
        INinteichosaScheduleMybatisParameter mybatisParameter = INinteichosaScheduleMybatisParameter.createParam(div.getRadScheduleShokai().getSelectedKey(),
                div.getRadScheduleShokai().getSelectedKey(),
                div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                div.getSearchConditionPanel().getTxtHihokenshaNo().getValue(),
                div.getSearchConditionPanel().getTxtShimei().getValue(),
                div.getSearchConditionPanel().getTxtKanaShimei().getValue(),
                new RString(div.getSearchConditionPanel().getTxtBirthDay().getValue().toString()),
                new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().toString()),
                div.getSearchConditionPanel().getTxtMemo().getValue(),
                new RString(div.getSearchConditionPanel().getDdlNinteiChosaItakusaki().getControlValue().toString()),
                new RString(div.getSearchConditionPanel().getDdlNinteiChosain().getControlValue().toString()),
                new RString(div.getSearchConditionPanel().getTxtNinteiChosaYMDFrom().getValue().toString()),
                new RString(div.getSearchConditionPanel().getTxtNinteiChosaYMDTo().getValue().toString()),
                div.getSearchConditionPanel().getTxtShikibetsuCode().getValue(),
                new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().toString()),
                new RString(div.getSearchConditionPanel().getDdlTaishoChiku().getControlValue().toString()),
                div.getSearchConditionPanel().getTxtMaxRow().getValue().isEmpty() ? new Decimal(-1)
                : new Decimal(div.getSearchConditionPanel().getTxtMaxRow().getValue().toString()));
        List<NinteichosaSchedulBusiness> 該当者一覧照会 = NinteichosaScheduleFinder.createInstance().getKojinJokyoShokai(mybatisParameter).records();
        List<dgResultList_Row> rowList = new ArrayList<>();
        for (NinteichosaSchedulBusiness entity : 該当者一覧照会) {
            dgResultList_Row row = new dgResultList_Row();
            row.setHihokenshaNo(entity.get被保険者番号());
            row.setName(entity.get被保険者氏名());
            TextBoxFlexibleDate 生年月日 = new TextBoxFlexibleDate();
            生年月日.setValue(new FlexibleDate(entity.get生年月日()));
            row.setBirthDay(生年月日);
            if ((男).equals(entity.get性別())) {
                row.setSeibetsu(性別_男);
            } else {
                row.setSeibetsu(性別_女);
            }
            row.setKanaName(entity.get被保険者氏名カナ());
            TextBoxFlexibleDate 認定申請年月日 = new TextBoxFlexibleDate();
            認定申請年月日.setValue(new FlexibleDate(entity.get認定申請年月日()));
            row.setNinteiShinseiYmd(認定申請年月日);
            TextBoxFlexibleDate 認定調査予定年月日 = new TextBoxFlexibleDate();
            認定調査予定年月日.setValue(new FlexibleDate(entity.get認定調査予定年月日()));
            row.setNinteiChosaYmd(認定調査予定年月日);
            row.setTaishoshaMemo(entity.get対象者メモ());
            row.setJokyo(entity.get予約状況());
            row.setHokensha(entity.get市町村名称());
            row.setShinseiKubun(entity.get認定申請区分());
            row.setShinseishoKanriNo(entity.get申請書管理番号());
            rowList.add(row);
        }
        div.getResultListPanel().getDgResultList().setDataSource(rowList);
    }

    /**
     * 画面の検索条件より、認定調査スケジュール情報を検索する。
     */
    public void 検索対象未定者リスト() {

        if (検索対象未定者.equals(div.getRadScheduleEdit().getSelectedKey())) {
            INinteiKanryoJohoMybatisParameter mybatisParameter = INinteiKanryoJohoMybatisParameter.createParam(div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtHihokenshaNo().getValue(),
                    div.getSearchConditionPanel().getTxtShikibetsuCode().getValue(),
                    div.getSearchConditionPanel().getTxtShimei().getValue(),
                    div.getSearchConditionPanel().getTxtKanaShimei().getValue(),
                    new RString(div.getSearchConditionPanel().getTxtBirthDay().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().toString()),
                    div.getSearchConditionPanel().getTxtMemo().getValue(),
                    div.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtMaxRow().getValue().isEmpty() ? new Decimal(-1)
                    : new Decimal(div.getSearchConditionPanel().getTxtMaxRow().getValue().toString()));
            List<NinteichosaSchedulBusiness> 未定者管理 = NinteichosaScheduleFinder.createInstance().get未定者管理(mybatisParameter).records();
            List<dgResultList_Row> rowList = new ArrayList<>();
            for (NinteichosaSchedulBusiness entity : 未定者管理) {
                dgResultList_Row row = new dgResultList_Row();
                row.setHihokenshaNo(entity.get被保険者番号());
                row.setName(entity.get被保険者氏名());
                TextBoxFlexibleDate 生年月日 = new TextBoxFlexibleDate();
                生年月日.setValue(new FlexibleDate(entity.get生年月日()));
                row.setBirthDay(生年月日);
                if ((男).equals(entity.get性別())) {
                    row.setSeibetsu(性別_男);
                } else {
                    row.setSeibetsu(性別_女);
                }
                row.setKanaName(entity.get被保険者氏名カナ());
                TextBoxFlexibleDate 認定申請年月日 = new TextBoxFlexibleDate();
                認定申請年月日.setValue(new FlexibleDate(entity.get認定申請年月日()));
                row.setNinteiShinseiYmd(認定申請年月日);
                TextBoxFlexibleDate 認定調査予定年月日 = new TextBoxFlexibleDate();
                認定調査予定年月日.setValue(new FlexibleDate(entity.get認定調査予定年月日()));
                row.setNinteiChosaYmd(認定調査予定年月日);
                row.setTaishoshaMemo(entity.get対象者メモ());
                row.setJokyo(entity.get予約状況());
                row.setHokensha(entity.get市町村名称());
                row.setShinseiKubun(entity.get認定申請区分());
                row.setShinseishoKanriNo(entity.get申請書管理番号());
                rowList.add(row);
            }
            div.getResultListPanel().getDgResultList().setDataSource(rowList);
        }
        if (検索対象申請者.equals(div.getSearchConditionPanel().getRadMiteishaKanri().getSelectedKey())) {
            INinteiKanryoJohoMybatisParameter mybatisParameter = INinteiKanryoJohoMybatisParameter.createParam(div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtHihokenshaNo().getValue(),
                    div.getSearchConditionPanel().getTxtShikibetsuCode().getValue(),
                    div.getSearchConditionPanel().getTxtShimei().getValue(),
                    div.getSearchConditionPanel().getTxtKanaShimei().getValue(),
                    new RString(div.getSearchConditionPanel().getTxtBirthDay().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().toString()),
                    div.getSearchConditionPanel().getTxtMemo().getValue(),
                    div.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtMaxRow().getValue().isEmpty() ? new Decimal(-1)
                    : new Decimal(div.getSearchConditionPanel().getTxtMaxRow().getValue().toString()));
            List<dgResultList_Row> rowList = new ArrayList<>();
            List<NinteichosaSchedulBusiness> 検索対象申請者list = NinteichosaScheduleFinder.createInstance().get検索対象申請者(mybatisParameter).records();
            for (NinteichosaSchedulBusiness entity : 検索対象申請者list) {
                dgResultList_Row row = new dgResultList_Row();
                row.setHihokenshaNo(entity.get被保険者番号());
                row.setName(entity.get被保険者氏名());
                TextBoxFlexibleDate 生年月日 = new TextBoxFlexibleDate();
                生年月日.setValue(new FlexibleDate(entity.get生年月日()));
                row.setBirthDay(生年月日);
                if ((男).equals(entity.get性別())) {
                    row.setSeibetsu(性別_男);
                } else {
                    row.setSeibetsu(性別_女);
                }
                row.setKanaName(entity.get被保険者氏名カナ());
                TextBoxFlexibleDate 認定申請年月日 = new TextBoxFlexibleDate();
                認定申請年月日.setValue(new FlexibleDate(entity.get認定申請年月日()));
                row.setNinteiShinseiYmd(認定申請年月日);
                TextBoxFlexibleDate 認定調査予定年月日 = new TextBoxFlexibleDate();
                認定調査予定年月日.setValue(new FlexibleDate(entity.get認定調査予定年月日()));
                row.setNinteiChosaYmd(認定調査予定年月日);
                row.setTaishoshaMemo(entity.get対象者メモ());
                row.setJokyo(entity.get予約状況());
                row.setHokensha(entity.get市町村名称());
                row.setShinseiKubun(entity.get認定申請区分());
                row.setShinseishoKanriNo(entity.get申請書管理番号());
                rowList.add(row);
            }
            div.getResultListPanel().getDgResultList().setDataSource(rowList);
        }
        if (検索対象みなし2号.equals(div.getSearchConditionPanel().getRadMiteishaKanri().getSelectedKey())) {
            INinteiKanryoJohoMybatisParameter mybatisParameter = INinteiKanryoJohoMybatisParameter.createParam(div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getDdlHokensha().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtHihokenshaNo().getValue(),
                    div.getSearchConditionPanel().getTxtShikibetsuCode().getValue(),
                    div.getSearchConditionPanel().getTxtShimei().getValue(),
                    div.getSearchConditionPanel().getTxtKanaShimei().getValue(),
                    new RString(div.getSearchConditionPanel().getTxtBirthDay().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDFrom().getValue().toString()),
                    new RString(div.getSearchConditionPanel().getTxtNinteiShinseiYMDTo().getValue().toString()),
                    div.getSearchConditionPanel().getTxtMemo().getValue(),
                    div.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                    div.getSearchConditionPanel().getTxtMaxRow().getValue().isEmpty() ? new Decimal(-1)
                    : new Decimal(div.getSearchConditionPanel().getTxtMaxRow().getValue().toString()));
            List<NinteichosaSchedulBusiness> 検索対象みなし2号lsit = NinteichosaScheduleFinder.createInstance()
                    .get検索対象みなし2号(mybatisParameter).records();
            List<dgResultList_Row> rowList = new ArrayList<>();
            for (NinteichosaSchedulBusiness entity : 検索対象みなし2号lsit) {
                dgResultList_Row row = new dgResultList_Row();
                row.setHihokenshaNo(entity.get被保険者番号());
                row.setHihokenshaNo(entity.get被保険者番号());
                row.setName(entity.get被保険者氏名());
                TextBoxFlexibleDate 生年月日 = new TextBoxFlexibleDate();
                生年月日.setValue(new FlexibleDate(entity.get生年月日()));
                row.setBirthDay(生年月日);
                if ((男).equals(entity.get性別())) {
                    row.setSeibetsu(性別_男);
                } else {
                    row.setSeibetsu(性別_女);
                }
                row.setKanaName(entity.get被保険者氏名カナ());
                TextBoxFlexibleDate 認定申請年月日 = new TextBoxFlexibleDate();
                認定申請年月日.setValue(new FlexibleDate(entity.get認定申請年月日()));
                row.setNinteiShinseiYmd(認定申請年月日);
                TextBoxFlexibleDate 認定調査予定年月日 = new TextBoxFlexibleDate();
                認定調査予定年月日.setValue(new FlexibleDate(entity.get認定調査予定年月日()));
                row.setNinteiChosaYmd(認定調査予定年月日);
                row.setTaishoshaMemo(entity.get対象者メモ());
                row.setJokyo(entity.get予約状況());
                row.setHokensha(entity.get市町村名称());
                row.setShinseiKubun(entity.get認定申請区分());
                row.setShinseishoKanriNo(entity.get申請書管理番号());
                rowList.add(row);
            }
            div.getResultListPanel().getDgResultList().setDataSource(rowList);
        }
    }

    /**
     * 保険者ドロップダウンリスト値取得を検索する。
     */
    public void set保険者DDL() {
        INinteiKanryoJohoMybatisParameter mybatisParameter = INinteiKanryoJohoMybatisParameter.createParam(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                div.getSearchConditionPanel().getDdlTaishoChiku().getSelectedKey(),
                Decimal.ZERO);
        List<NinteichosaSchedulBusiness> 保険者ドロップダウンリスト = NinteichosaScheduleFinder.createInstance()
                .get保険者ドロップダウン(mybatisParameter).records();
        List<KeyValueDataSource> dataList = new ArrayList<>();
        for (NinteichosaSchedulBusiness entitiy : 保険者ドロップダウンリスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(entitiy.get証記載保険者番号());
            dataSource.setValue(entitiy.get証記載保険者番号());
            dataList.add(dataSource);
        }
        div.getDdlHokensha().setDataSource(dataList);
    }

    private List<KeyValueDataSource> 調査地区ドロップダウンリスト() {

        List<KeyValueDataSource> dataSource = new ArrayList();
        List<UzT0007CodeEntity> 指定調査地区 = CodeMaster.getCode(SubGyomuCode.DBE認定支援, コード種別);

        for (UzT0007CodeEntity entity : 指定調査地区) {

            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(entity.getコード().value());
            keyValue.setValue(entity.getコード名称());

            dataSource.add(keyValue);
        }
        return dataSource;
    }
}
