/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5830001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.chiku.ChikuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 年齢階級別要介護度状況（統計表）画面のHandlerです。
 *
 * @reamsid_L DBD-1790-010 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoHandler {

    private final NenreiKaikyubetsuYokaigodoJokyoDiv div;
    private static final RString キー0 = new RString("key0");
    private static final RString キー1 = new RString("key1");
    private static final RString キー2 = new RString("key2");
    private static final RString キー3 = new RString("key3");
    private static final RString キー4 = new RString("key4");
    private static final RString キー5 = new RString("key5");

    /**
     * コンストラクタです。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     */
    public NenreiKaikyubetsuYokaigodoJokyoHandler(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void onLoad() {
        RDate システム日付 = RDate.getNowDate();
        div.getTxtKijyunD().setValue(システム日付);
        ddlChiku(true, false, false, false, false, true, true, true, true, true, true, true, true);
        div.getTxtKijyunYM().setDisabled(true);
        div.getDdlChiku().setDisabled(true);
        div.getCcdGyoseikuStart().setDisabled(true);
        div.getCcsGyoseikuEnd().setDisabled(true);
        div.getDdlShichoson().setDataSource(setDdlShichosonDataSource());
        div.getCcdGyoseikuStart().initialize();
        div.getCcsGyoseikuEnd().initialize();
    }

    /**
     * 基準日と基準年月ラジオを操作です。
     */
    public void onChange_rdoKijyun() {
        if (div.getRdoKijyun().getSelectedKey().equals(new RString("key0"))) {
            div.getTxtKijyunD().setDisabled(false);
            div.getTxtKijyunYM().setDisabled(true);
        } else {
            div.getTxtKijyunD().setDisabled(true);
            div.getTxtKijyunYM().setDisabled(false);
            RDate システム年月 = new RDate(RDate.getNowDate().wareki().firstYear(FirstYear.ICHI_NEN).getYearMonth().toString());
            div.getTxtKijyunYM().setValue(システム年月);
            div.getDdlChiku().setDisabled(false);
            div.getDdlChiku().setReadOnly(false);
        }
    }

    /**
     * 地区DDLを操作です。
     */
    public void onChange_ddlChiku() {
        div.getDdlChiku().setDisabled(false);
        div.getDdlChiku().setReadOnly(false);
        if (div.getDdlChiku().getSelectedKey().equals(キー0)) {
            div.getCcdGyoseikuStart().setDisabled(true);
            div.getCcsGyoseikuEnd().setDisabled(true);
            ddlChiku(true, false, false, false, false, true, true, true, true, true, true, true, true);
        } else if (div.getDdlChiku().getSelectedKey().equals(キー1)) {
            div.getCcdChoikiStart().setDisabled(false);
            div.getCcdChoikiEnd().setDisabled(false);
            ddlChiku(true, true, true, true, true, true, true, true, true, false, false, false, false);
        } else if (div.getDdlChiku().getSelectedKey().equals(キー2)) {
            div.getCcdGyoseikuStart().setDisabled(false);
            div.getCcsGyoseikuEnd().setDisabled(false);
            ddlChiku(true, false, false, false, false, true, true, true, true, true, true, true, true);
        } else if (div.getDdlChiku().getSelectedKey().equals(キー3)) {
            div.getCcdChiku2Start().setDisabled(false);
            div.getCcdChiku2End().setDisabled(false);
            ddlChiku(true, true, true, true, true, false, false, false, false, true, true, true, true);
        } else if (div.getDdlChiku().getSelectedKey().equals(キー4)) {
            ddlChiku(false, true, true, true, true, true, true, true, true, true, true, true, true);
        } else if (div.getDdlChiku().getSelectedKey().equals(キー5)) {
            ddlChiku(true, true, true, true, true, true, true, true, true, true, true, true, true);
        }
    }

    /**
     * バッチ用パラメータを作成します。
     *
     * @return NenreiKaikyubetsuYokaigodoJokyoParameter
     */
    public NenreiKaikyubetsuYokaigodoJokyoParameter getParameter() {
        NenreiKaikyubetsuYokaigodoJokyoParameter parameter = new NenreiKaikyubetsuYokaigodoJokyoParameter();
        if (div.getRdoKijyun().getSelectedKey().equals(キー0)) {
            parameter.set基準日(div.getTxtKijyunD().getValue());
        } else {
            parameter.set基準年月(div.getTxtKijyunYM().getValue());
        }
        for (ChikuKubun chikuKubun : ChikuKubun.values()) {
            if (div.getDdlChiku().getSelectedValue().equals(chikuKubun.get漢字名称())) {
                parameter.set地区区分(chikuKubun.get名称());
            }
        }
        set地区(parameter);

        return parameter;
    }

    private void set地区(NenreiKaikyubetsuYokaigodoJokyoParameter parameter) {
        if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.住所.get漢字名称())) {
            setパラメータ(parameter, new Code(div.getCcdChoikiStart().get町域コード().getColumnValue()),
                    new Code(div.getCcdChoikiEnd().get町域コード().getColumnValue()), RString.EMPTY, RString.EMPTY);
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.行政区.get漢字名称())) {
            setパラメータ(parameter, new Code(div.getCcdGyoseikuStart().get行政区コード().getColumnValue()),
                    new Code(div.getCcsGyoseikuEnd().get行政区コード().getColumnValue()), RString.EMPTY, RString.EMPTY);
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.組合.get漢字名称())) {
            setパラメータ(parameter, new Code(div.getCcdChiku2Start().get地区2コード().getColumnValue()),
                    new Code(div.getCcdChiku2End().get地区2コード().getColumnValue()), RString.EMPTY, RString.EMPTY);
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.旧市町村_個別.get漢字名称())) {
            setパラメータ(parameter, Code.EMPTY, Code.EMPTY, div.getDdlShichoson().getSelectedKey(),
                    div.getDdlShichoson().getSelectedValue());
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.旧市町村_全て.get漢字名称())) {
            setパラメータ(parameter, Code.EMPTY, Code.EMPTY, RString.EMPTY, new RString("全市町村"));
        } else {
            setパラメータ(parameter, Code.EMPTY, Code.EMPTY, RString.EMPTY, RString.EMPTY);
        }
    }

    private void setパラメータ(NenreiKaikyubetsuYokaigodoJokyoParameter parameter, Code 開始地区コード,
            Code 終了地区コード, RString 旧市町村コード, RString 旧市町村名称) {
        parameter.set開始地区コード(開始地区コード);
        parameter.set終了地区コード(終了地区コード);
        parameter.set旧市町村コード(旧市町村コード);
        parameter.set旧市町村名称(旧市町村名称);

    }

    private void ddlChiku(boolean isDdlShichoson, boolean isLblGyoseikuStart, boolean isCcdGyoseikuStart,
            boolean isLblGyoseikuEnd, boolean isCcsGyoseikuEnd, boolean isLblChiku2Start, boolean isCcdChiku2Start,
            boolean isLblChiku2End, boolean isCcdChiku2End, boolean isLblJyushoStart, boolean isCcdChoikiStart,
            boolean isLblJyushoEnd, boolean isCcdChoikiEnd) {
        div.getDdlShichoson().setDisplayNone(isDdlShichoson);
        div.getLblGyoseikuStart().setDisplayNone(isLblGyoseikuStart);
        div.getCcdGyoseikuStart().setDisplayNone(isCcdGyoseikuStart);
        div.getLblGyoseikuEnd().setDisplayNone(isLblGyoseikuEnd);
        div.getCcsGyoseikuEnd().setDisplayNone(isCcsGyoseikuEnd);
        div.getLblChiku2Start().setDisplayNone(isLblChiku2Start);
        div.getCcdChiku2Start().setDisplayNone(isCcdChiku2Start);
        div.getLblChiku2End().setDisplayNone(isLblChiku2End);
        div.getCcdChiku2End().setDisplayNone(isCcdChiku2End);
        div.getLblJyushoStart().setDisplayNone(isLblJyushoStart);
        div.getCcdChoikiStart().setDisplayNone(isCcdChoikiStart);
        div.getLblJyushoEnd().setDisplayNone(isLblJyushoEnd);
        div.getCcdChoikiEnd().setDisplayNone(isCcdChoikiEnd);

    }

    private List<KeyValueDataSource> setDdlShichosonDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RString ログインユーザID = ControlDataHolder.getUserId();
        List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(ログインユーザID);
        RString 市町村識別ID = authorityItemList.get(0).getItemId();
        if (!市町村識別ID.equals(new RString("00"))) {
            KoseiShichosonJoho 構成市町村情報 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            if (構成市町村情報 != null) {
                dataSourceList.add(new KeyValueDataSource(構成市町村情報.get市町村コード().value(),
                        setValue(構成市町村情報.get市町村コード().value(), 構成市町村情報.get市町村名称())));
            }
        } else if (市町村識別ID.equals(new RString("00"))) {
            List<KoikiZenShichosonJoho> 構成市町村 = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
            if (構成市町村 != null && !構成市町村.isEmpty()) {
                dataSourceList.add(new KeyValueDataSource(構成市町村.get(0).get市町村コード().value(),
                        setValue(構成市町村.get(0).get市町村コード().value(), 構成市町村.get(0).get市町村名称())));
            }
        } else {
            dataSourceList.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        }
        return dataSourceList;
    }

    private RString setValue(RString 市町村コード, RString 市町村名) {
        return new RStringBuilder().append(市町村コード).append(RString.HALF_SPACE).append(市町村名).toRString();
    }

}
