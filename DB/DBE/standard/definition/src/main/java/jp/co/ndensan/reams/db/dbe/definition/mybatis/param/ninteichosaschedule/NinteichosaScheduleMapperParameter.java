/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaschedule;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaScheduleMapperParameter {

    private final FlexibleDate ninteiChosaYoteiYMD;
    private final RString ninteiChosaYoteiKaishiTime;
    private final RString ninteiChosaYoteiShuryoTime;
    private final Code ninteiChosaJikanWaku;
    private final Code chosaChikuCode;
    private final RString ninteichosaItakusakiCode;
    private final RString ninteiChosainNo;
    private final LasdecCode shichosonCode;

// TODO 用途に応じてアクセス修飾子を修正してください。
    /**
     * コンストラクタです。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @param uses主キー1 uses主キー1
     * @param uses主キー2 uses主キー2
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteichosaScheduleMapperParameter(
            FlexibleDate ninteiChosaYoteiYMD,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku,
            Code chosaChikuCode,
            RString ninteichosaItakusakiCode,
            RString ninteiChosainNo,
            LasdecCode shichosonCode) {
        this.ninteiChosaYoteiYMD = ninteiChosaYoteiYMD;
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
        this.chosaChikuCode = chosaChikuCode;
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
        this.ninteiChosainNo = ninteiChosainNo;
        this.shichosonCode = shichosonCode;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @return 身体手帳検索パラメータ
     */
    public static NinteichosaScheduleMapperParameter createSelectByKeyParam(
            FlexibleDate ninteiChosaYoteiYMD,
            RString ninteiChosaYoteiKaishiTime,
            RString ninteiChosaYoteiShuryoTime,
            Code ninteiChosaJikanWaku,
            Code chosaChikuCode,
            RString ninteichosaItakusakiCode,
            RString ninteiChosainNo,
            LasdecCode shichosonCode) {
        return new NinteichosaScheduleMapperParameter(ninteiChosaYoteiYMD, ninteiChosaYoteiKaishiTime, ninteiChosaYoteiShuryoTime, ninteiChosaJikanWaku, chosaChikuCode, ninteichosaItakusakiCode, ninteiChosainNo, shichosonCode);
    }

}
