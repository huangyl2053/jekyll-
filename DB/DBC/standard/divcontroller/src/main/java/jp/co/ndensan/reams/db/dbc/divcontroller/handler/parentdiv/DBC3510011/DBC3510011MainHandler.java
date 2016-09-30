/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu.HokenshaJoHoList;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.dgSofuDataIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.dgSofuJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 保険者情報送付のコントローラクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class DBC3510011MainHandler {

    private static final int 国保連送付媒体ファイル名称_START = 3;
    private static final int 国保連送付媒体ファイル名称_END = 6;
    private final DBC3510011MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public DBC3510011MainHandler(DBC3510011MainDiv div) {
        this.div = div;
    }

    /**
     * set送付情報リストの設定します。
     *
     * @param 送付情報List 送付情報List
     */
    public void set送付情報リスト(List<HokenshaJoHoList> 送付情報List) {
        List<dgSofuJohoIchiran_Row> rowList = new ArrayList<>();
        for (HokenshaJoHoList 送付情報 : 送付情報List) {
            RString コード = 送付情報.getファイル名の先頭6桁().substring(国保連送付媒体ファイル名称_START, 国保連送付媒体ファイル名称_END);
            UzT0007CodeEntity コードマスタ = CodeMaster.getCode(DBCCodeShubetsu.国保連送付媒体ファイル名称.getコード(), new Code(コード));
            RStringBuilder 媒体数 = new RStringBuilder();
            媒体数.append(new RString("媒体"));
            媒体数.append(new RString(送付情報.get共有ファイル名().size()));
            媒体数.append(new RString("枚目"));
            TextBoxNum 表示順 = new TextBoxNum();
            表示順.setValue(new Decimal(コードマスタ.get表示順()));
            RString 送付情報_RString = DataPassingConverter.serialize(送付情報);
            RString 送付情報名称 = コードマスタ.getコード名称();
            if (!RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBC.国保連高額合算運用_後期国保個別処理開始年月, RDate.getNowDate()))
                    && new RString("37K").equals(送付情報名称)) {
                if (new RString("1").equals(コード)) {
                    送付情報名称.concat(new RString("（国保分）"));
                } else if (new RString("2").equals(コード)) {
                    送付情報名称.concat(new RString("（後期分）"));
                }
            }
            dgSofuJohoIchiran_Row row = new dgSofuJohoIchiran_Row(送付情報名称, 媒体数.toRString(), RString.EMPTY, 表示順, 送付情報_RString);
            rowList.add(row);
        }
        Collections.sort(rowList, new DataComparator());
        div.getHokenshaSofuList().getDgSofuJohoIchiran().setDataSource(rowList);
    }

    /**
     * 送付データ一覧の設定します。
     */
    public void set送付データ一覧() {
        dgSofuJohoIchiran_Row row = div.getHokenshaSofuList().getDgSofuJohoIchiran().getClickedItem();
        HokenshaJoHoList hokenshaJoHo = DataPassingConverter.deserialize(row.getHdnHokenshaJoHoList(), HokenshaJoHoList.class);
        div.getTxtSofuJohoMeisho().setValue(row.getSofuJohoMeisho());
        List<dgSofuDataIchiran_Row> 送付データList = new ArrayList<>();
        for (RString 共有ファイル名 : hokenshaJoHo.get共有ファイル名()) {
            送付データList.add(new dgSofuDataIchiran_Row(RString.EMPTY, 共有ファイル名));
        }
        div.getDgSofuDataIchiran().setDataSource(送付データList);
    }

    private static class DataComparator implements Comparator<dgSofuJohoIchiran_Row>, Serializable {

        @Override
        public int compare(dgSofuJohoIchiran_Row o1, dgSofuJohoIchiran_Row o2) {
            return o2.getHdnHyojiJun().getValue().compareTo(o1.getHdnHyojiJun().getValue());
        }
    }
}
