/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * CSV出力対象のTEMPテーブル定義のエンティティです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class OutputTaishoTempEntity implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("OutputTaishoTemp");

    private RString shinseishoKanriNo;
}
