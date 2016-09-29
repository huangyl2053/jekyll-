/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報IFファイル作成_バッチ処理パラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MakeNinteiShinseiJohoFileProcessParameter implements IBatchProcessParameter {

    private RString 連携ファイル名;
    private RString 連携データ種類;
    private RString 証記載保険者番号;
    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RDateTime 抽出開始日時;
    private RDateTime 抽出終了日時;
}
