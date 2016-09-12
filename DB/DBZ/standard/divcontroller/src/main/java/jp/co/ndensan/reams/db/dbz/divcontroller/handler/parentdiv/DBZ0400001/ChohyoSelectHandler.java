/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400001.ChohyoSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400001.dgChohyoIchiran_Row;

/**
 * 帳票選択データの取得処理クラスです。
 *
 * @reamsid_L DBA-1201-010 wanghui
 */
public class ChohyoSelectHandler {

    private final ChohyoSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 資格不整合修正Div
     */
    public ChohyoSelectHandler(ChohyoSelectDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     * @param 分類名称 List<ChohyoSeigyoKyotsu>
     */
    public void initialize(List<ChohyoSeigyoKyotsu> 分類名称) {

        List<dgChohyoIchiran_Row> rowList = new ArrayList<>();
        for (ChohyoSeigyoKyotsu kyotsu : 分類名称) {
            dgChohyoIchiran_Row row = new dgChohyoIchiran_Row();
            row.setChohyoBunruiId(kyotsu.get帳票分類ID().value());
            row.setChohyoBunruiName(kyotsu.get帳票分類名称());
            rowList.add(row);
        }
        div.getDgChohyoIchiran().setDataSource(rowList);
    }
}
