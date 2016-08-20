/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigojissijyokyohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd581001.YokaigoJissiJyokyohyoHakkouMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001.JissiJyokyohyoHakkouEntity;

/**
 * 実施状況を取得のMapperです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
public interface IYokaigoJissiJyokyohyoHakkouMapper {

    /**
     * DBT51001の場合のデータを取得する.
     *
     * @param parameter YokaigoJissiJyokyohyoHakkouMybatisParameter
     * @return List<JissiJyokyohyoHakkouEntity>
     */
    List<JissiJyokyohyoHakkouEntity> getDBT51001の場合のデータ(YokaigoJissiJyokyohyoHakkouMybatisParameter parameter);

    /**
     * 帳票DBD300004の場合のデータを取得する.
     *
     * @param parameter YokaigoJissiJyokyohyoHakkouMybatisParameter
     * @return List<JissiJyokyohyoHakkouEntity>
     */
    List<JissiJyokyohyoHakkouEntity> get帳票DBD300004の場合のデータ(YokaigoJissiJyokyohyoHakkouMybatisParameter parameter);

}
