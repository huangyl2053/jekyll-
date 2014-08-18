/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.JogaiJushochitokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.mapper.JogaiJushochitokureiTaishoShisetsuMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.JogaiJushochitokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護除外・住所地特例対象施設を管理するクラスです。
 *
 * @author N3317 塚田 萌
 */
//TODO n3317塚田萌　get以外のメソッドは本実装で対応する。
public class JogaiJushochitokureiTaishoShisetsuManager {

    private final JogaiJushochitokureiTaishoShisetsuDac dac;

    /**
     * デフォルトコンストラクタです。
     */
    public JogaiJushochitokureiTaishoShisetsuManager() {
        dac = InstanceProvider.create(JogaiJushochitokureiTaishoShisetsuDac.class);
    }

    /**
     * 外部からDacを取得する、テスト用パッケージプライベートコンストラクタです。
     *
     * @param dac テスト用Dac
     */
    JogaiJushochitokureiTaishoShisetsuManager(JogaiJushochitokureiTaishoShisetsuDac dac) {
        this.dac = dac;
    }

    /**
     * 施設種類と施設コードを指定して、該当する1件の施設情報を取得します。<br/>
     * 該当する情報がなかった時はnullを返します。
     *
     * @param 施設種類 施設種類
     * @param 施設コード 施設コード
     * @return 施設情報
     */
    public JogaiJushochitokureiTaishoShisetsu get対象施設(ShisetsuType 施設種類, ShisetsuCode 施設コード) {
        DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity = dac.select(施設種類, 施設コード);

        if (entity == null) {
            return null;
        }
        return JogaiJushochitokureiTaishoShisetsuMapper.to除外_住所地特例対象施設(entity);
    }
}
