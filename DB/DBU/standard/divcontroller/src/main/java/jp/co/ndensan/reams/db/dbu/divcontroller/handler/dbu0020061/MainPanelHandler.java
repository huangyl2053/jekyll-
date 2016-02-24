/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020061;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020061.MainPanelDiv;
//import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告（月報）補正発行_様式１(別紙)のクラス
 */
public final class MainPanelHandler {

    private static final RString 修正 = new RString("修正");
    private static final Decimal データ = new Decimal(00010);
    private static final Decimal データ_TWO = new Decimal(2);
    private static final Decimal データ_THREE = new Decimal(3);
    private static final Decimal データ_FOUR = new Decimal(4);
    private final MainPanelDiv div;

    private MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * ofメソッド
     *
     * @param div MainPanelDiv
     * @return MainPanelHandler
     */
    public static MainPanelHandler of(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    /**
     * メソッド
     */
    public void disableMainPanel() {
        div.setDisabled(true);
    }

    /**
     * 更新前データリスト取得
     *
     * @param 引き継ぎデータEntity RString
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>
     */
//    public List<DbT7021JigyoHokokuTokeiDataEntity> get更新前データリスト(RString 引き継ぎデータEntity) {
//        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = new ArrayList<>();
//        //TODO ビジネス設計_DBUMN91003_事業報告（月報）補正発行.xlsxの「事業報告月報詳細データの取得」を呼び出す
//        //DbT7021JigyoHokokuTokeiDataEntity 事業報告統計データEntityリスト =
////        getJigyoHokokuGeppoDetal(報告年, 報告月, 集計対象年, 集計対象月, 統計対象区分, 市町村コード, 表番号, 集計番号);
//        return 更新前データリスト;
//    }
    /**
     * 画面初期化処理します。
     *
     * @param 更新前データ DbT7021JigyoHokokuTokeiDataEntity
     */
//    public void 更新前データリスト初期化(DbT7021JigyoHokokuTokeiDataEntity 更新前データ) {
//        div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTennyu().setValue(データ);
//        div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoShokkenfukkatsu().setValue(データ);
//        div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZorokugosaitotatsu().setValue(データ);
//        div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTekiyojogaihi().setValue(データ);
//    }
    /**
     * 画面データ取得
     *
     * @param 更新前データ DbT7021JigyoHokokuTokeiDataEntity
     * @param 集計番号 Code
     * @param 横番号 Decimal
     * @param 縦番号 Decimal
     * @param 件数 Decimal
     * @return DbT7021JigyoHokokuTokeiDataEntity
     */
//    private DbT7021JigyoHokokuTokeiDataEntity get画面データ(
//            DbT7021JigyoHokokuTokeiDataEntity 更新前データ,
//            Code 集計番号,
//            Decimal 横番号,
//            Decimal 縦番号,
//            Decimal 件数) {
//        DbT7021JigyoHokokuTokeiDataEntity 画面データ = new DbT7021JigyoHokokuTokeiDataEntity();
//        画面データ.setHokokuYSeireki(更新前データ.getHokokuYSeireki());
//        画面データ.setHokokuM(更新前データ.getHokokuM());
//        画面データ.setShukeiTaishoYSeireki(更新前データ.getShukeiTaishoYSeireki());
//        画面データ.setShukeiTaishoM(更新前データ.getShukeiTaishoM());
//        画面データ.setToukeiTaishoKubun(更新前データ.getToukeiTaishoKubun());
//        画面データ.setShichosonCode(更新前データ.getShichosonCode());
//        画面データ.setHyoNo(更新前データ.getHyoNo());
//        画面データ.setShukeiNo(集計番号);
//        画面データ.setShukeiTani(更新前データ.getShukeiTani());
//        画面データ.setTateNo(縦番号);
//        画面データ.setYokoNo(横番号);
//        画面データ.setShukeiKekkaAtai(件数);
//        return 画面データ;
//    }
    /**
     * 修正データ取得
     *
     * @param 引き継ぎデータEntity RString
     * @return List<DbT7021JigyoHokokuTokeiDataEntity>
     */
//    public List<DbT7021JigyoHokokuTokeiDataEntity> get修正データ(RString 引き継ぎデータEntity) {
//        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = get更新前データリスト(引き継ぎデータEntity);
//        DbT7021JigyoHokokuTokeiDataEntity 更新前データ = 更新前データリスト.get(0);
//        List<DbT7021JigyoHokokuTokeiDataEntity> 画面データリスト = new ArrayList<>();
//        List<Decimal> 計リスト = new ArrayList<>();
//        set計リスト(計リスト);
//        set画面データリスト(画面データリスト, 更新前データ, new Code(new RString("0100")), 計リスト, Decimal.ONE, Decimal.ONE);
//        set画面データリスト(画面データリスト, 更新前データ, new Code(new RString("0100")), 計リスト, データ_TWO, Decimal.ONE);
//        set画面データリスト(画面データリスト, 更新前データ, new Code(new RString("0100")), 計リスト, データ_THREE, Decimal.ONE);
//        set画面データリスト(画面データリスト, 更新前データ, new Code(new RString("0100")), 計リスト, データ_FOUR, Decimal.ONE);
//        List<DbT7021JigyoHokokuTokeiDataEntity> 修正データリスト = new ArrayList<>();
//        for (int i = 0; i < 更新前データリスト.size(); i++) {
//            if (!更新前データリスト.get(i).getShukeiKekkaAtai().equals(画面データリスト.get(i).getShukeiKekkaAtai())) {
//                修正データリスト.add(画面データリスト.get(i));
//            }
//        }
//        return 修正データリスト;
//    }
    /**
     * 画面データリスト取得
     *
     * @param 画面データリスト List
     * @param 更新前データ DbT7021JigyoHokokuTokeiDataEntity
     * @param 集計番号 Code
     * @param 件数リスト List<Decimal>
     * @param 横番号 Decimal
     * @param 縦番号 Decimal
     */
//    private void set画面データリスト(
//            List 画面データリスト,
//            DbT7021JigyoHokokuTokeiDataEntity 更新前データ,
//            Code 集計番号,
//            List<Decimal> 件数リスト,
//            Decimal 横番号,
//            Decimal 縦番号) {
//        for (int i = 0; i < 件数リスト.size(); i++) {
//            画面データリスト.add(get画面データ(更新前データ, new Code(new RString("0010")), new Decimal(i + 1), new Decimal(1), 件数リスト.get(i)));
//        }
//    }
    /**
     * 計リスト取得
     *
     * @param 計リスト List<Decimal>
     */
    private void set計リスト(List<Decimal> 計リスト) {
        計リスト.add(div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTennyu().getValue());
        計リスト.add(div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoShokkenfukkatsu().getValue());
        計リスト.add(div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZorokugosaitotatsu().getValue());
        計リスト.add(div.getDaiichigohiHokenshazogenUchiWake().getTblSetaiSu().getTxtTonenZoTekiyojogaihi().getValue());
    }

}
