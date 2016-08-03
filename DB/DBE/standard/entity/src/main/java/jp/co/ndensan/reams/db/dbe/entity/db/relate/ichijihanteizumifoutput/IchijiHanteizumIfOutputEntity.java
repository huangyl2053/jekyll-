/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumifoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE309001_一次判定IF作成のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijiHanteizumIfOutputEntity {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 認定申請日;
    private RString 申請区分申請時コード;
}
