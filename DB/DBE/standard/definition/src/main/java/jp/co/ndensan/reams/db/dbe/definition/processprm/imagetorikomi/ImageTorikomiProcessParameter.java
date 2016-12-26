/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.imagetorikomi;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込（規定・規定外）のプロセスパラメータクラスです
 *
 * @author n2818
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageTorikomiProcessParameter implements IBatchProcessParameter {

    private final RDate 処理日;
    private final RString ファイルPath;
    private List<RString> ファイルList;

    /**
     * コンストラクタ
     *
     * @param 処理日
     * @param ファイルPath ファイルPath
     *
     */
    public ImageTorikomiProcessParameter(
            RDate 処理日,
            RString ファイルPath
    ) {
        this.処理日 = 処理日;
        this.ファイルPath = ファイルPath;
    }
}
