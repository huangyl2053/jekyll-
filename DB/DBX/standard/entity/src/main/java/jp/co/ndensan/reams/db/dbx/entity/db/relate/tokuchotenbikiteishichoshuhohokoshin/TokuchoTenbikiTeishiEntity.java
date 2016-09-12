/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴天引き停止徴収方法更新のエンティティです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoTenbikiTeishiEntity {

    private RString 基礎年金番号;
    private RString 年金コード;
    private RString 被保険者番号;

    /**
     * TokuchoTenbikiTeishiEntityのコンストラクタです。
     */
    public TokuchoTenbikiTeishiEntity() {
        基礎年金番号 = RString.EMPTY;
        年金コード = RString.EMPTY;
        被保険者番号 = RString.EMPTY;
    }
}
