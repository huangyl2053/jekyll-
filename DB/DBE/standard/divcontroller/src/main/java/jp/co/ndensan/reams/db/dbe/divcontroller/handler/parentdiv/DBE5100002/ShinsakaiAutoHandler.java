/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE510001.DBE510001_ShinsakaiAutoWaritsukeParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.ShinsakaiAutoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsGogitaiDummy;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 審査会自動割付の取得するクラスです。
 *
 * @reamsid_L DBE-1350-030 lizhuoxuan
 */
public class ShinsakaiAutoHandler {

    private final ShinsakaiAutoDiv shindiv;

    /**
     * コンストラクタです。
     *
     * @param shindiv 審査会自動割付
     */
    public ShinsakaiAutoHandler(ShinsakaiAutoDiv shindiv) {
        this.shindiv = shindiv;
    }

    /**
     * 審査会自動割付初期処理する。
     *
     * @param shinsaKayiList 審査会自動割付
     */
    public void onLoad(List<ShinsaKayiJidouWaritsukeBusiness> shinsaKayiList) {
        List<dgShinsakaiIchiran_Row> dgShinsakaiIchiranList = new ArrayList<>();
        if (shinsaKayiList != null && !shinsaKayiList.isEmpty()) {
            for (ShinsaKayiJidouWaritsukeBusiness jigyoshaInput : shinsaKayiList) {
                dgShinsakaiIchiran_Row dgShinsakaiIchiran = new dgShinsakaiIchiran_Row();
                dgShinsakaiIchiran.setKaisaino(jigyoshaInput.get審査会開催番号());
                dgShinsakaiIchiran.setShinsakainame(jigyoshaInput.get審査会名称());
                dgShinsakaiIchiran.setGogitainame(jigyoshaInput.get合議体名称());
                if (jigyoshaInput.is種類()) {
                    dgShinsakaiIchiran.setShurui(new RString("精"));
                }
                dgShinsakaiIchiran.setShinsakaikaijyo(jigyoshaInput.get審査会会場());
                dgShinsakaiIchiran.getKaisaibi().setValue(new RDate(jigyoshaInput.get開催日().toString()));
                dgShinsakaiIchiran.getStrattime().setValue(new RTime(jigyoshaInput.get開始時間()));
                dgShinsakaiIchiran.getEndtime().setValue(new RTime(jigyoshaInput.get終了時間()));
                dgShinsakaiIchiran.getShinsakaiJidoWariateTeiin();
                dgShinsakaiIchiran.setWaritsukeninzu(jigyoshaInput.get割付人数());
                dgShinsakaiIchiran.setShinchokuJokyo(ShinsakaiShinchokuJokyo.toValue(jigyoshaInput.get進捗状況()).get画面表示名称());
                dgShinsakaiIchiran.setDammyflag(IsGogitaiDummy.toValue(jigyoshaInput.isダミーフラグ()).is合議体ダミーフラグTrue());
                dgShinsakaiIchiran.setShinsakaiJidoWariateTeiin(jigyoshaInput.get自動割付定員());
                dgShinsakaiIchiranList.add(dgShinsakaiIchiran);
            }
            shindiv.getDgShinsakaiIchiran().setDataSource(dgShinsakaiIchiranList);
        } else {
            shindiv.getDgShinsakaiIchiran().setDataSource(dgShinsakaiIchiranList);
        }
    }

    /**
     * 審査会自動割付画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return List<TaisyosyaJidoWaritsukeBatchParameter>
     */
    public DBE510001_ShinsakaiAutoWaritsukeParameter setBatchParameter() {

        List<RString> shinsakaiKaisaiNo = new ArrayList<>();
        List<FlexibleDate> kaisaiYMD = new ArrayList<>();
        List<Integer> shinsakaiWaritsukeNinsu = new ArrayList<>();
        List<Integer> shinsakaiJidoWariateTeiin = new ArrayList<>();
        for (dgShinsakaiIchiran_Row row : shindiv.getDgShinsakaiIchiran().getDataSource()) {
            if (row.getSelected()) {
                shinsakaiKaisaiNo.add(row.getKaisaino());
                kaisaiYMD.add(row.getKaisaibi().getValue() == null ? FlexibleDate.EMPTY
                        : new FlexibleDate(row.getKaisaibi().getValue().toDateString()));
                shinsakaiWaritsukeNinsu.add(Integer.valueOf(row.getWaritsukeninzu().toString()));
                shinsakaiJidoWariateTeiin.add(Integer.valueOf(row.getShinsakaiJidoWariateTeiin().toString()));
            }
        }
        return new DBE510001_ShinsakaiAutoWaritsukeParameter(shinsakaiKaisaiNo, kaisaiYMD, shinsakaiWaritsukeNinsu, shinsakaiJidoWariateTeiin);
    }
}
