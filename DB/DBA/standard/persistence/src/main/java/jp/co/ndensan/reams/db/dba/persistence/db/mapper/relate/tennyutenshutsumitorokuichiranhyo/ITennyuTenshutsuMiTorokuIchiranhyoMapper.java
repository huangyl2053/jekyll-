/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tennyutenshutsumitorokuichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuHosyutaiSyosyaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TensyuHosyutaiSyosyaEntity;

/**
 *
 * 転入転出未登録一覧表Mapperクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
public interface ITennyuTenshutsuMiTorokuIchiranhyoMapper {

    /**
     * 転入保留対象者を取得。
     *
     * @param parameter 転入保留対象者用パラメータ
     * @return TennyuHosyutaiSyosyaEntity
     */
    List<TennyuHosyutaiSyosyaEntity> get転入保留対象者(TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter parameter);

    /**
     * 転出保留対象者を取得。
     *
     * @param parameter 転出保留対象者用パラメータ
     * @return TensyuHosyutaiSyosyaEntity
     */
    List<TensyuHosyutaiSyosyaEntity> get転出保留対象者(TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter parameter);
}
