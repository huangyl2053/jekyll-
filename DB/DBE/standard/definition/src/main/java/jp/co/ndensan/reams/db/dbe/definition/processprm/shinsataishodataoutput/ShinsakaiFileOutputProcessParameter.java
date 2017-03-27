/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;

/**
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class ShinsakaiFileOutputProcessParameter implements IBatchProcessParameter {

    private final RString kaisaiBangou;
    private final RString tempPath;
    private final AccessLogUUID accessLogUUID;

    /**
     * @param kaisaiBangou 開催番号
     * @param tempPath テンプディレクトリパス
     * @param accessLogUUID アクセスログUUID
     */
    public ShinsakaiFileOutputProcessParameter(RString kaisaiBangou, RString tempPath, AccessLogUUID accessLogUUID) {
        this.kaisaiBangou = kaisaiBangou;
        this.tempPath = tempPath;
        this.accessLogUUID = accessLogUUID;
    }

}
