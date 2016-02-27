/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * select介護認定審査会割当情報ByKey_審査順確定フラグ非一致パラメータクラス。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiOrderKakuteiFlagMapperParameter {

    private final RString shinsakaiKaisaiNo;
    private final ShinseishoKanriNo shinseishoKanriNo;
    private final boolean shinsakaiOrderKakuteiFlag;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param shinsakaiOrderKakuteiFlag shinsakaiOrderKakuteiFlag
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShinsakaiOrderKakuteiFlagMapperParameter(
            RString shinsakaiKaisaiNo,
            ShinseishoKanriNo shinseishoKanriNo,
            boolean shinsakaiOrderKakuteiFlag) {

        this.shinsakaiKaisaiNo = requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        this.shinseishoKanriNo = requireNonNull(shinseishoKanriNo, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.shinsakaiOrderKakuteiFlag = requireNonNull(
                shinsakaiOrderKakuteiFlag, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順確定フラグ"));
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiKaisaiNo RString
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param shinsakaiOrderKakuteiFlag shinsakaiOrderKakuteiFlag
     * @return 身体手帳検索パラメータ
     */
    public static ShinsakaiOrderKakuteiFlagMapperParameter createSelectByKeyParam(
            RString shinsakaiKaisaiNo,
            ShinseishoKanriNo shinseishoKanriNo,
            boolean shinsakaiOrderKakuteiFlag) {
        return new ShinsakaiOrderKakuteiFlagMapperParameter(shinsakaiKaisaiNo, shinseishoKanriNo, shinsakaiOrderKakuteiFlag);
    }
}
