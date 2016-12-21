/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * バッチ認定調査データ出力（モバイル）の概況特記事項データ出力RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaGaikyoTokkiDataRelateEntity implements IDbAccessable {

    private RString 申請書管理番号;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private RString 概況特記事項主訴;
    private RString 概況特記事項家族状況;
    private RString 概況特記事項居住環境;
    private RString 概況特記事項機器器械;

}
