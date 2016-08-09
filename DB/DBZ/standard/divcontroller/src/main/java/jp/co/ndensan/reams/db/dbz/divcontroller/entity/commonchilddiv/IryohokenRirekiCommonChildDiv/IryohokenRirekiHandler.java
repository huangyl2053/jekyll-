/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the
 * template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.service.core.iryohokenkanyujokyo.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 医療保険履歴のHandlerクラスです。
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class IryohokenRirekiHandler {

    private final IryohokenRirekiCommonChildDivDiv div;
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 状態_登録 = new RString("登録");
    private static final RString 状態_追加 = new RString("追加");
    private static final RString コロン = new RString(":");
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
        List<UzT0007CodeEntity> entityList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.医療保険種類.getCodeShubetsu(), FlexibleDate.getNowDate());
        List<KeyValueDataSource> keyvalueList = new ArrayList<>();
        for (UzT0007CodeEntity codeEntity : entityList) {
            keyvalueList.add(new KeyValueDataSource(codeEntity.getコード().getKey(), codeEntity.getコード名称()));
        }
        div.getPnlIryohokenJoho().getDdlSyubetsu().setDataSource(keyvalueList);

        SearchResult<IryohokenKanyuJokyo> iryohokenkanyuList = IryohokenKanyuJokyoManager.createInstance().
                getIryoHokenJohoList(new ShikibetsuCode(識別コード));
        Models<IryohokenKanyuJokyoIdentifier, IryohokenKanyuJokyo> 医療保険情報 = Models.create(iryohokenkanyuList.records());
        ViewStateHolder.put(ViewStateKeys.医療保険情報, 医療保険情報);

        List<dgIryohokenIchiran_Row> dgiryohokenichiranList = new ArrayList<>();

        if (!iryohokenkanyuList.records().isEmpty()) {
            for (IryohokenKanyuJokyo jigyoshaInput : iryohokenkanyuList.records()) {
                dgIryohokenIchiran_Row Ichiran_Row = new dgIryohokenIchiran_Row();
                Ichiran_Row.setShikibetsuCode(jigyoshaInput.get識別コード().value());
                Ichiran_Row.setShichosonCode(jigyoshaInput.get市町村コード().value());
                Ichiran_Row.getKanyuDate().setValue(jigyoshaInput.get医療保険加入年月日());
                Ichiran_Row.getDattaiDate().setValue(jigyoshaInput.get医療保険脱退年月日());
                Ichiran_Row.setShubetsu(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.医療保険種類.getCodeShubetsu(),
                        new Code(jigyoshaInput.get医療保険種別コード()), FlexibleDate.getNowDate()));
                Ichiran_Row.setHokenshaCode(jigyoshaInput.get医療保険者番号());
                Ichiran_Row.setHokenshaName(jigyoshaInput.get医療保険者名称());
                Ichiran_Row.setKigoNo(jigyoshaInput.get医療保険記号番号());
                Ichiran_Row.getRirekiNo().setValue(new Decimal(jigyoshaInput.get履歴番号()));
                RStringBuilder 保険者名 = new RStringBuilder();
                保険者名.append(jigyoshaInput.get医療保険者番号());
                保険者名.append(コロン);
                保険者名.append(jigyoshaInput.get医療保険者名称());
                Ichiran_Row.setHokensha(保険者名.toRString());
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
            div.getDgIryohokenIchiran().getGridSetting().getColumn(new RString("defaultDataName2")).setVisible(false);
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

        div.set識別コード(識別コード);
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
                        ViewStateKeys.医療保険情報, Models.class);
        List<IryohokenKanyuJokyo> 医療保険情報更新List = new ArrayList<>();
        for (dgIryohokenIchiran_Row row : 医療保険情報List) {

            if (状態_追加.equals(row.getState())) {
                IryohokenKanyuJokyo kanyuJokyo = new IryohokenKanyuJokyo(new ShikibetsuCode(row.getShikibetsuCode()),
                        row.getRirekiNo().getValue().intValue());
                IryohokenKanyuJokyoBuilder builder = kanyuJokyo.createBuilderForEdit();
                builder.set医療保険加入年月日(row.getKanyuDate().getValue());
                builder.set医療保険脱退年月日(row.getDattaiDate().getValue());
                builder.set医療保険種別コード(row.getShubetsuCode());
                builder.set医療保険者番号(row.getHokenshaCode());
                builder.set医療保険者名称(row.getHokenshaName());
                builder.set医療保険記号番号(row.getKigoNo());
                builder.set市町村コード(new LasdecCode(div.get市町村コード()));
                builder.set被保険者番号(new HihokenshaNo(div.get被保険者番号()));
                kanyuJokyo.toEntity().setState(EntityDataState.Added);
                医療保険情報更新List.add(builder.build());
            } else if (状態_修正.equals(row.getState())) {
                IryohokenKanyuJokyo kanyuJokyo = 医療保険情報
                        .get(new IryohokenKanyuJokyoIdentifier(new ShikibetsuCode(row.getShikibetsuCode()),
                                        row.getRirekiNo().getValue().intValue()));
                IryohokenKanyuJokyoBuilder builder = kanyuJokyo.createBuilderForEdit();
                builder.set医療保険加入年月日(new FlexibleDate(new RDate(row.getKanyuDate().toString()).toDateString()));
                builder.set医療保険脱退年月日(new FlexibleDate(new RDate(row.getDattaiDate().toString()).toDateString()));
                builder.set医療保険種別コード(row.getShubetsuCode());
                builder.set医療保険者番号(row.getHokenshaCode());
                builder.set医療保険者名称(row.getShikibetsuCode());
                builder.set医療保険記号番号(row.getKigoNo());
                builder.set市町村コード(new LasdecCode(div.get市町村コード()));
                builder.set被保険者番号(new HihokenshaNo(div.get被保険者番号()));
                kanyuJokyo.toEntity().setState(EntityDataState.Modified);
                医療保険情報更新List.add(builder.build());
            } else if (状態_削除.equals(row.getState())) {
                IryohokenKanyuJokyo kanyuJokyo = 医療保険情報
                        .get(new IryohokenKanyuJokyoIdentifier(new ShikibetsuCode(row.getShikibetsuCode()),
                                        row.getRirekiNo().getValue().intValue()));
                医療保険情報更新List.add(kanyuJokyo.deleted());
            }
        }
        return IryohokenKanyuJokyoManager.createInstance().saveAllIryoHokenJoho(医療保険情報更新List);
    }

    public boolean isSavable(IryohokenRirekiCommonChildDivDiv requestDiv) {
        List<dgIryohokenIchiran_Row> 医療保険情報List = requestDiv.getDgIryohokenIchiran().getDataSource();
        for (dgIryohokenIchiran_Row row : 医療保険情報List) {

            if (状態_追加.equals(row.getState())
                    || 状態_修正.equals(row.getState())
                    || 状態_削除.equals(row.getState())) {
                return true;
            }
        }
        return false;
    }
}
