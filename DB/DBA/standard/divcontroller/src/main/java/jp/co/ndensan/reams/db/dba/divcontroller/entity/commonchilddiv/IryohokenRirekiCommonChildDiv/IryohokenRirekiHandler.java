/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoBuilder;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoIdentifier;
import jp.co.ndensan.reams.db.dba.service.iryohokenkanyujokyo.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 医療保険履歴のHandlerクラスです。
 *
 */
public class IryohokenRirekiHandler {

    private final IryohokenRirekiCommonChildDivDiv div;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString コロン = new RString(":");
    private static final CodeShubetsu コード = new CodeShubetsu("0001");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");

    /**
     * コンストラクタです。
     *
     * @param div IryohokenRirekiCommonChildDivDiv
     */
    public IryohokenRirekiHandler(IryohokenRirekiCommonChildDivDiv div) {
        this.div = div;
    }

    /**
     *
     * 画面レイアウトモードの設定します。
     *
     * @param 状態 状態
     * @param 識別コード 識別コード
     */
    public void initialize(RString 状態, RString 識別コード) {
        SearchResult<IryohokenKanyuJokyo> iryohokenkanyuList = IryohokenKanyuJokyoManager.createInstance().getIryoHokenJohoList(new ShikibetsuCode(識別コード));
        Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> 医療保険情報 = Models.create(iryohokenkanyuList.records());
        ViewStateHolder.put(ViewStateKeys.医療保険情報, 医療保険情報);

        List<dgIryohokenIchiran_Row> dgiryohokenichiranList = new ArrayList<>();

        if (!iryohokenkanyuList.records().isEmpty()) {
            for (IryohokenKanyuJokyo jigyoshaInput : iryohokenkanyuList.records()) {
                dgIryohokenIchiran_Row Ichiran_Row = new dgIryohokenIchiran_Row();
                Ichiran_Row.setDefaultDataName0(jigyoshaInput.get識別コード().value());
                Ichiran_Row.setDefaultDataName1(jigyoshaInput.get市町村コード().value());
                Ichiran_Row.setDefaultDataName3(jigyoshaInput.get医療保険加入年月日().wareki().toDateString());
                Ichiran_Row.setDefaultDataName4(jigyoshaInput.get医療保険脱退年月日().wareki().toDateString());
                Ichiran_Row.setDefaultDataName5(CodeMaster.getCodeMeisho(コード, new Code(jigyoshaInput.get医療保険種別コード())));
                Ichiran_Row.setDefaultDataName8(jigyoshaInput.get医療保険者番号());
                Ichiran_Row.setDefaultDataName6(jigyoshaInput.get医療保険者名称());
                Ichiran_Row.setDefaultDataName7(jigyoshaInput.get医療保険記号番号());
                Ichiran_Row.getDefaultDataName9().setValue(Decimal.valueOf(jigyoshaInput.get履歴番号()));
                RStringBuilder 保険者名 = new RStringBuilder();
                保険者名.append(jigyoshaInput.get医療保険者番号());
                保険者名.append(コロン);
                保険者名.append(jigyoshaInput.get医療保険者名称());
                Ichiran_Row.setDefaultDataName10(保険者名.toRString());
                dgiryohokenichiranList.add(Ichiran_Row);
            }
            div.getDgIryohokenIchiran().setDataSource(dgiryohokenichiranList);
        }
        if (状態_照会.equals(状態)) {

            div.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(true);
            div.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(true);
            div.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(true);
            div.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(true);
            div.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(true);
            div.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(true);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowRowState(true);
            div.getPlIryohokenRireki().getBtnCancel().setVisible(false);
            div.getPlIryohokenRireki().getBtnIryohokenKakute().setVisible(false);
            div.getPlIryohokenRireki().getBtnIryohokenTsuika().setVisible(false);
        } else if (状態_登録.equals(状態)) {
            div.getPnlIryohokenJoho().getTbdKanyubi().setReadOnly(true);
            div.getPnlIryohokenJoho().getTbdDattabi().setReadOnly(true);
            div.getPnlIryohokenJoho().getDdlSyubetsu().setDisabled(true);
            div.getPnlIryohokenJoho().getTxtHokensyaKodo().setReadOnly(true);
            div.getPnlIryohokenJoho().getTxtHokensyaMeisho().setReadOnly(true);
            div.getPnlIryohokenJoho().getTxtKigoBango().setReadOnly(true);
            div.getPlIryohokenRireki().getBtnCancel().setVisible(true);
            div.getPlIryohokenRireki().getBtnIryohokenKakute().setVisible(true);
            div.getPlIryohokenRireki().getBtnCancel().setDisabled(true);
            div.getPlIryohokenRireki().getBtnIryohokenKakute().setDisabled(true);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowRowState(false);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowDeleteButtonColumn(true);
            div.getDgIryohokenIchiran().getGridSetting().setIsShowModifyButtonColumn(true);
            div.getPlIryohokenRireki().getBtnIryohokenTsuika().setVisible(true);

            div.getDgIryohokenIchiran().getGridSetting().setIsShowSelectButtonColumn(false);
        }
    }

    /**
     * 医療保険情報の保存処理を保存します。
     *
     * @param requestDiv IryohokenRirekiCommonChildDivDiv
     * @return 医療保険情報更新List
     */
    public int save(IryohokenRirekiCommonChildDivDiv requestDiv) {
        List<dgIryohokenIchiran_Row> 医療保険情報List = requestDiv.getDgIryohokenIchiran().getDataSource();
        Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> 医療保険情報
                = (Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo>) ViewStateHolder.get(
                        ViewStateKeys.介護認定審査会委員情報更新, Models.class);

        List<IryohokenKanyuJokyo> 医療保険情報更新List = new ArrayList<>();
        for (dgIryohokenIchiran_Row row : 医療保険情報List) {
            IryohokenKanyuJokyo kanyuJokyo = 医療保険情報.get(new IryohokenKanyuJokyoIdentifier(new ShikibetsuCode(row.getDefaultDataName1()), row.getDefaultDataName9().getValue().intValue()));
            IryohokenKanyuJokyoBuilder builder = kanyuJokyo.createBuilderForEdit();
            if (状態_追加.equals(row.getDefaultDataName2())) {
                builder.set医療保険加入年月日(new FlexibleDate(row.getDefaultDataName3()));
                builder.set医療保険種別コード(row.getDefaultDataName5());
                builder.set医療保険者名称(row.getDefaultDataName6());
                kanyuJokyo.toEntity().setState(EntityDataState.Added);
            } else if (状態_修正.equals(row.getDefaultDataName2())) {
                builder.set医療保険加入年月日(new FlexibleDate(row.getDefaultDataName3()));
                builder.set医療保険種別コード(row.getDefaultDataName5());
                builder.set医療保険者名称(row.getDefaultDataName6());
                kanyuJokyo.toEntity().setState(EntityDataState.Modified);
            } else if (状態_削除.equals(row.getDefaultDataName2())) {
                kanyuJokyo.toEntity().setState(EntityDataState.Deleted);
            }
            医療保険情報更新List.add(builder.build());
        }
        return IryohokenKanyuJokyoManager.createInstance().saveAllIryoHokenJoho(医療保険情報更新List);
    }
}
