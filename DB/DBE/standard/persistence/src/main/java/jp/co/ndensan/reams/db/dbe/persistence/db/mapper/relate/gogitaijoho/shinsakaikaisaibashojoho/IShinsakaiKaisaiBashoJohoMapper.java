/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.shinsakaikaisaibashojoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開催場所情報に関するMapperです。
 */
public interface IShinsakaiKaisaiBashoJohoMapper {

    /**
     * 指定したコードの審査会開催場所が、他のテーブルに登録されているかどうかを判定します。<br/>
     * 対象のテーブルは、DbT5501ShinsakaiKaisaiYoteiJoho、DbT5511ShinsakaiKaisaiKekkaJoho、DbT5591GogitaiJohoです。
     *
     * @param 開催場所コード 開催場所コード
     * @return 他テーブルで使用中ならTrue
     */
    boolean is開催場所削除不可(RString 開催場所コード);
}
