/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.hokenshajohosoufu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 保険者情報送付の共有ファイルエントリ情報の取得のパラメータクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HokenshaJoHoParamter {

    private final RString fileName;
    private final RString fileId;

    private HokenshaJoHoParamter(RString fileName, RString fileId) {
        this.fileId = fileId;
        this.fileName = fileName;
    }

    /**
     * 保険者情報送付の共有ファイルエントリ情報の取得のパラメータを作成します。
     *
     * @param fileName 共有ファイル名
     * @param fileId 共有ファイルエントリーの作成日時
     * @return パラメータ
     */
    public static HokenshaJoHoParamter createParam(RString fileName, RString fileId) {
        return new HokenshaJoHoParamter(fileName, fileId);
    }

}
