/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinKadouKahiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者基本情報の稼働可否の判定バッチ処理です。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
public class TokuteiKojinKadouKahiHanteiProcess extends SimpleBatchProcessBase {

    private TokuteiKojinKadouKahiHanteiProcessParameter processParameter;

    /**
     * 新規異動区分の判定です。
     */
    public static final RString HANNOJOHOLIST;

    static {
        HANNOJOHOLIST = new RString("hanNoJohoList");
    }
    private OutputParameter<List<TokuteiKojinJohoHanKanri>> hanNoJohoList;

    @Override
    protected void process() {
        hanNoJohoList = new OutputParameter<>();
        List<TokuteiKojinJohoHanKanri> 版番号情報List = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(
                processParameter.get新規異動区分(), processParameter.get特定個人情報名コードList(),
                processParameter.getデータセット番号(), processParameter.getシステム日付());
        List<TokuteiKojinJohoHanKanri> 具合版番号情報List = new ArrayList<>();
        for (TokuteiKojinJohoHanKanri 版番号情報 : 版番号情報List) {
            if (((ShinkiIdoKubun.当初.getコード().equals(processParameter.get新規異動区分())
                    || ShinkiIdoKubun.版改定.getコード().equals(processParameter.get新規異動区分()))
                    && !ShokaiTeikyoKubun.初回提供済み.getコード().equals(版番号情報.get初回提供区分()))
                    || ((ShinkiIdoKubun.再登録.getコード().equals(processParameter.get新規異動区分())
                    || ShinkiIdoKubun.異動.getコード().equals(processParameter.get新規異動区分()))
                    && !ShokaiTeikyoKubun.未提供.getコード().equals(版番号情報.get初回提供区分()))) {
                具合版番号情報List.add(版番号情報);
            }
        }
        hanNoJohoList.setValue(具合版番号情報List);
    }
}
