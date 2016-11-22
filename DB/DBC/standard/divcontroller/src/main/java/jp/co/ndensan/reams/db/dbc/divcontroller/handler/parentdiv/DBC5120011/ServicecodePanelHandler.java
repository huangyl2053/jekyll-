/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.DBC150030_ServicecodeRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.KoseiShichosonInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011.ServicecodePanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * サービスコード別利用状況です
 *
 * @reamsid_L DBC-3340-010 lihang
 */
public class ServicecodePanelHandler {

    private final ServicecodePanelDiv div;
    private static final RString ELEVEN = new RString("11");
    private static final RString TWELVE = new RString("12");
    private static final RString THIRTEEN = new RString("13");
    private static final RString FORTEEN = new RString("14");
    private static final RString FIFTEEN = new RString("15");
    private static final RString SIXTEEN = new RString("16");
    private static final RString SEVENTEEN = new RString("17");
    private static final RString TWENTYONE = new RString("21");
    private static final RString TWENTYTWO = new RString("22");
    private static final RString TWENTYTHREE = new RString("23");
    private static final RString TWENTYFOUR = new RString("24");
    private static final RString TWENTYFIVE = new RString("25");
    private static final RString TWENTYSIX = new RString("26");
    private static final RString TWENTYSEVEN = new RString("27");
    private static final RString TWENTYEIGHT = new RString("28");
    private static final RString THIRTYONE = new RString("31");
    private static final RString THIRTYTWO = new RString("32");
    private static final RString THIRTYTHREE = new RString("33");
    private static final RString THIRTYONEFOUR = new RString("34");
    private static final RString THIRTYFIVE = new RString("35");
    private static final RString THIRTYSIX = new RString("36");
    private static final RString THIRTYSEVEN = new RString("37");
    private static final RString THIRTYEIGHT = new RString("38");
    private static final RString THIRTYNINE = new RString("39");
    private static final RString FORTYTHREE = new RString("43");
    private static final RString FORTYSIX = new RString("46");
    private static final RString FIFTYONE = new RString("51");
    private static final RString FIFTYTWO = new RString("52");
    private static final RString FIFTYTHREE = new RString("53");
    private static final RString FIFTYFOUR = new RString("54");
    private static final RString FIFTYNINE = new RString("59");
    private static final RString SIXTYONE = new RString("61");
    private static final RString SIXTYTWO = new RString("62");
    private static final RString SIXTYTHREE = new RString("63");
    private static final RString SIXTYFORE = new RString("64");
    private static final RString SIXTYFIVE = new RString("65");
    private static final RString SIXTYSIX = new RString("66");
    private static final RString SIXTYSEVEN = new RString("67");
    private static final RString SIXTYEIGHT = new RString("68");
    private static final RString SIXTYNINE = new RString("69");
    private static final RString SEVENTYONE = new RString("71");
    private static final RString SEVENTYTWO = new RString("72");
    private static final RString SEVENTYTHREE = new RString("73");
    private static final RString SEVENTYFOUR = new RString("74");
    private static final RString SEVENTYFIVE = new RString("75");
    private static final RString SEVENTYONESIX = new RString("76");
    private static final RString SEVENTYSEVEN = new RString("77");
    private static final RString SEVENTYEIGHT = new RString("78");
    private static final RString SEVENTYNINE = new RString("79");
    private static final RString ZERO = new RString("00");
    private static final RString KEY_対象年月指定 = new RString("対象年月指定");
    private static final RString KEY_年月範囲開始 = new RString("年月範囲開始");
    private static final RString KEY_年月範囲終了 = new RString("年月範囲終了");
    private static final RString KEY_対象サービス種類 = new RString("対象サービス種類");
    private static final RString KEY_サービス項目コードのまとめ方 = new RString("サービス項目コードのまとめ方");
    private static final RString KEY_選択対象 = new RString("選択対象");
    private static final RString KEY_市町村情報 = new RString("市町村情報");
    private static final RString KEY_旧市町村情報 = new RString("旧市町村情報");
    private static final Comparator COMPARABLE = new Comparator<RString>() {
        @Override
        public int compare(RString arg0, RString arg1) {
            return arg0.compareTo(arg1);
        }
    };

    /**
     * コンストラクタです。
     *
     *
     * @param div ShinseishoHakkoDiv
     */
    public ServicecodePanelHandler(ServicecodePanelDiv div) {
        this.div = div;
    }

    /**
     * getサービス種類名称
     */
    public void getサービス種類名称() {

        div.getChusyutsuPanel().getDdlshurui().setDataSource(
                KaigoServiceShuruiManager.createInstance().getサービス種類DDL(get種類コードリスト()));
        div.getChusyutsuPanel().getDdlshurui().setSelectedKey(ZERO);

    }

