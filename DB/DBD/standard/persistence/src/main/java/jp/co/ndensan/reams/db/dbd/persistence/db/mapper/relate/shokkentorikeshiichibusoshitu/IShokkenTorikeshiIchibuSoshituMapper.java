/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shokkentorikeshiichibusoshitu;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 職権修正／職権取消(一部)／認定結果入力(サ変・区変)のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public interface IShokkenTorikeshiIchibuSoshituMapper {

    /**
     * 今回情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 今回情報
     */
    List<ShokkenTorikeshiNinteiJohoKonkaiEntity> select今回情報(RString 申請書管理番号);

    /**
     * 前回情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回情報
     */
    ShokkenTorikeshiNinteiJohoKonkaiEntity select前回情報(RString 申請書管理番号);
}
