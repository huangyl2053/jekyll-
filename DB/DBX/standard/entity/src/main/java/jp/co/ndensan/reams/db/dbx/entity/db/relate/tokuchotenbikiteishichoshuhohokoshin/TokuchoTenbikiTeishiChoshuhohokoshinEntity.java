/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
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
public class TokuchoTenbikiTeishiChoshuhohokoshinEntity {

    private RString 基礎年金番号;
    private RString 年金コード;
    private List<DbV2001ChoshuHohoEntity> 介護徴収方法;

    /**
     * TokuchoTenbikiTeishiChoshuhohokoshinEntityのコンストラクタです。
     */
    public TokuchoTenbikiTeishiChoshuhohokoshinEntity() {
        基礎年金番号 = RString.EMPTY;
        年金コード = RString.EMPTY;
        介護徴収方法 = new ArrayList<>();
    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * TokuchoTenbikiTeishiChoshuhohokoshinEntityが持つ{@link DbT2001ChoshuHohoEntity}<br/>
     * のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        for (DbV2001ChoshuHohoEntity entity : 介護徴収方法) {
            entity.initializeMd5();
        }
    }
}
