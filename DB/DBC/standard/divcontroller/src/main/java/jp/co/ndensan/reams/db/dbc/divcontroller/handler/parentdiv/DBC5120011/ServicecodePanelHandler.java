/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5120011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011.ServicecodePanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShuruiManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * @param list List<RString>
     * @return List<RString>
     */
    public List<RString> sort昇順ByKey(List<RString> list) {
        if (list.isEmpty()) {
            return list;
        }
        Collections.sort(list,
                new Comparator<RString>() {
                    @Override
                    public int compare(RString arg0, RString arg1) {
                        return arg0.compareTo(arg1);
                    }
                }
        );
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
}
