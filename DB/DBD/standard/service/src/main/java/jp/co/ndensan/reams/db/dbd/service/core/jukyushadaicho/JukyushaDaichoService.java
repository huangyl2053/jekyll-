/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.jukyushadaicho;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.jukyushajaicho.JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho.IJukyushaDaichoMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳情報を取得とDB出力(受給者台帳)。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public class JukyushaDaichoService {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    JukyushaDaichoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * JukyushaDaichoServiceのIntanceを作成します。
     *
     * @return JukyushaDaichoService
     */
    public static JukyushaDaichoService createJukyushaDaichoService() {
        return InstanceProvider.create(JukyushaDaichoService.class);
    }

    /**
     * 受給者台帳情報を取得。
     *
     * @param parameter JukyushaDaichoParameter
     * @return JukyushaDaicho
     */
    @Transaction
    public JukyushaDaicho get受給者台帳(JukyushaDaichoParameter parameter) {
        IJukyushaDaichoMapper mapper = mapperProvider.create(IJukyushaDaichoMapper.class);
        DbT4001JukyushaDaichoEntity entity = mapper.get受給者台帳(parameter);
        if (entity == null) {
            return null;
        } else {
            return new JukyushaDaicho(entity);
        }
    }
}