    /**
     * sort昇順ByKey
     *
     * @param list RString
     * @return RString
     */
    public List<RString> sort昇順ByKey(List<RString> list) {
        if (list.isEmpty()) {
            return list;
        }
        Collections.sort(list, COMPARABLE);
        return list;
    }

    private List<ServiceShuruiCode> get種類コードリスト() {

        List<ServiceShuruiCode> list = new ArrayList<>();
        list.add(new ServiceShuruiCode(ELEVEN));
        list.add(new ServiceShuruiCode(TWELVE));
        list.add(new ServiceShuruiCode(THIRTEEN));
        list.add(new ServiceShuruiCode(FORTEEN));
        list.add(new ServiceShuruiCode(FIFTEEN));
        list.add(new ServiceShuruiCode(SIXTEEN));
        list.add(new ServiceShuruiCode(SEVENTEEN));
        list.add(new ServiceShuruiCode(TWENTYONE));
        list.add(new ServiceShuruiCode(TWENTYTWO));
        list.add(new ServiceShuruiCode(TWENTYTHREE));
        list.add(new ServiceShuruiCode(TWENTYFOUR));
        list.add(new ServiceShuruiCode(TWENTYFIVE));
        list.add(new ServiceShuruiCode(TWENTYSIX));
        list.add(new ServiceShuruiCode(TWENTYSEVEN));
        list.add(new ServiceShuruiCode(TWENTYEIGHT));
        list.add(new ServiceShuruiCode(THIRTYONE));
        list.add(new ServiceShuruiCode(THIRTYTWO));
        list.add(new ServiceShuruiCode(THIRTYTHREE));
        list.add(new ServiceShuruiCode(THIRTYONEFOUR));
        list.add(new ServiceShuruiCode(THIRTYFIVE));
        list.add(new ServiceShuruiCode(THIRTYSIX));
        list.add(new ServiceShuruiCode(THIRTYSEVEN));
        list.add(new ServiceShuruiCode(THIRTYEIGHT));
        list.add(new ServiceShuruiCode(THIRTYNINE));
        list.add(new ServiceShuruiCode(FORTYTHREE));
        list.add(new ServiceShuruiCode(FORTYSIX));
        list.add(new ServiceShuruiCode(FIFTYONE));
        list.add(new ServiceShuruiCode(FIFTYTWO));
        list.add(new ServiceShuruiCode(FIFTYTHREE));
        list.add(new ServiceShuruiCode(FIFTYFOUR));
        list.add(new ServiceShuruiCode(FIFTYNINE));
        list.add(new ServiceShuruiCode(SIXTYONE));
        list.add(new ServiceShuruiCode(SIXTYTWO));
        list.add(new ServiceShuruiCode(SIXTYTHREE));
        list.add(new ServiceShuruiCode(SIXTYFORE));
        list.add(new ServiceShuruiCode(SIXTYFIVE));
        list.add(new ServiceShuruiCode(SIXTYSIX));
        list.add(new ServiceShuruiCode(SIXTYSEVEN));
        list.add(new ServiceShuruiCode(SIXTYEIGHT));
        list.add(new ServiceShuruiCode(SIXTYNINE));
        list.add(new ServiceShuruiCode(SEVENTYONE));
        list.add(new ServiceShuruiCode(SEVENTYTWO));
        list.add(new ServiceShuruiCode(SEVENTYTHREE));
        list.add(new ServiceShuruiCode(SEVENTYFOUR));
        list.add(new ServiceShuruiCode(SEVENTYFIVE));
        list.add(new ServiceShuruiCode(SEVENTYONESIX));
        list.add(new ServiceShuruiCode(SEVENTYSEVEN));
        list.add(new ServiceShuruiCode(SEVENTYEIGHT));
        list.add(new ServiceShuruiCode(SEVENTYNINE));
        return list;

    }

