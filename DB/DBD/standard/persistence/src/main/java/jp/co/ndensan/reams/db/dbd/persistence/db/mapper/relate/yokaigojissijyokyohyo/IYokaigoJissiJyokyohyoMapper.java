/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigojissijyokyohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001.YokaigoJissiJyokyohyoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JukyushaDaichoTempEntity;

/**
 * 延期通知書出力のMapperです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public interface IYokaigoJissiJyokyohyoMapper {

    /**
     * 受給者台帳マスタを取得する.
     *
     * @param parameter YokaigoJissiJyokyohyoMybatisParameter
     * @return List<JukyushaDaichoTempEntity>
     */
    List<JukyushaDaichoTempEntity> get受給者台帳マスタ(YokaigoJissiJyokyohyoMybatisParameter parameter);
}
