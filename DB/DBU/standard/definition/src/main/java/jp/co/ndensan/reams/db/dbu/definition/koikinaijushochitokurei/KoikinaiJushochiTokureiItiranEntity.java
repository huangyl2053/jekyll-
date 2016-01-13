/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 広域内住所地特例者一覧表情報Entity
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochiTokureiItiranEntity {
    
    private final RString 並び順;
    private final RString 改頁;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final List<KoikinaiJushochiTokureiEntity> 広域内住所地特例者List;
    
    /**
     * コンストラクタです。
     * @param 並び順 並び順
     * @param 改頁 改頁
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @param 広域内住所地特例者List 広域内住所地特例者List 
     */
    public KoikinaiJushochiTokureiItiranEntity(RString 並び順,
            RString 改頁,
            RString 市町村コード,
            RString 市町村名,
            List<KoikinaiJushochiTokureiEntity> 広域内住所地特例者List) {
        this.並び順 = 並び順;
        this.改頁 = 改頁;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.広域内住所地特例者List = 広域内住所地特例者List;
    }
    
}
