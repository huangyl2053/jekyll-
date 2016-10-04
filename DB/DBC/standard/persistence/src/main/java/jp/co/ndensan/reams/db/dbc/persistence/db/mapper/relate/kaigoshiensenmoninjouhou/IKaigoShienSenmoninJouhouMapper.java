
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigoshiensenmoninjouhou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigoshiensenmoninjouhou.KaigoShienSenmoninJouhouEntity;

/**
 * 介護支援専門員登録画面 Mapperクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public interface IKaigoShienSenmoninJouhouMapper {

    /**
     * 介護支援専門員情報を取得します。
     *
     * @param param KaigoShienSenmoninJouhouParameter
     * @return KaigoShienSenmoninJouhouEntityのリスト
     */
    List<KaigoShienSenmoninJouhouEntity> select介護支援専門員情報(KaigoShienSenmoninJouhouParameter param);

    /**
     * 介護支援専門員番号の重複チェックを取得します。
     *
     * @param param KaigoShienSenmoninJouhouParameter
     * @return int
     */
    int select介護支援専門員番号の重複チェック(KaigoShienSenmoninJouhouParameter param);
}
