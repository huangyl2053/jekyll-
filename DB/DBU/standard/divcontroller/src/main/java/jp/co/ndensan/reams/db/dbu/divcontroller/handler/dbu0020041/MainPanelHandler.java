/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0020041;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020041.MainPanelDiv;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author yebangqiang
 */
public class MainPanelHandler {

    private static final RString 様式種類_008 = new RString("008");
    private static final RString 様式種類_108 = new RString("108");
    private static final RString 様式種類_009 = new RString("009");
    private static final RString 様式種類_109 = new RString("109");
    private static final RString 集計番号_1030 = new RString("1030");
    private static final RString 集計番号_1040 = new RString("1040");
    private final MainPanelDiv div;

    private MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     *
     * @param div
     * @return
     */
    public static MainPanelHandler of(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    // TODO QA中
    public void setGekihenTabTitle() {
        div.getShokuhikyojunofutannintei().getTblGekihen().setTitle(RString.EMPTY);
    }

    // TODO QA中
    public void setDaiyonDankaiTabTitle() {
        div.getShokuhikyojunofutannintei().getTblDaiyonDankai().setTitle(RString.EMPTY);
    }

    /**
     * 削除状態、パネルを非活性するメソッド
     */
    public void disableMainPanel() {
        div.setDisabled(true);
    }

    /**
     * 基本エリアの初期化するメソッド
     *
     * @param 更新前データ
     */
    public void initializeKihoneria(DbT7021JigyoHokokuTokeiDataEntity 更新前データ) {
        RStringBuilder 報告年月 = new RStringBuilder();
        報告年月.append(更新前データ.getHokokuYSeireki().toDateString());
        報告年月.append(更新前データ.getHokokuM());
        div.getHihokenshabango().getTxthokokuYM().setValue(new FlexibleDate(報告年月.toRString()));
        RStringBuilder 集計年月 = new RStringBuilder();
        集計年月.append(更新前データ.getShukeiTaishoYSeireki().toDateString());
        集計年月.append(更新前データ.getShukeiTaishoM());
        div.getHihokenshabango().getTxtShukeiYM().setValue(new FlexibleDate(集計年月.toRString()));
        // TODO
        div.getHihokenshabango().getTxtHihokenshabango().setValue(new RString("00010"));
        div.getHihokenshabango().getTxthihokenshamei().setValue(new RString("張三"));
    }

    /**
     * 更新前データリストの取得するメッソド
     *
     * @param 引き継ぎデータEntity
     * @return 更新前データリスト
     */
    public List<DbT7021JigyoHokokuTokeiDataEntity> get更新前データリスト(RString 引き継ぎデータEntity) {
        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = new ArrayList<>();
        return 更新前データリスト;
    }

    /**
     * 修正データの取得するメッソド
     *
     * @param 様式種類
     * @return 修正データリスト
     */
    public List<DbT7021JigyoHokokuTokeiDataEntity> get修正データ(RString 様式種類) {
        List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト = get更新前データリスト(様式種類);

        DbT7021JigyoHokokuTokeiDataEntity 更新前データ = 更新前データリスト.get(0);
        List<DbT7021JigyoHokokuTokeiDataEntity> 画面データリスト = new ArrayList<>();
        if (様式種類_008.equalsIgnoreCase(様式種類) || 様式種類_108.equalsIgnoreCase(様式種類)) {
            List<Decimal> 申請件数リスト = new ArrayList<>();
            set申請件数リスト(申請件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 申請件数リスト, new Decimal(1));
            List<Decimal> 利用者負担第三段階認定件数リスト = new ArrayList<>();
            set利用者負担第三段階認定件数リスト(利用者負担第三段階認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 利用者負担第三段階認定件数リスト, new Decimal(2));

            List<Decimal> 第三段階認定件数当該月末現在リスト = new ArrayList<>();
            set第三段階認定件数当該月末現在リスト(第三段階認定件数当該月末現在リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 第三段階認定件数当該月末現在リスト, new Decimal(3));

            List<Decimal> 利用者負担第二段階認定件数リスト = new ArrayList<>();
            set利用者負担第二段階認定件数リスト(利用者負担第二段階認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 利用者負担第二段階認定件数リスト, new Decimal(4));

            List<Decimal> 第二段階認定件数当該月末現在リスト = new ArrayList<>();
            set第二段階認定件数当該月末現在リスト(第二段階認定件数当該月末現在リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1040), 第二段階認定件数当該月末現在リスト, new Decimal(5));
        } else if (様式種類_009.equalsIgnoreCase(様式種類) || 様式種類_109.equalsIgnoreCase(様式種類)) {
            List<Decimal> 第4段階申請件数リスト = new ArrayList<>();
            set第4段階申請件数リスト(第4段階申請件数リスト);
            set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_1030), 第4段階申請件数リスト, new Decimal(1));
            List<Decimal> 食费のみ減額認定件数リスト = new ArrayList<>();
            set食费のみ減額認定件数リスト(食费のみ減額認定件数リスト);
            set画面データリスト(画面データリスト, 更新前データ, new Code(集計番号_1030), 食费のみ減額認定件数リスト, new Decimal(2));
            List<Decimal> 食费のみ減額認定件数累積リスト = new ArrayList<>();
            set食费のみ減額認定件数累積リスト(食费のみ減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费のみ減額認定件数累積リスト, new Decimal(3));
            List<Decimal> 居住費のみ減額認定件数リスト = new ArrayList<>();
            set居住費のみ減額認定件数リスト(居住費のみ減額認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 居住費のみ減額認定件数リスト, new Decimal(4));
            List<Decimal> 居住費のみ減額認定件数累積リスト = new ArrayList<>();
            set居住費のみ減額認定件数累積リスト(居住費のみ減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 居住費のみ減額認定件数累積リスト, new Decimal(5));
            List<Decimal> 食费及び居住費減額認定件数リスト = new ArrayList<>();
            set食费及び居住費減額認定件数リスト(食费及び居住費減額認定件数リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费及び居住費減額認定件数リスト, new Decimal(6));
            List<Decimal> 食费及び居住費減額認定件数累積リスト = new ArrayList<>();
            set食费及び居住費減額認定件数累積リスト(食费及び居住費減額認定件数累積リスト);
            set画面データリスト(
                    画面データリスト, 更新前データ, new Code(集計番号_1030), 食费及び居住費減額認定件数累積リスト, new Decimal(7));
        }

        List<DbT7021JigyoHokokuTokeiDataEntity> 修正データリスト = new ArrayList<>();
        for (int i = 0; i < 更新前データリスト.size(); i++) {
            if (!更新前データリスト.get(i).getShukeiKekkaAtai().equals(画面データリスト.get(i).getShukeiKekkaAtai())) {
                修正データリスト.add(画面データリスト.get(i));
            }
        }
        return 修正データリスト;
    }

    private DbT7021JigyoHokokuTokeiDataEntity get画面データ(
            DbT7021JigyoHokokuTokeiDataEntity 更新前データ,
            Code 集計番号,
            Decimal 横番号,
            Decimal 縦番号,
            Decimal 件数) {
        DbT7021JigyoHokokuTokeiDataEntity 画面データ = new DbT7021JigyoHokokuTokeiDataEntity();
        画面データ.setHokokuYSeireki(更新前データ.getHokokuYSeireki());
        画面データ.setHokokuM(更新前データ.getHokokuM());
        画面データ.setShukeiTaishoYSeireki(更新前データ.getShukeiTaishoYSeireki());
        画面データ.setShukeiTaishoM(更新前データ.getShukeiTaishoM());
        画面データ.setToukeiTaishoKubun(更新前データ.getToukeiTaishoKubun());
        画面データ.setShichosonCode(更新前データ.getShichosonCode());
        画面データ.setHyoNo(更新前データ.getHyoNo());
        画面データ.setShukeiNo(集計番号);
        画面データ.setShukeiTani(更新前データ.getShukeiTani());
        画面データ.setTateNo(縦番号);
        画面データ.setYokoNo(横番号);
        画面データ.setShukeiKekkaAtai(件数);
        return 画面データ;
    }

    private void set申請件数リスト(List<Decimal> 申請件数リスト) {
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeiKatsuKaigoShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiShinseiSu().getValue());
    }

    private void set利用者負担第三段階認定件数リスト(List<Decimal> 利用者負担第三段階認定件数リスト) {
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiKyojuhi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDaisanDankaiShokujihi().getValue());
        利用者負担第三段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDaisanDankaiKyojuhi().getValue());
    }

    private void set第三段階認定件数当該月末現在リスト(List<Decimal> 認定件数当該月末現在リスト) {
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDaisanDankaiToGetsumatsuKyojuhi().getValue());
    }

    private void set利用者負担第二段階認定件数リスト(List<Decimal> 利用者負担第二段階認定件数リスト) {
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDainiDankaiKyojuhi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiShokujihi().getValue());
        利用者負担第二段階認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiKyojuhi().getValue());
    }

    private void set第二段階認定件数当該月末現在リスト(List<Decimal> 認定件数当該月末現在リスト) {
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTextBoxNum31().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuShokujihi().getValue());
        認定件数当該月末現在リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiToGetsumatsuKyojuhi().getValue());
    }

    private void set画面データリスト(
            List 画面データリスト,
            DbT7021JigyoHokokuTokeiDataEntity 更新前データ,
            Code 集計番号,
            List<Decimal> 件数リスト,
            Decimal 縦番号) {
        for (int i = 0; i < 件数リスト.size(); i++) {
            画面データリスト.add(get画面データ(更新前データ, 集計番号, new Decimal(i + 1), 縦番号, 件数リスト.get(i)));
        }
    }

    private void set第4段階申請件数リスト(List<Decimal> 申請件数リスト) {
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShinseiSu().getValue());
        申請件数リスト.add(div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShinseiSu().getValue());
    }

    private void set食费のみ減額認定件数リスト(List<Decimal> 食费のみ減額認定件数リスト) {
        食费のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShokujihiGengakuNinteiSu().getValue());
        食费のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShokujihiGengakuNinteiSu().getValue());
        食费のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShokujihiGengakuNinteiSu().getValue());
    }

    private void set食费のみ減額認定件数累積リスト(List<Decimal> 食费のみ減額認定件数累積リスト) {
        食费のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShokujiGengakuNinteiKei().getValue());
        食费のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShokujiGengakuNinteiKei().getValue());
        食费のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShokujiGengakuNinteiKei().getValue());
    }

    private void set居住費のみ減額認定件数リスト(List<Decimal> 居住費のみ減額認定件数リスト) {
        居住費のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiSu().getValue());
        居住費のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiSu().getValue());
        居住費のみ減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiSu().getValue());
    }

    private void set居住費のみ減額認定件数累積リスト(List<Decimal> 居住費のみ減額認定件数累積リスト) {
        居住費のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiKei().getValue());
        居住費のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiKei().getValue());
        居住費のみ減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiKei().getValue());
    }

    private void set食费及び居住費減額認定件数リスト(List<Decimal> 食费及び居住費減額認定件数リスト) {
        食费及び居住費減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiSu().getValue());
        食费及び居住費減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiSu().getValue());
        食费及び居住費減額認定件数リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiSu().getValue());
    }

    private void set食费及び居住費減額認定件数累積リスト(List<Decimal> 食费及び居住費減額認定件数累積リスト) {
        食费及び居住費減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiKei().getValue());
        食费及び居住費減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiKei().getValue());
        食费及び居住費減額認定件数累積リスト.add(
                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiKei().getValue());
    }

    /**
     * 画面初期化メソッド
     *
     * @param 更新前データリスト
     * @param 様式種類
     */
    public void initializeTabList(List<DbT7021JigyoHokokuTokeiDataEntity> 更新前データリスト, RString 様式種類) {
        if (様式種類_008.equalsIgnoreCase(様式種類) || 様式種類_108.equalsIgnoreCase(様式種類)) {
            for (DbT7021JigyoHokokuTokeiDataEntity 更新前データ : 更新前データリスト) {
                Decimal 集計結果値 = 更新前データ.getShukeiKekkaAtai();
                switch (更新前データ.getTateNo().intValue()) {
                    case 1:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtFukushiShisetsuShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtHokenShisetsuShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtIryoShisetsuShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 4:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSeiKatsuKaigoShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 5:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtSonotaShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 6:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiShinseiSu().setValue(
                                        集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 2:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 4:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 5:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 6:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 7:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 8:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 9:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 10:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 11:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDaisanDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 12:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDaisanDankaiKyojuhi().setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 3:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 4:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 5:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 6:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 7:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 8:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 9:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 10:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 11:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDaisanDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 12:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDaisanDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 4:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 4:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 5:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 6:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 7:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 8:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 9:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDainiDankaiShokujihi().setValue(集計結果値);
                                break;
                            case 10:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDainiDankaiKyojuhi().setValue(集計結果値);
                                break;
                            case 11:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiShokujihi().
                                        setValue(集計結果値);
                                break;
                            case 12:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTxtKeiDainiDankaiKyojuhi().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 5:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel4().getTextBoxNum31().setValue(
                                        集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtFukushiShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 4:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtHokenShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 5:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 6:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtIryoShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 7:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 8:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSeikatsuKaigoShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 9:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDaiichiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 10:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtSonotaShisetsuDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            case 11:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDainiDankaiToGetsumatsuShokujihi().setValue(集計結果値);
                                break;
                            case 12:
                                div.getShokuhikyojunofutannintei().getTablePanel4().
                                        getTxtKeiDainiDankaiToGetsumatsuKyojuhi().setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                }
            }
        } else if (様式種類_009.equalsIgnoreCase(様式種類) || 様式種類_109.equalsIgnoreCase(様式種類)) {
            for (DbT7021JigyoHokokuTokeiDataEntity 更新前データ : 更新前データリスト) {
                Decimal 集計結果値 = 更新前データ.getShukeiKekkaAtai();
                switch (更新前データ.getTateNo().intValue()) {
                    case 1:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShinseiSu().setValue(
                                        集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShinseiSu().setValue(
                                        集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 2:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().
                                        getTxtDanichigouShokujihiGengakuNinteiSu().setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().
                                        getTxtDannigouShokujihiGengakuNinteiSu().setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().
                                        getTxtGokeiShokujihiGengakuNinteiSu().setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 3:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().
                                        getTxtDanichigouShokujiGengakuNinteiKei().setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouShokujiGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiShokujiGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 4:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 5:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouKyojuhiGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouKyojuhiGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiKyojuhiGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 6:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiSu().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                    case 7:
                        switch (更新前データ.getYokoNo().intValue()) {
                            case 1:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDanichigouSJGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            case 2:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtDannigouSJGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            case 3:
                                div.getShokuhikyojunofutannintei().getTablePanel3().getTxtGokeiSJGengakuNinteiKei().
                                        setValue(集計結果値);
                                break;
                            default:
                                break;
                        }
                }
            }
        }
    }

    /**
     * 整合性判断するメソッド
     *
     * @param 第1号被保険者
     * @param 第2号被保険者
     * @param 合計
     * @return
     */
    public boolean is第4段階データ整合(Decimal 第1号被保険者, Decimal 第2号被保険者, Decimal 合計) {
        return !第1号被保険者.add(第2号被保険者).equals(合計);
    }
}
