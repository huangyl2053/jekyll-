/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.HenkoJiyu;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki.ShikakuhenkorirekiManage;
import jp.co.ndensan.reams.db.dbz.service.sikakukanrenidoa.SikakuKanrenIdoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ShikakuHenkoRireki のクラスファイル
 *
 */
public class ShikakuHenkoRirekiHandler {

    private static final Code 広域 = new Code("111");
    private static final RString 合併有り = new RString("1");
    private static final RString EMPTY_KEY = new RString("EMPTY");
    private static final RString 半角コロン = new RString(":");
    private static final RString 追加状態 = new RString("追加");
    private static final RString 修正状態 = new RString("修正");
    private static final RString 削除状態 = new RString("削除");

    private final ShikakuHenkoRirekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuHenkoRirekiDiv
     */
    public ShikakuHenkoRirekiHandler(ShikakuHenkoRirekiDiv div) {
        this.div = div;
    }

    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、その結果をグリッドに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     */
    public void load(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        Boolean is単一 = !ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().equals(広域);
        Boolean is合併有り = BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告).equals(合併有り);
        if (is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiNashi);
        } else if (is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.TanitsuGappeiAri);
        } else if (!is単一 && !is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiNashi);
        } else if (!is単一 && is合併有り) {
            div.setMode_HokenshaJohoDisplayMode(ShikakuHenkoRirekiDiv.HokenshaJohoDisplayMode.KoikiGappeiAri);
        }
        div.getDgHenko().setDataSource(get資格変更履歴(被保険者番号, 識別コード, 取得日));
        div.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha().setDataSource(get措置元保険者DDL());
        div.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha().setDataSource(get旧保険者リスト情報());
        div.getHenkoInput().getDdlHenkoJiyu().setDataSource(get変更事由リスト情報());
        div.getHenkoInput().getHenkoHokenshaJoho().getDdlJuminJoho().setDataSource(get住民情報DDL(識別コード));
        if (ShikakuHenkoRirekiDiv.DisplayType.shokai.equals(div.getMode_DisplayType())) {
            div.setMode_BtnDisplayMode(ShikakuHenkoRirekiDiv.BtnDisplayMode.SetDisplayNone);
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleTrue);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
        } else if (ShikakuHenkoRirekiDiv.DisplayType.toroku.equals(div.getMode_DisplayType())) {
            div.getBtnAdd().setDisabled(true);
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleFalse);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.toroku);
            div.setInputMode(ViewExecutionStatus.Add.getValue());
        } else if (ShikakuHenkoRirekiDiv.DisplayType.teiseitoroku.equals(div.getMode_DisplayType())) {
            div.setMode_ShoriNichijiDisplayMode(ShikakuHenkoRirekiDiv.ShoriNichijiDisplayMode.VisibleFalse);
            div.setMode_MeisaiMode(ShikakuHenkoRirekiDiv.MeisaiMode.shokai);
        }
    }

    public void set資格変更入力Panel() {
        dgHenko_Row row = div.getDgHenko().getClickedItem();
        div.getHenkoInput().getTxtHenkoDate().setValue(row.getHenkoDate().getValue());
        div.getHenkoInput().getTxtHenkoTodokedeDate().setValue(row.getHenkoTodokedeDate().getValue());
        if (isValueContains(div.getHenkoInput().getDdlHenkoJiyu().getDataSource(), row.getHenkoJiyu())) {
            div.getHenkoInput().getDdlHenkoJiyu().setSelectedValue(row.getHenkoJiyu());
        } else {
            div.getHenkoInput().getDdlHenkoJiyu().setSelectedIndex(0);
        }
        if (isValueContains(div.getHenkoInput().getDdlHenkoSochimotoHokensha().getDataSource(), row.getSochimotoHokensha())) {
            div.getHenkoInput().getDdlHenkoSochimotoHokensha().setSelectedValue(row.getSochimotoHokensha());
        } else {
            div.getHenkoInput().getDdlHenkoSochimotoHokensha().setSelectedIndex(0);
        }
        if (isValueContains(div.getHenkoInput().getDdlHenkoKyuHokensha().getDataSource(), row.getKyuHokensha())) {
            div.getHenkoInput().getDdlHenkoKyuHokensha().setSelectedValue(row.getKyuHokensha());
        } else {
            div.getHenkoInput().getDdlHenkoKyuHokensha().setSelectedIndex(0);
        }
        //TODO 住民情報DDL選択方法
        //div.getHenkoInput().getDdlJuminJoho().setSelectedValue();
    }

    public void clear資格変更入力Panel() {
        div.getHenkoInput().getTxtHenkoDate().clearValue();
        div.getHenkoInput().getTxtHenkoTodokedeDate().clearValue();
        div.getHenkoInput().getDdlHenkoJiyu().setSelectedIndex(0);
        div.getHenkoInput().getDdlHenkoSochimotoHokensha().setSelectedIndex(0);
        div.getHenkoInput().getDdlHenkoKyuHokensha().setSelectedIndex(0);
        div.getHenkoInput().getDdlJuminJoho().setSelectedIndex(0);
    }

    public void updateEntryData() {
        if (div.getInputMode().equals(ViewExecutionStatus.Add.getValue())) {
            TextBoxFlexibleDate 変更日 = new TextBoxFlexibleDate();
            変更日.setValue(div.getHenkoInput().getTxtHenkoDate().getValue());
            TextBoxFlexibleDate 変更届出日 = new TextBoxFlexibleDate();
            変更届出日.setValue(div.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
            dgHenko_Row row = new dgHenko_Row(
                    追加状態,
                    変更日,
                    変更届出日,
                    div.getHenkoInput().getDdlHenkoJiyu().getSelectedValue(),
                    div.getHenkoInput().getDdlHenkoJiyu().getSelectedKey(),
                    null,//TODO 所在保険者？
                    div.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedValue(),
                    div.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedValue(),
                    null);//TODO 処理日時？
            div.getDgHenko().getDataSource().add(row);
        } else if (div.getInputMode().equals(ViewExecutionStatus.Modify.getValue())) {
            RString 状態 = 修正状態;
            if (div.getDgHenko().getClickedItem().getState().equals(追加状態)) {
                状態 = 追加状態;
            }
            TextBoxFlexibleDate 変更日 = new TextBoxFlexibleDate();
            変更日.setValue(div.getHenkoInput().getTxtHenkoDate().getValue());
            TextBoxFlexibleDate 変更届出日 = new TextBoxFlexibleDate();
            変更届出日.setValue(div.getHenkoInput().getTxtHenkoTodokedeDate().getValue());
            dgHenko_Row row = new dgHenko_Row(
                    状態,
                    変更日,
                    変更届出日,
                    div.getHenkoInput().getDdlHenkoJiyu().getSelectedValue(),
                    div.getHenkoInput().getDdlHenkoJiyu().getSelectedKey(),
                    null,//TODO 所在保険者？
                    div.getHenkoInput().getDdlHenkoSochimotoHokensha().getSelectedValue(),
                    div.getHenkoInput().getDdlHenkoKyuHokensha().getSelectedValue(),
                    null);//TODO 処理日時？
            div.getDgHenko().getDataSource().set(div.getDgHenko().getClickedRowId(), row);
        } else if (div.getInputMode().equals(ViewExecutionStatus.Delete.getValue())) {
            div.getDgHenko().getClickedItem().setState(new RString("削除"));
        }
    }

    private boolean isValueContains(List<KeyValueDataSource> list, RString value) {
        for (KeyValueDataSource item : list) {
            if (value.equals(item.getValue())) {
                return true;
            }
        }
        return false;
    }

    private dgHenko_Row getDgHenko_RowFromSikakuKanrenIdo(SikakuKanrenIdo sikakuKanrenIdo) {
        TextBoxFlexibleDate 変更日 = new TextBoxFlexibleDate();
        変更日.setValue(sikakuKanrenIdo.get資格変更年月日());
        TextBoxFlexibleDate 届出日 = new TextBoxFlexibleDate();
        届出日.setValue(sikakuKanrenIdo.get資格変更届出年月日());
        RString 変更事由;
        try {
            変更事由 = ShikakuHenkoJiyu.valueOf(sikakuKanrenIdo.get住所地特例適用事由コード().toString()).getName();
        } catch (IllegalArgumentException e) {
            変更事由 = RString.EMPTY;
        }
        TextBoxFlexibleDate 処理日時 = new TextBoxFlexibleDate();
        処理日時.setValue(new FlexibleDate(sikakuKanrenIdo.get処理日時().toString()));
        dgHenko_Row row = new dgHenko_Row(
                RString.EMPTY, 変更日, 届出日, 変更事由, sikakuKanrenIdo.get住所地特例適用事由コード(), sikakuKanrenIdo.get市町村名称(),
                sikakuKanrenIdo.get広住特措置元市町村コード().getColumnValue(), sikakuKanrenIdo.get旧市町村名称(), 処理日時);
        return row;
    }

    private List<dgHenko_Row> get資格変更履歴(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        SikakuKanrenIdoFinder finder = new SikakuKanrenIdoFinder();
        List<SikakuKanrenIdo> kanrenIdos = finder.getSikakuKanrenIdo(SikakuKanrenIdoParameter.createParam(被保険者番号, 識別コード, 取得日)).records();
        List<dgHenko_Row> rows = new ArrayList<>();
        for (SikakuKanrenIdo sikakuKanrenIdo : kanrenIdos) {
            rows.add(getDgHenko_RowFromSikakuKanrenIdo(sikakuKanrenIdo));
        }
        return rows;
    }

    private List<KeyValueDataSource> get措置元保険者DDL() {
        SikakuKanrenIdoFinder finder = new SikakuKanrenIdoFinder();
        List<KoseiShichosonMaster> shichosonMasters = finder.selectByKoseiShichosonMasterList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (KoseiShichosonMaster koseiShichosonMaster : shichosonMasters) {
            if (!RString.isNullOrEmpty(koseiShichosonMaster.getShoKisaiHokenshaNo().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(
                        new RString(String.valueOf(count)), koseiShichosonMaster.getShoKisaiHokenshaNo().getColumnValue()));
                count++;
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get旧保険者リスト情報() {
        SikakuKanrenIdoFinder finder = new SikakuKanrenIdoFinder();
        List<GappeiShichoson> gappeiShichosons = finder.getGappeiShichosonList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (GappeiShichoson gappeiShichoson : gappeiShichosons) {
            if (!RString.isNullOrEmpty(gappeiShichoson.get旧保険者番号().getColumnValue())) {
                dataSource.add(new KeyValueDataSource(new RString(String.valueOf(count)), gappeiShichoson.get旧保険者番号().getColumnValue()));
                count++;
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get変更事由リスト情報() {
        SikakuKanrenIdoFinder finder = new SikakuKanrenIdoFinder();
        List<HenkoJiyu> gappeiShichosons = finder.getHenkoJiyuList().records();
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (HenkoJiyu henkoJiyu : gappeiShichosons) {
            if (!RString.isNullOrEmpty(henkoJiyu.getCodeRyakusho())) {
                dataSource.add(new KeyValueDataSource(
                        henkoJiyu.getCode() == null ? new RString(String.valueOf(count)) : henkoJiyu.getCode().getColumnValue(),
                        henkoJiyu.getCodeRyakusho()));
                count++;
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get住民情報DDL(ShikibetsuCode 識別コード) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        ShikakuhenkorirekiManage shikakuhenkorirekiManage = ShikakuhenkorirekiManage.createInstance();
        List<IKojin> kojins = shikakuhenkorirekiManage.getKojinInfoByShikibetuCd(識別コード);
        dataSource.add(new KeyValueDataSource(EMPTY_KEY, RString.EMPTY));
        int count = 1;
        for (IKojin iKojin : kojins) {
            dataSource.add(new KeyValueDataSource(new RString(String.valueOf(count)), get住民情報(iKojin)));
            count++;
        }
        return dataSource;
    }

    private RString get住民情報(IKojin kojin) {
        ShikibetsuCode 識別コード = kojin.get識別コード();
        LasdecCode 市町村コード = kojin.get現全国地方公共団体コード();
        JuminJotai 住民状態 = kojin.get住民状態();
        RString 生年月日;
        AtenaKanaMeisho カナ氏名;
        if (kojin.is日本人()) {
            生年月日 = kojin.get生年月日().toFlexibleDate().wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
            カナ氏名 = kojin.get日本人氏名().getKana();
        } else {
            生年月日 = kojin.get生年月日().toFlexibleDate().seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            カナ氏名 = kojin.get外国人氏名().get外国人氏名カナ();
        }
        return get住民情報Format(識別コード.getColumnValue(), 市町村コード.getColumnValue(), 住民状態.住民状態略称(), 生年月日, カナ氏名.getColumnValue());
    }

    private RString get住民情報Format(RString 識別コード, RString 市町村コード, RString 住民状態略称, RString 生年月日, RString カナ氏名) {
        return 識別コード.concat(半角コロン).concat(市町村コード).concat(半角コロン).concat(住民状態略称).concat(半角コロン).concat(生年月日)
                .concat(半角コロン).concat(カナ氏名);
    }
}
