/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * {@link DbT5211GetProcess}のキーブレイククラスです。
 */
public class DbT5211GetProcessKeyBreakCore {

    private NinteiChosaDataOutputBatchRelateEntity entity;
    private int count = 0;

    /**
     * コンストラクタです。
     */
    public DbT5211GetProcessKeyBreakCore() {
        entity = new NinteiChosaDataOutputBatchRelateEntity();
    }

    /**
     * キーブレイク処理です。申請書管理番号が異なるときにキーブレイク処理を行います。
     *
     * @param before 1レコード前のEntity
     * @param current 現在のEntity
     * @return キーブレイク処理を行うEntity
     */
    public NinteiChosaDataOutputBatchRelateEntity keyBreakProcess(
            NinteiChosaDataOutputBatchRelateEntity before, NinteiChosaDataOutputBatchRelateEntity current) {
        if (!before.get申請書管理番号().equals(current.get申請書管理番号())) {
            count = 0;
            return entity;
        }
        return null;
    }

    /**
     * 通常の処理です。調査項目連番1～74、調査項目1～74にセットします。74回ループする前提
     *
     * @param current 現在のEntity
     */
    @SuppressWarnings(value = {"cyclomaticcomplexity", "magicnumber", "methodlength"}) //項目数が74件あるため無視する。
    public void usualProcess(NinteiChosaDataOutputBatchRelateEntity current) {
        count++;
        switch (count) {
            case 1:
                entity = current;
                entity.set調査項目連番1(current.get調査項目連番());
                entity.set調査項目1(current.get調査項目());
                break;
            case 2:
                entity.set調査項目連番2(current.get調査項目連番());
                entity.set調査項目2(current.get調査項目());
                break;
            case 3:
                entity.set調査項目連番3(current.get調査項目連番());
                entity.set調査項目3(current.get調査項目());
                break;
            case 4:
                entity.set調査項目連番4(current.get調査項目連番());
                entity.set調査項目4(current.get調査項目());
                break;
            case 5:
                entity.set調査項目連番5(current.get調査項目連番());
                entity.set調査項目5(current.get調査項目());
                break;
            case 6:
                entity.set調査項目連番6(current.get調査項目連番());
                entity.set調査項目6(current.get調査項目());
                break;
            case 7:
                entity.set調査項目連番7(current.get調査項目連番());
                entity.set調査項目7(current.get調査項目());
                break;
            case 8:
                entity.set調査項目連番8(current.get調査項目連番());
                entity.set調査項目8(current.get調査項目());
                break;
            case 9:
                entity.set調査項目連番9(current.get調査項目連番());
                entity.set調査項目9(current.get調査項目());
                break;
            case 10:
                entity.set調査項目連番10(current.get調査項目連番());
                entity.set調査項目10(current.get調査項目());
                break;
            case 11:
                entity.set調査項目連番11(current.get調査項目連番());
                entity.set調査項目11(current.get調査項目());
                break;
            case 12:
                entity.set調査項目連番12(current.get調査項目連番());
                entity.set調査項目12(current.get調査項目());
                break;
            case 13:
                entity.set調査項目連番13(current.get調査項目連番());
                entity.set調査項目13(current.get調査項目());
                break;
            case 14:
                entity.set調査項目連番14(current.get調査項目連番());
                entity.set調査項目14(current.get調査項目());
                break;
            case 15:
                entity.set調査項目連番15(current.get調査項目連番());
                entity.set調査項目15(current.get調査項目());
                break;
            case 16:
                entity.set調査項目連番16(current.get調査項目連番());
                entity.set調査項目16(current.get調査項目());
                break;
            case 17:
                entity.set調査項目連番17(current.get調査項目連番());
                entity.set調査項目17(current.get調査項目());
                break;
            case 18:
                entity.set調査項目連番18(current.get調査項目連番());
                entity.set調査項目18(current.get調査項目());
                break;
            case 19:
                entity.set調査項目連番19(current.get調査項目連番());
                entity.set調査項目19(current.get調査項目());
                break;
            case 20:
                entity.set調査項目連番20(current.get調査項目連番());
                entity.set調査項目20(current.get調査項目());
                break;
            case 21:
                entity.set調査項目連番21(current.get調査項目連番());
                entity.set調査項目21(current.get調査項目());
                break;
            case 22:
                entity.set調査項目連番22(current.get調査項目連番());
                entity.set調査項目22(current.get調査項目());
                break;
            case 23:
                entity.set調査項目連番23(current.get調査項目連番());
                entity.set調査項目23(current.get調査項目());
                break;
            case 24:
                entity.set調査項目連番24(current.get調査項目連番());
                entity.set調査項目24(current.get調査項目());
                break;
            case 25:
                entity.set調査項目連番25(current.get調査項目連番());
                entity.set調査項目25(current.get調査項目());
                break;
            case 26:
                entity.set調査項目連番26(current.get調査項目連番());
                entity.set調査項目26(current.get調査項目());
                break;
            case 27:
                entity.set調査項目連番27(current.get調査項目連番());
                entity.set調査項目27(current.get調査項目());
                break;
            case 28:
                entity.set調査項目連番28(current.get調査項目連番());
                entity.set調査項目28(current.get調査項目());
                break;
            case 29:
                entity.set調査項目連番29(current.get調査項目連番());
                entity.set調査項目29(current.get調査項目());
                break;
            case 30:
                entity.set調査項目連番30(current.get調査項目連番());
                entity.set調査項目30(current.get調査項目());
                break;
            case 31:
                entity.set調査項目連番31(current.get調査項目連番());
                entity.set調査項目31(current.get調査項目());
                break;
            case 32:
                entity.set調査項目連番32(current.get調査項目連番());
                entity.set調査項目32(current.get調査項目());
                break;
            case 33:
                entity.set調査項目連番33(current.get調査項目連番());
                entity.set調査項目33(current.get調査項目());
                break;
            case 34:
                entity.set調査項目連番34(current.get調査項目連番());
                entity.set調査項目34(current.get調査項目());
                break;
            case 35:
                entity.set調査項目連番35(current.get調査項目連番());
                entity.set調査項目35(current.get調査項目());
                break;
            case 36:
                entity.set調査項目連番36(current.get調査項目連番());
                entity.set調査項目36(current.get調査項目());
                break;
            case 37:
                entity.set調査項目連番37(current.get調査項目連番());
                entity.set調査項目37(current.get調査項目());
                break;
            case 38:
                entity.set調査項目連番38(current.get調査項目連番());
                entity.set調査項目38(current.get調査項目());
                break;
            case 39:
                entity.set調査項目連番39(current.get調査項目連番());
                entity.set調査項目39(current.get調査項目());
                break;
            case 40:
                entity.set調査項目連番40(current.get調査項目連番());
                entity.set調査項目40(current.get調査項目());
                break;
            case 41:
                entity.set調査項目連番41(current.get調査項目連番());
                entity.set調査項目41(current.get調査項目());
                break;
            case 42:
                entity.set調査項目連番42(current.get調査項目連番());
                entity.set調査項目42(current.get調査項目());
                break;
            case 43:
                entity.set調査項目連番43(current.get調査項目連番());
                entity.set調査項目43(current.get調査項目());
                break;
            case 44:
                entity.set調査項目連番44(current.get調査項目連番());
                entity.set調査項目44(current.get調査項目());
                break;
            case 45:
                entity.set調査項目連番45(current.get調査項目連番());
                entity.set調査項目45(current.get調査項目());
                break;
            case 46:
                entity.set調査項目連番46(current.get調査項目連番());
                entity.set調査項目46(current.get調査項目());
                break;
            case 47:
                entity.set調査項目連番47(current.get調査項目連番());
                entity.set調査項目47(current.get調査項目());
                break;
            case 48:
                entity.set調査項目連番48(current.get調査項目連番());
                entity.set調査項目48(current.get調査項目());
                break;
            case 49:
                entity.set調査項目連番49(current.get調査項目連番());
                entity.set調査項目49(current.get調査項目());
                break;
            case 50:
                entity.set調査項目連番50(current.get調査項目連番());
                entity.set調査項目50(current.get調査項目());
                break;
            case 51:
                entity.set調査項目連番51(current.get調査項目連番());
                entity.set調査項目51(current.get調査項目());
                break;
            case 52:
                entity.set調査項目連番52(current.get調査項目連番());
                entity.set調査項目52(current.get調査項目());
                break;
            case 53:
                entity.set調査項目連番53(current.get調査項目連番());
                entity.set調査項目53(current.get調査項目());
                break;
            case 54:
                entity.set調査項目連番54(current.get調査項目連番());
                entity.set調査項目54(current.get調査項目());
                break;
            case 55:
                entity.set調査項目連番55(current.get調査項目連番());
                entity.set調査項目55(current.get調査項目());
                break;
            case 56:
                entity.set調査項目連番56(current.get調査項目連番());
                entity.set調査項目56(current.get調査項目());
                break;
            case 57:
                entity.set調査項目連番57(current.get調査項目連番());
                entity.set調査項目57(current.get調査項目());
                break;
            case 58:
                entity.set調査項目連番58(current.get調査項目連番());
                entity.set調査項目58(current.get調査項目());
                break;
            case 59:
                entity.set調査項目連番59(current.get調査項目連番());
                entity.set調査項目59(current.get調査項目());
                break;
            case 60:
                entity.set調査項目連番60(current.get調査項目連番());
                entity.set調査項目60(current.get調査項目());
                break;
            case 61:
                entity.set調査項目連番61(current.get調査項目連番());
                entity.set調査項目61(current.get調査項目());
                break;
            case 62:
                entity.set調査項目連番62(current.get調査項目連番());
                entity.set調査項目62(current.get調査項目());
                break;
            case 63:
                entity.set調査項目連番63(current.get調査項目連番());
                entity.set調査項目63(current.get調査項目());
                break;
            case 64:
                entity.set調査項目連番64(current.get調査項目連番());
                entity.set調査項目64(current.get調査項目());
                break;
            case 65:
                entity.set調査項目連番65(current.get調査項目連番());
                entity.set調査項目65(current.get調査項目());
                break;
            case 66:
                entity.set調査項目連番66(current.get調査項目連番());
                entity.set調査項目66(current.get調査項目());
                break;
            case 67:
                entity.set調査項目連番67(current.get調査項目連番());
                entity.set調査項目67(current.get調査項目());
                break;
            case 68:
                entity.set調査項目連番68(current.get調査項目連番());
                entity.set調査項目68(current.get調査項目());
                break;
            case 69:
                entity.set調査項目連番69(current.get調査項目連番());
                entity.set調査項目69(current.get調査項目());
                break;
            case 70:
                entity.set調査項目連番70(current.get調査項目連番());
                entity.set調査項目70(current.get調査項目());
                break;
            case 71:
                entity.set調査項目連番71(current.get調査項目連番());
                entity.set調査項目71(current.get調査項目());
                break;
            case 72:
                entity.set調査項目連番72(current.get調査項目連番());
                entity.set調査項目72(current.get調査項目());
                break;
            case 73:
                entity.set調査項目連番73(current.get調査項目連番());
                entity.set調査項目73(current.get調査項目());
                break;
            case 74:
                entity.set調査項目連番74(current.get調査項目連番());
                entity.set調査項目74(current.get調査項目());
                break;
            default:
                throw new SystemException("認定調査票（概況調査）施設利用テーブルのデータ数が誤っています。75以上存在します。");
        }
    }

    /**
     * 最終行の処理です。処理対象のEntityを返します。
     *
     * @return 処理対象のEntity
     */
    public NinteiChosaDataOutputBatchRelateEntity getLastLow() {
        return entity;
    }
}
