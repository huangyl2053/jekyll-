/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.soufujouhou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.SoufuJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.soufujouhou.SoufuJouhouRelateEntity;

/**
 * 再審査申立送付情報照会のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3050-010 zhangzhiming
 */
public interface ISoufuJouhouMapper {

    /**
     * 再審査申立送付情報取得します。
     *
     * @param 再審査申立送付検索条件 再審査申立送付検索条件
     * @return List<SoufuJouhouRelateEntity>
     */
    List<SoufuJouhouRelateEntity> select再審査申立送付情報(SoufuJouhouParameter 再審査申立送付検索条件);

}