    /**
     * バッチパラメータをセットする
     *
     * @return DBC150030_ServicecodeRiyojokyoParameter
     */
    public DBC150030_ServicecodeRiyojokyoParameter getBatchParameter() {
        DBC150030_ServicecodeRiyojokyoParameter parameter = new DBC150030_ServicecodeRiyojokyoParameter();
        parameter.set対象年月指定(div.getChusyutsuPanel().getRadtaishoYm().getSelectedKey());
        if (null != div.getChusyutsuPanel().getTxthani().getFromValue()) {
            parameter.set年月範囲開始(new FlexibleYearMonth(div.getChusyutsuPanel().getTxthani().getFromValue().getYearMonth().toDateString()));
        }
        if (null != div.getChusyutsuPanel().getTxthani().getToValue()) {
            parameter.set年月範囲終了(new FlexibleYearMonth(div.getChusyutsuPanel().getTxthani().getToValue().getYearMonth().toDateString()));
        }
        parameter.set対象サービス種類(div.getChusyutsuPanel().getDdlshurui().getSelectedKey());
        parameter.setサービス項目コードのまとめ方(div.getSekkeiPanel().getDdlmatome().getSelectedKey());
        parameter.set選択対象(div.getCcdChikuShichosonSelect().get選択対象());
        Map<RString, RString> map = div.getCcdChikuShichosonSelect().get選択結果();
        RString mapValue = DataPassingConverter.serialize((Serializable) map);
        div.setHdnSelectedMap(mapValue);
        List<RString> list = new ArrayList<>();
        if (null != map && !map.isEmpty()) {
            for (RString key : map.keySet()) {
                list.add(key);
            }
        }
        parameter.set対象コードリスト(sort昇順ByKey(list));
        KoseiShichosonInfo 市町村情報 = new KoseiShichosonInfo();
        市町村情報.setコード(div.getCcdChikuShichosonSelect().get市町村コード());
        市町村情報.set名称(div.getCcdChikuShichosonSelect().get市町村名称());
        KoseiShichosonInfo 旧市町村情報 = new KoseiShichosonInfo();
        旧市町村情報.setコード(div.getCcdChikuShichosonSelect().get旧市町村コード());
        旧市町村情報.set名称(div.getCcdChikuShichosonSelect().get旧市町村名称());
        parameter.set市町村情報(市町村情報);
        parameter.set旧市町村情報(旧市町村情報);
        return parameter;
    }

    /**
     * 条件を復元する
     */
    public void setBatchParameterRestore() {
        BatchParameterMap restoreMap = div.getJokenFukugenHozon().getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 対象年月指定 = restoreMap.getParameterValue(RString.class, KEY_対象年月指定);
        FlexibleYearMonth 年月範囲開始 = restoreMap.getParameterValue(FlexibleYearMonth.class, KEY_年月範囲開始);
        FlexibleYearMonth 年月範囲終了 = restoreMap.getParameterValue(FlexibleYearMonth.class, KEY_年月範囲終了);
        RString 対象サービス種類 = restoreMap.getParameterValue(RString.class, KEY_対象サービス種類);
        RString サービス項目コードのまとめ方 = restoreMap.getParameterValue(RString.class, KEY_サービス項目コードのまとめ方);
        RString 選択対象 = restoreMap.getParameterValue(RString.class, KEY_選択対象);
        KoseiShichosonInfo 市町村情報 = restoreMap.getParameterValue(KoseiShichosonInfo.class, KEY_市町村情報);
        KoseiShichosonInfo 旧市町村情報 = restoreMap.getParameterValue(KoseiShichosonInfo.class, KEY_旧市町村情報);

        if (対象年月指定 != null) {
            div.getChusyutsuPanel().getRadtaishoYm().setSelectedKey(対象年月指定);
        }
        if (年月範囲開始 != null) {
            div.getChusyutsuPanel().getTxthani().setFromValue(new RDate(年月範囲開始.toString()
                    .concat(String.valueOf(RDate.getNowDate().getDayValue()))));
        }
        if (年月範囲終了 != null) {
            div.getChusyutsuPanel().getTxthani().setToValue(new RDate(年月範囲終了.toString()
                    .concat(String.valueOf(RDate.getNowDate().getDayValue()))));
        }
        if (対象サービス種類 != null) {
            div.getChusyutsuPanel().getDdlshurui().setSelectedKey(対象サービス種類);
        }
        if (サービス項目コードのまとめ方 != null) {
            div.getSekkeiPanel().getDdlmatome().setSelectedKey(サービス項目コードのまとめ方);
        }
        if (選択対象 != null) {
            div.getCcdChikuShichosonSelect().set選択対象(選択対象);
        }
        Map<RString, RString> 選択結果 = DataPassingConverter.deserialize(div.getHdnSelectedMap(), Map.class);
        if (選択結果 != null) {
            div.getCcdChikuShichosonSelect().set選択結果(選択結果);
        }
        if (市町村情報 != null) {
            div.getCcdChikuShichosonSelect().set市町村コード(市町村情報.getコード());
        }
        if (旧市町村情報 != null) {
            div.getCcdChikuShichosonSelect().set旧市町村コード(旧市町村情報.getコード());
        }
    }
}
